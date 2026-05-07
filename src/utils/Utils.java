package utils;

public class Utils
{
    // ------------------------ Métodos Públicos
    public static void esperar(int milisegundos)
    {
        try
        {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
