package sistema;

public class MejoraContencionDecorator extends SistemaDecorator
{
    // --------------------------- Constructores
    public MejoraContencionDecorator(Sistema envuelto)
    {
        super(envuelto);
    }
    // ------------------------ Métodos Públicos
    @Override
    public int getContencion()
    {
        return super.getContencion() + 10;
    }
}
