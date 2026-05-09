package sistema.decoradores;

import sistema.Sistema;
import sistema.SistemaDecorator;
import utilidades.GestionProtocolos;
import utilidades.GestorAnalisis;

public class LinuxDecorator extends SistemaDecorator
{
    public LinuxDecorator(Sistema envuelto)
    {
        super(envuelto);
    }

    @Override
    public String getSO()
    {
        return "Linux";
    }

    @Override
    public int ejecutarAnalisisManual()
    {
        return GestorAnalisis.analisisLinux();
    }

    @Override
    public int ejecutarProtocoloContencion()
    {
        return GestionProtocolos.contencionLinux();
    }
}
