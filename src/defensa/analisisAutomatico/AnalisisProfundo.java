package defensa.analisisAutomatico;

import defensa.AnalisisStrategy;

public class AnalisisProfundo implements AnalisisStrategy
{
    // ------------------------ Métodos Públicos
    public int ejecutarAnalisisAutomatico()
    {
        int variacionDeteccion = 0;
        variacionDeteccion += 30;
        return variacionDeteccion;
    }
}
