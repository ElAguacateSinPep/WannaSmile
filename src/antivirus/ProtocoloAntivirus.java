package antivirus;

import antivirus.analisis.AnalisisRapido;
import gui.MenuConsola;
import malware.*;
import sistema.*;

public class ProtocoloAntivirus
{
    // ------------------------------- Atributos
    private Malware malware;
    private Sistema sistema;
    private AnalisisStrategy analisisStrategy;
    private MenuConsola mc;

    // ------------------------ Métodos Públicos

    // <Template Method>
    public void procesarArchivo()
    {
        if (analizarArchivo())
        {
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

        // Análisis Manual: Implementado de manera
        // diferente segun el SO
        sigilo += sistema.ejecutarAnalisisManual();

        // Análisis Automático: Depende de la estrategia deseada
        setAnalisisStrategy();
        deteccion += analisisStrategy.ejecutarAnalisisAutomatico();

        return sigilo >= deteccion;
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
        switch (mc.seleccionarTipoAnalisisAutomatico())
        {
            case 1:  analisisStrategy = new AnalisisRapido(); break;
            case 2:  analisisStrategy = new AnalisisRapido(); break;
            case 3:  analisisStrategy = new AnalisisRapido(); break;
            default: analisisStrategy = new AnalisisRapido(); break;
        }
    }
}
