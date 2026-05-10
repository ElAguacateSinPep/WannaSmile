package sistema;

import sistema.tipos.*;

public class SistemaFactory
{
    // --------------------------- Constructores
    public Sistema crearSistemaPreconfigurado(int opcion)
    {
        switch (opcion) {
            case 1:
                return new SistemaWindows();
            case 2:
                return new SistemaMac();
            case 3:
                return new SistemaLinux();
            default:
                return new SistemaWindows();
        }
    }
    // ------------------------ Métodos Públicos
    public Sistema crearSistemaBase()
    {
        return new SistemaBase();
    }
}
