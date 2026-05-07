package sistema;

import gui.MenuConsola;

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
        MenuConsola menu = new MenuConsola();
        int variacionSigilo = 0;

        if (menu.alertaAceptarPermisos() == 1)
        {
            menu.printAumentoSigilo();
            variacionSigilo += AUMENTO_SIGILO;
        }
        else
        {
            menu.printDisminucionSigilo();
            variacionSigilo += DECREMENTO_SIGILO;
        }

        if (menu.alertaIgnorarAdvertencia() == 1)
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

        if (menu.alertaSeguridad() == 1)
        {
            menu.printDisminucionContencion();
            variacionContencion += DECREMENTO_CONTENCION;
        }
        else
        {
            menu.printAumentoContencion();
            variacionContencion += AUMENTO_CONTENCION;
        }

        if (menu.alertaArchivoDesconocido() == 1)
        {
            menu.printDisminucionContencion();
            variacionContencion += DECREMENTO_CONTENCION;
        }
        else
        {
            menu.printAumentoContencion();
            variacionContencion += AUMENTO_CONTENCION;
        }

        if (menu.alertaWindowsFirewall() == 1)
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
