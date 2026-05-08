package sistema.decoradores;

import sistema.Sistema;
import sistema.SistemaDecorator;

public class ContencionDecorator extends SistemaDecorator
{
    // ------------------------------- Atributos
    private int puntosContencion;
    // --------------------------- Constructores
    public ContencionDecorator(Sistema envuelto, int puntosDeteccion)
    {
        super(envuelto);
        this.puntosContencion = 100 - puntosDeteccion;
    }
    // ------------------------ Métodos Públicos
    @Override
    public int getContencion()
    {
        return this.puntosContencion;
    }
}
