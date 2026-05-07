package defensa.analisisAutomatico;

import defensa.AnalisisStrategy;
import gui.*;

public class AnalisisRapido implements AnalisisStrategy
{
    // ------------------------ Métodos Públicos
    public int ejecutarAnalisisAutomatico()
    {
        MenuConsola menu = new MenuConsola();
        int variacionDeteccion = 0;

        menu.logsAnalisisRaido();
        variacionDeteccion -= 10;

        menu.printVariacionDeteccion(variacionDeteccion);

        return variacionDeteccion;
    }
}
