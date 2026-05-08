package defensa;

import utils.Utils;

import defensa.analisis.AnalisisHeuristicoStrategy;
import defensa.analisis.AnalisisProfundoStrategy;
import defensa.analisis.AnalisisRapidoStrategy;
import defensa.estados.AmenazaDetectadaState;
import defensa.estados.NoDetectadoState;
import defensa.estados.SeguroState;
import gui.MenuConsola;
import malware.*;
import sistema.*;

public class Antivirus
{
    // ------------------------------- Atributos
    private Malware          malware;
    private Sistema          sistema;
    private AnalisisStrategy analisisStrategy;
    private AntivirusState   state;

    public Antivirus()
    {
        this.state = new SeguroState();
    }

    // --------------------------------- Setters
    public void setMalware(Malware malware)
    {
        this.malware = malware;
    }

    public void setSistema(Sistema sistema)
    {
        this.sistema = sistema;
    }

    public void setEstado(AntivirusState state)
    {
        this.state = state;
    }

    // ------------------------ Métodos Públicos

    // <Template Method>
    public void protocoloAntiIndicentes()
    {
        if (analizarArchivo())
        {
            MenuConsola.menu.printMalwareDetectado();
            responderAnteIncidentes();
        }

        // Comportamiento común TEMPALTE METHOD
        mostrarResultado();
    }
    // </Template Method>

    // ------------------------ Métodos Privados
    private boolean analizarArchivo()
    {
        boolean detectado;
        int sigilo = this.malware.getSigilo();
        int deteccion = this.sistema.getDeteccion();

        MenuConsola.menu.printStatsAnalisis(deteccion, sigilo);

        /**
         * - Análisis Manual
         * - Implementado de manera diferente segun el SO
         * - Afecta a Sigilo (Malware)
         */
        MenuConsola.menu.printInicioAnalisisManual();
        sigilo += this.sistema.ejecutarAnalisisManual();
        sigilo = ajustarStats(sigilo);
        MenuConsola.menu.printStatsAnalisis(deteccion, sigilo);

        /**
         * - Análisis Automático.
         * - Depende de la estrategia, puede ser:
         * - Rápido
         * - Profundo
         * - Heurístico
         * - Afecta a la Detección (Sistema)
         */
        MenuConsola.menu.printInicioAnalisisAutomatico();
        setAnalisisStrategy();
        deteccion += this.analisisStrategy.ejecutarAnalisisAutomatico();
        deteccion = ajustarStats(deteccion);
        MenuConsola.menu.printStatsAnalisis(deteccion, sigilo);

        // Resultado análisis
        if (deteccion >= sigilo) // Malware detectado
        {
            detectado = true;
            setEstado(new AmenazaDetectadaState());
        }
        else // Malware NO detectado
        {
            detectado = false;
            setEstado(new NoDetectadoState());
        }

        return detectado;
    }

    private void responderAnteIncidentes()
    {
        int contencion = this.sistema.getContencion();
        int propagacion = this.malware.getPropagacion();

        MenuConsola.menu.printStatsRespuesta(propagacion, contencion);
        MenuConsola.menu.printInicioRespuesta();

        // Protocolo de respuesta, implementado por cada sistema
        contencion += this.sistema.ejecutarProtocoloContencion();
        contencion = ajustarStats(contencion);

        MenuConsola.menu.printStatsRespuesta(propagacion, contencion);

        // Resultado respuesta
        if (contencion >= propagacion) // Malware Neutralizado
        {
            state.avanzarEstado(this);
        }
    }

    private void mostrarResultado()
    {
        Utils.esperar(2000);
        state.printEstado();
    }

    private void setAnalisisStrategy()
    {
        switch (MenuConsola.menu.seleccionarTipoAnalisisAutomatico())
        {
            case 1:
                this.analisisStrategy = new AnalisisRapidoStrategy();
                break;
            case 2:
                this.analisisStrategy = new AnalisisProfundoStrategy();
                break;
            case 3:
                this.analisisStrategy = new AnalisisHeuristicoStrategy();
                break;
            default:
                this.analisisStrategy = new AnalisisProfundoStrategy();
                break;
        }
    }

    /**
     * @brief asegura que no nos encontraremos:
     *        - valores negativos
     *        - valores superiores a 100
     * @param valor
     * @return
     */
    private int ajustarStats(int valor)
    {
        if (valor > 100)
            return 100;
        else if (valor < 0)
            return 0;
        else
            return valor;
    }
}
