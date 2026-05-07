package defensa.analisisAutomatico;

import defensa.AnalisisStrategy;

public class AnalisisRapido implements AnalisisStrategy
{
    // ------------------------ Métodos Públicos
    public int ejecutarAnalisisAutomatico()
    {
        int variacionDeteccion = 0;
        variacionDeteccion -= 10;
        return variacionDeteccion;
    }
}
