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
        {
            menu.verDisminucionSigilo();
            variacionSigilo += DECREMENTO_SIGILO;
        }
        else
        {
            menu.verAumentoSigilo();
            variacionSigilo += AUMENTO_SIGILO;
        }

        if(menu.alertaSODesactualizado() == 1)
        {
            menu.verDisminucionSigilo();
            variacionSigilo += DECREMENTO_SIGILO;
        }
        else
        {
            menu.verAumentoSigilo();
            variacionSigilo += AUMENTO_SIGILO;
        }

        if(menu.alertaConexion() == 1)
        {
            menu.verAumentoSigilo();
            variacionSigilo += AUMENTO_SIGILO;
        }
        else
        {
            variacionSigilo += DECREMENTO_SIGILO;
        }

        return variacionSigilo;
    }
}
