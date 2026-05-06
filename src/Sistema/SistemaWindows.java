package sistema;

import gui.MenuConsola;

public class SistemaWindows extends SistemaBase
{
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
        return 60;
    }

    @Override
    public int getContencion()
    {
        return 40;
    }

    @Override
    public int ejecutarAnalisisManual()
    {
        MenuConsola menu = new MenuConsola();
        int variacionSigilo = 0;

        if(menu.alertaAceptarPermisos() == 1)
            variacionSigilo += 10;
        else
            variacionSigilo -= 10;

        if(menu.alertaSegundoPlano() == 1)
            variacionSigilo += 10;
        else
            variacionSigilo -= 10;

        return variacionSigilo;
    }
}
