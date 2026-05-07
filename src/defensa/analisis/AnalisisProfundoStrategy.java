package defensa.analisis;

import defensa.AnalisisStrategy;
import gui.MenuConsola;

public class AnalisisProfundoStrategy implements AnalisisStrategy
{
    // ------------------------ Métodos Públicos
    public int ejecutarAnalisisAutomatico()
    {
        int variacionDeteccion = 0;

        MenuConsola.menu.logsAnalisisProfundo();
        variacionDeteccion += 10;

        MenuConsola.menu.printVariacionDeteccion(variacionDeteccion);

        return variacionDeteccion;
    }
}
