package defensa.analisisAutomatico;

import defensa.AnalisisStrategy;
import gui.MenuConsola;

public class AnalisisHeuristico implements AnalisisStrategy
{
    // ------------------------ Métodos Públicos
    public int ejecutarAnalisisAutomatico()
    {
        int variacionDeteccion = 0;

        MenuConsola.menu.logsAnalisisHeuristico();
        variacionDeteccion += 50;

        MenuConsola.menu.printVariacionDeteccion(variacionDeteccion);

        return variacionDeteccion;
    }
}