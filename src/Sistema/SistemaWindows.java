package sistema;

public class SistemaWindows extends SistemaBase
{
    // --------------------------- Constructores
    public SistemaWindows()
    {
        this.arquitectura = "x64";
    }
    // --------------------------------- Getters
    @Override
    public String getNombre()
    {
        return "Dell XPS";
    }

    @Override
    public String getSO()
    {
        return "Windows";
    }

    @Override
    public int getDeteccion()
    {
        return 60;
    }

    @Override
    public int getContencion()
    {
        return 40;
    }
}
