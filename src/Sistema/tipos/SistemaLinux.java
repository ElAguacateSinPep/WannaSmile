package sistema.tipos;

import utilidades.GestorAnalisis;
import sistema.SistemaBase;
import utilidades.GestionProtocolos;

public class SistemaLinux extends SistemaBase
{
    public SistemaLinux()
    {
        this.arquitectura = "x86";
    }

    @Override
    public String getNombre()
    {
        return "Thinkpad";
    }

    @Override
    public String getSO()
    {
        return "Linux";
    }

    @Override
    public int getDeteccion()
    {
        return 75;
    }

    @Override
    public int getContencion()
    {
        return 25;
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
