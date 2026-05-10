package defensa.analisis;

import defensa.AnalisisStrategy;
import ui.MenuConsola;

public class AnalisisRapidoStrategy implements AnalisisStrategy
{
    // ------------------------------- Atributos
    private static final int DISMINUCION_ANALISIS_HEURISTICO = -10;

    // ------------------------ Métodos Públicos
    public int ejecutarAnalisisAutomatico()
    {
        int variacionDeteccion = 0;

        MenuConsola.menu.logsAnalisisRaido();
        variacionDeteccion += DISMINUCION_ANALISIS_HEURISTICO;

        MenuConsola.menu.printVariacionDeteccion(variacionDeteccion);

        return variacionDeteccion;
    }
}
