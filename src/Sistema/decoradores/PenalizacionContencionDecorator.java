package sistema.decoradores;

import sistema.Sistema;
import sistema.SistemaDecorator;

public class PenalizacionContencionDecorator extends SistemaDecorator
{
    // --------------------------- Constructores
    public PenalizacionContencionDecorator(Sistema envuelto)
    {
        super(envuelto);
    }
    // ------------------------ Métodos Públicos
    @Override
    public int getContencion()
    {
        return super.getContencion() - 10;
    }
}
