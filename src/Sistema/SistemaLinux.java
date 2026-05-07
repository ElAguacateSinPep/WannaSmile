package sistema;

import gui.MenuConsola;

public class SistemaLinux extends SistemaBase
{
    // ------------------------------- Atributos
    MenuConsola menu = new MenuConsola();

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
        int variacionSigilo = 0;

        if (menu.alertaFirewall() == 1)
        {
            menu.printDisminucionSigilo();
            variacionSigilo += DECREMENTO_SIGILO;
        }
        else
        {
            menu.printAumentoSigilo();
            variacionSigilo += AUMENTO_SIGILO;
        }

        if (menu.alertaSODesactualizado() == 1)
        {
            menu.printDisminucionSigilo();
            variacionSigilo += DECREMENTO_SIGILO;
        }
        else
        {
            menu.printAumentoSigilo();
            variacionSigilo += AUMENTO_SIGILO;
        }

        if (menu.alertaConexion() == 1)
        {
            menu.printAumentoSigilo();
            variacionSigilo += AUMENTO_SIGILO;
        }
        else
        {
            menu.printDisminucionSigilo();
            variacionSigilo += DECREMENTO_SIGILO;
        }

        return variacionSigilo;
    }

    @Override
    public int ejecutarProtocoloContencion()
    {
        int variacionContencion = 0;

        if (menu.alertaSudo() == 1)
        {
            menu.printDisminucionContencion();
            variacionContencion += DECREMENTO_CONTENCION;
        }
        else
        {
            menu.printAumentoContencion();
            variacionContencion += AUMENTO_CONTENCION;
        }

        if (menu.alertaPropagacionSisArchivos() == 1)
        {
            menu.printDisminucionContencion();
            variacionContencion += DECREMENTO_CONTENCION;
        }
        else
        {
            menu.printAumentoContencion();
            variacionContencion += AUMENTO_CONTENCION;
        }

        return variacionContencion;
    }
}
