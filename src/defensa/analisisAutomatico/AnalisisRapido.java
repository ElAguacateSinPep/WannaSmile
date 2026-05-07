package defensa.analisisAutomatico;

import defensa.AnalisisStrategy;
import gui.*;

public class AnalisisRapido implements AnalisisStrategy
{
    // ------------------------ Métodos Públicos
    public int ejecutarAnalisisAutomatico()
    {
        int variacionDeteccion = 0;

        MenuConsola.menu.logsAnalisisRaido();
        variacionDeteccion -= 10;

        MenuConsola.menu.printVariacionDeteccion(variacionDeteccion);

        return variacionDeteccion;
    }
}
