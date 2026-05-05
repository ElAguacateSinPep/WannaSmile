package sistema;

public class DeteccionDecorator extends SistemaDecorator
{
    // ------------------------------- Atributos
    private int puntosDeteccion;
    // --------------------------- Constructores
    public DeteccionDecorator(Sistema envuelto, int puntosDeteccion)
    {
        super(envuelto);
        this.puntosDeteccion = puntosDeteccion;
    }
    // ------------------------ Métodos Públicos
    @Override
    public int getDeteccion()
    {
        return this.puntosDeteccion;
    }
}
