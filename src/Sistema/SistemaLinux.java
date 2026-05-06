package sistema;

import gui.MenuConsola;

public class SistemaLinux extends SistemaBase
{
    // --------------------------- Constructores
    public SistemaLinux()
    {
        this.arquitectura = "x86";
    }
    // --------------------------------- Getters
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
        MenuConsola menu = new MenuConsola();
        int variacionSigilo = 0;

        if(menu.alertaFirewall() == 1)
            variacionSigilo -= 10;
        else
            variacionSigilo += 10;

        if(menu.alertaSODesactualizado() == 1)
            variacionSigilo -= 10;
        else
            variacionSigilo += 10;

        if(menu.alertaConexion() == 1)
            variacionSigilo += 10;
        else
            variacionSigilo -= 10;

        return variacionSigilo;
    }
}
