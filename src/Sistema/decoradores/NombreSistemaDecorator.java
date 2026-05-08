package sistema.decoradores;

import sistema.Sistema;
import sistema.SistemaDecorator;

public class NombreSistemaDecorator extends SistemaDecorator
{
    // ------------------------------- Atributos
    private String nombrePersonalizado;
    // --------------------------- Constructores
    public NombreSistemaDecorator(Sistema envuelto, String nombre)
    {
        super(envuelto);
        this.nombrePersonalizado = nombre;
    }
    // ------------------------ Métodos Públicos
    @Override
    public String getNombre()
    {
        return this.nombrePersonalizado; // Pisa el nombre por defecto
    }
}
