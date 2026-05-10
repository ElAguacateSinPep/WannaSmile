package defensa.analisis;

import defensa.AnalisisStrategy;
import ui.MenuConsola;

public class AnalisisProfundoStrategy implements AnalisisStrategy
{
    // ------------------------------- Atributos
    private static final int AUMENTO_ANALISIS_PROFUNDO = 10;

    // ------------------------ Métodos Públicos
    public int ejecutarAnalisisAutomatico()
    {
        int variacionDeteccion = 0;

        MenuConsola.menu.logsAnalisisProfundo();
        variacionDeteccion += AUMENTO_ANALISIS_PROFUNDO;

        MenuConsola.menu.printVariacionDeteccion(variacionDeteccion);

        return variacionDeteccion;
    }
}
