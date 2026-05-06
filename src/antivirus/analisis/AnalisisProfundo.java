package antivirus.analisis;

import antivirus.AnalisisStrategy;

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
