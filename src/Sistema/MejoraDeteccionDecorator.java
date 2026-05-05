package sistema;

public class MejoraDeteccionDecorator extends SistemaDecorator
{
    // --------------------------- Constructores
    public MejoraDeteccionDecorator(Sistema envuelto)
    {
        super(envuelto);
    }
    // ------------------------ Métodos Públicos
    @Override
    public int getDeteccion()
    {
        return super.getDeteccion() + 10;
    }
}
