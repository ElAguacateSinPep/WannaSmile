package antivirus.analisis;

import antivirus.AnalisisStrategy;

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
