package defensa;

import defensa.analisisAutomatico.AnalisisHeuristico;
import defensa.analisisAutomatico.AnalisisProfundo;
import defensa.analisisAutomatico.AnalisisRapido;
import gui.MenuConsola;
import malware.*;
import sistema.*;

public class Antivirus
{
    // ------------------------------- Atributos
    private Malware          malware;
    private Sistema          sistema;
    private AnalisisStrategy analisisStrategy;
    private MenuConsola      menu = new MenuConsola();

    // --------------------------------- Setters
    public void setMalware(Malware malware)
    {
        this.malware = malware;
    }

    public void setSistema(Sistema sistema)
    {
        this.sistema = sistema;
    }

    // ------------------------ Métodos Públicos

    // <Template Method>
    public void protocoloAntiIndicentes()
    {
        if (analizarArchivo())
        {
            menu.printMalwareDetectado();
            responderAnteIncidentes();
        }

        // Comportamiento común TEMPALTE METHOD
        mostrarResultado();
    }
    // </Template Method>

    // ------------------------ Métodos Privados
    private boolean analizarArchivo()
    {
        int sigilo = malware.getSigilo();
        int deteccion = sistema.getDeteccion();

        menu.printStatsAnalisis(deteccion, sigilo);

        // Inicio Análisis Manual
        // Implementado de manera diferente segun el SO
        // Afecta a Sigilo del Malware
        menu.printInicioAnalisisManual();
        sigilo += sistema.ejecutarAnalisisManual();
        sigilo = ajustarStats(sigilo);
        menu.printStatsAnalisis(deteccion, sigilo);
        // Fin Análisis Manual

        // Inicio Análisis Automático
        // Puede ser: Rápido, profundo o Heurístico
        // Depende de la estrategia seleccionada
        // Afecta a la Detección del Sistema
        menu.printInicioAnalisisAutomatico();
        setAnalisisStrategy();
        deteccion += analisisStrategy.ejecutarAnalisisAutomatico();
        deteccion = ajustarStats(deteccion);
        menu.printStatsAnalisis(deteccion, sigilo);
        // Inicio Análisis Automático

        // todo Actualizar estado
        // todo delegar a mostrar resultado
        if (deteccion < sigilo)
        {
            System.out.println(MenuConsola.AMARILLO
                + "DEBUG CASO I: Jugador 2 ha perdido.\n"
                + "Amenaza no detectada y sistema infectado."); // todo debug
        }

        return deteccion >= sigilo;
    }

    private void responderAnteIncidentes()
    {
        int contencion = sistema.getContencion();
        int propagacion = malware.getPropagacion();

        menu.printStatsRespuesta(propagacion, contencion);

        menu.printInicioRespuesta();
        contencion += sistema.ejecutarProtocoloContencion();
        contencion = ajustarStats(contencion);
        menu.printStatsRespuesta(propagacion, contencion);

        // todo Actualizar estado
        if (contencion < propagacion)
        {
            System.out.println(MenuConsola.AMARILLO
                + "DEBUG CASO II: Jugador 2 ha perdido.\n"
                + "Amenaza detectada pero sistema infectado."); // todo debug
        }
        else if (contencion >= propagacion)
        {
            System.out.println(MenuConsola.AMARILLO
                + "DEBUG CASO III: Jugador 2 ha ganado.\n"
                + "Amenaza detectada y neutralizada."); // todo debug
        }
    }

    private void mostrarResultado()
    {
        // todo estado: toString
    }

    private void setAnalisisStrategy()
    {
        switch (menu.seleccionarTipoAnalisisAutomatico())
        {
            case 1:
                analisisStrategy = new AnalisisRapido();
                break;
            case 2:
                analisisStrategy = new AnalisisProfundo();
                break;
            case 3:
                analisisStrategy = new AnalisisHeuristico();
                break;
            default:
                analisisStrategy = new AnalisisProfundo();
                break;
        }
    }

    /**
     * @brief asegura que no nos encontrames:
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
