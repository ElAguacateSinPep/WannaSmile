package sistema.decoradores;

import sistema.Sistema;
import sistema.SistemaDecorator;

public class ArquitecturaDecorator extends SistemaDecorator
{
    // ------------------------------- Atributos
    private String arquitecturaElegida;
    // --------------------------- Constructores
    public ArquitecturaDecorator(Sistema envuelto, int opcionMenu)
    {
        super(envuelto);

        switch (opcionMenu) {
            case 1:
                this.arquitecturaElegida = "x64";
                break;
            case 2:
                this.arquitecturaElegida = "x86";
                break;
            case 3:
                this.arquitecturaElegida = "ARM";
                break;
            default:
                this.arquitecturaElegida = "Desconocida";
                break;
        }
    }
    // ------------------------ Métodos Públicos
    @Override
    public String getArquitectura()
    {
        return this.arquitecturaElegida;
    }
}
