package sistema;

public abstract class SistemaDecorator implements Sistema
{
    // ------------------------------- Atributos
    protected Sistema sistemaEnvuelto;

    // --------------------------- Constructores
    public SistemaDecorator(Sistema envuelto)
    {
        this.sistemaEnvuelto = envuelto;
    }

    // ------------------------ Métodos Públicos
    @Override
    public String getNombre()
    {
        return sistemaEnvuelto.getNombre();
    }

    @Override
    public String getSO()
    {
        return sistemaEnvuelto.getSO();
    }

    @Override
    public String getArquitectura()
    {
        return sistemaEnvuelto.getArquitectura();
    }

    @Override
    public int getDeteccion()
    {
        return sistemaEnvuelto.getDeteccion();
    }

    @Override
    public int getContencion()
    {
        return sistemaEnvuelto.getContencion();
    }

    @Override
    public int ejecutarAnalisisManual()
    {
        return sistemaEnvuelto.ejecutarAnalisisManual();
    }

    @Override
    public int ejecutarProtocoloContencion()
    {
        return sistemaEnvuelto.ejecutarProtocoloContencion();
    }
}
