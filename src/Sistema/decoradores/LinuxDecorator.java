package sistema.decoradores;

import sistema.Sistema;
import sistema.SistemaDecorator;
import sistema.protocolos.GestorAnalisis;
import sistema.protocolos.GestorContencion;

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
        return GestorContencion.contencionLinux();
    }
}
