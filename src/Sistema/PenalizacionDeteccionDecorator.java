package sistema;

public class PenalizacionDeteccionDecorator extends SistemaDecorator
{
    // --------------------------- Constructores
    public PenalizacionDeteccionDecorator(Sistema envuelto)
    {
        super(envuelto);
    }
    // ------------------------ Métodos Públicos
    @Override
    public int getDeteccion()
    {
        return super.getDeteccion() - 10;
    }
}
