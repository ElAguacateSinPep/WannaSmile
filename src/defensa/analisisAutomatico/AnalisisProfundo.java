package defensa.analisisAutomatico;

import defensa.AnalisisStrategy;
import gui.MenuConsola;

public class AnalisisProfundo implements AnalisisStrategy
{
    // ------------------------ Métodos Públicos
    public int ejecutarAnalisisAutomatico()
    {
        MenuConsola menu = new MenuConsola();
        int variacionDeteccion = 0;

        menu.logsAnalisisProfundo();
        variacionDeteccion += 10;

        menu.verVariacionDeteccion(variacionDeteccion);


        return variacionDeteccion;
    }
}
