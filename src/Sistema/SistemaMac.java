package sistema;

public class SistemaMac extends SistemaBase
{
    // --------------------------- Constructores
    public SistemaMac()
    {
        this.arquitectura = "ARM";
    }
    // --------------------------------- Getters
    @Override
    public String getNombre()
    {
        return "Macbook Pro M5";
    }

    @Override
    public String getSO()
    {
        return "macOS";
    }

    @Override
    public int getDeteccion()
    {
        return 50;
    }

    @Override
    public int getContencion()
    {
        return 50;
    }
}
