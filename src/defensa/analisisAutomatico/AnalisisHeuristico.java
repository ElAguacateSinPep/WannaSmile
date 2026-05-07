package defensa.analisisAutomatico;

import defensa.AnalisisStrategy;
import gui.MenuConsola;

public class AnalisisHeuristico implements AnalisisStrategy
{
    // ------------------------ Métodos Públicos
    public int ejecutarAnalisisAutomatico()
    {
        MenuConsola menu = new MenuConsola();
        int variacionDeteccion = 0;

        menu.logsAnalisisHeuristico();
        variacionDeteccion += 50;

        menu.verVariacionDeteccion(variacionDeteccion);

        return variacionDeteccion;
    }
}