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
    private Malware malware;
    private Sistema sistema;
    private AnalisisStrategy analisisStrategy;
    private MenuConsola menu = new MenuConsola();

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
            menu.malwareDetectado();
            responder();
        }

        // Comportamiento común TEMPALTE METHOD
        mostrarResultado();
    }

    // ------------------------ Métodos Privados
    private boolean analizarArchivo()
    {
        int sigilo = malware.getSigilo();
        int deteccion = sistema.getDeteccion();

        // todo borrar Debug
        System.out.println(MenuConsola.AMARILLO
            + "DEBUG: sigilo = "
            + sigilo + " | deteccion = "
            + deteccion + MenuConsola.RESET);

        // Análisis Manual: Implementado de manera
        // diferente segun el SO
        menu.inicioAnalisisManual();
        sigilo += sistema.ejecutarAnalisisManual();

        // Análisis Automático: Depende de la estrategia deseada
        menu.inicioAnalisisAutomatico();
        setAnalisisStrategy();
        deteccion += analisisStrategy.ejecutarAnalisisAutomatico();

        return deteccion > sigilo;
    }

    private void responder()
    {

    }

    private void mostrarResultado()
    {

    }
    // </Template Method>

    private void setAnalisisStrategy()
    {
        switch (menu.seleccionarTipoAnalisisAutomatico())
        {
            case 1:  analisisStrategy = new AnalisisRapido(); break;
            case 2:  analisisStrategy = new AnalisisProfundo(); break;
            case 3:  analisisStrategy = new AnalisisHeuristico(); break;
            default: analisisStrategy = new AnalisisProfundo(); break;
        }
    }
}
