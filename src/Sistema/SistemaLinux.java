package sistema;

public class SistemaLinux extends SistemaBase
{
    // --------------------------- Constructores
    public SistemaLinux()
    {
        this.arquitectura = "x86";
    }
    // --------------------------------- Getters
    @Override
    public String getNombre()
    {
        return "Thinkpad";
    }

    @Override
    public String getSO()
    {
        return "Linux";
    }

    @Override
    public int getDeteccion()
    {
        return 75;
    }

    @Override
    public int getContencion()
    {
        return 25;
    }
}
