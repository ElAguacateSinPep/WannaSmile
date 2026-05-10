package defensa.analisis;

import defensa.AnalisisStrategy;
import ui.MenuConsola;

public class AnalisisHeuristicoStrategy implements AnalisisStrategy
{
    // ------------------------------- Atributos
    private static final int AUMENTO_ANALISIS_HEURISTICO = 50;

    // ------------------------ Métodos Públicos
    public int ejecutarAnalisisAutomatico()
    {
        int variacionDeteccion = 0;

        MenuConsola.menu.logsAnalisisHeuristico();
        variacionDeteccion += AUMENTO_ANALISIS_HEURISTICO;

        MenuConsola.menu.printVariacionDeteccion(variacionDeteccion);

        return variacionDeteccion;
    }
}