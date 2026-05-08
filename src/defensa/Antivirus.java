package defensa;

import defensa.analisis.AnalisisHeuristicoStrategy;
import defensa.analisis.AnalisisProfundoStrategy;
import defensa.analisis.AnalisisRapidoStrategy;
import defensa.estados.AmenazaDetectadaState;
import defensa.estados.NoDetectadoState;
import defensa.estados.SeguroState;
import gui.MenuConsola;
import malware.Malware;
import sistema.Sistema;
import utils.Utils;

public class Antivirus
{
    // ------------------------------- Atributos
    private Malware          malware;
    private Sistema          sistema;
    private AnalisisStrategy analisisStrategy;
    private AntivirusState   state;
    private final int        MAX_STATS = 100;
    private final int        MIN_STATS = 0;

    public Antivirus(Sistema sistema, Malware malware)
    {
        this.sistema = sistema;
        this.malware = malware;
        this.state = new SeguroState();
    }

    // ------------------------ Métodos Públicos
    // <Facade y Templaye Method>
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

    // ------------------------ Métodos Privados
    private boolean analizarArchivo()
    {
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

        // <strategy>
        deteccion += this.analisisStrategy.ejecutarAnalisisAutomatico();

        deteccion = ajustarStats(deteccion);
        MenuConsola.menu.printStatsAnalisis(deteccion, sigilo);

        // Resultado análisis
        if (malwareDetectado(deteccion, sigilo))
        {
            cambiarEstado(new AmenazaDetectadaState());
            return true;
        }
        else // Malware NO detectado
        {
            cambiarEstado(new NoDetectadoState());
            return false;
        }

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
        if (malwareNeutralizado(contencion, propagacion))
        {
            // <state>
            // Delegamos el cambio de estado a la subclase
            this.state.avanzarEstado(this);
        }
    }

    private void mostrarResultado()
    {
        Utils.esperar(2000);
        this.state.mostrarDesenlace(this.malware);
    }
    // <Facade y Templaye Method>

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

    // ------------------------ Métodos Públicos
    public void cambiarEstado(AntivirusState state)
    {
        this.state = state;
    }

    // ------------------------ Métodos Privados
    /**
     * @brief asegura que no nos encontraremos:
     *        - valores negativos
     *        - valores superiores a 100
     * @param valor
     * @return entre 0 y 100
     */
    private int ajustarStats(int valor)
    {
        if (valor > MAX_STATS)
            return MAX_STATS;
        else if (valor < MIN_STATS)
            return MIN_STATS;
        else
            return valor;
    }

    private boolean malwareDetectado(int deteccion, int sigilo)
    {
        return deteccion >= sigilo;
    }

    private boolean malwareNeutralizado(int contencion, int propagacion)
    {
        return contencion >= propagacion;
    }
}
