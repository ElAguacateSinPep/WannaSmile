package sistema.tipos;

import sistema.SistemaBase;
import sistema.protocolos.*;
import ui.MenuConsola;

public class SistemaWindows extends SistemaBase
{
    // ------------------------------- Atributos
    MenuConsola menu = new MenuConsola();

    // --------------------------- Constructores
    public SistemaWindows()
    {
        this.arquitectura = "x64";
    }

    // --------------------------------- Getters
    @Override
    public String getNombre()
    {
        return "Dell XPS";
    }

    @Override
    public String getSO()
    {
        return "Windows";
    }

    @Override
    public int getDeteccion()
    {
        return 20;
    }

    @Override
    public int getContencion()
    {
        return 80;
    }

    @Override
    public int ejecutarAnalisisManual()
    {
        return GestorAnalisis.analisisWindows();
    }

    @Override
    public int ejecutarProtocoloContencion()
    {
        return GestorContencion.contencionWindows();
    }
}
