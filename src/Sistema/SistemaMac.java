package sistema;

import gui.MenuConsola;

public class SistemaMac extends SistemaBase
{
    // ------------------------------- Atributos
    MenuConsola menu = new MenuConsola();

    // --------------------------- Constructores
    public SistemaMac()
    {
        this.arquitectura = "ARM";
    }

    // --------------------------------- Getters
    @Override
    public String getNombre()
    {
        return "Macbook Pro M5";
    }

    @Override
    public String getSO()
    {
        return "macOS";
    }

    @Override
    public int getDeteccion()
    {
        return 50;
    }

    @Override
    public int getContencion()
    {
        return 50;
    }

    @Override
    public int ejecutarAnalisisManual()
    {
        MenuConsola menu = new MenuConsola();
        int variacionSigilo = 0;

        if (menu.alertaAbrirArchivoNoVerificado() == 1)
        {
            menu.verAumentoSigilo();
            variacionSigilo += AUMENTO_SIGILO;
        }
        else
        {
            menu.verDisminucionSigilo();
            variacionSigilo += DECREMENTO_SIGILO;
        }

        if (menu.alertaSegundoPlano() == 1)
        {
            menu.verAumentoSigilo();
            variacionSigilo += AUMENTO_SIGILO;
        }
        else
        {
            menu.verDisminucionSigilo();
            variacionSigilo += DECREMENTO_SIGILO;
        }

        return variacionSigilo;
    }

    @Override
    public int ejecutarProtocoloContencion()
    {
        int variacionContencion = 0;

        if(menu.alertaPuertoLocal() == 1)
        {
            menu.verDisminucionContencion();
            variacionContencion += DECREMENTO_CONTENCION;
        }
        else
        {
            menu.verAumentoContencion();
            variacionContencion += AUMENTO_CONTENCION;
        }

        if(menu.alertaAccesoFinder() == 1)
        {
            menu.verDisminucionContencion();
            variacionContencion += DECREMENTO_CONTENCION;
        }
        else
        {
            menu.verAumentoContencion();
            variacionContencion += AUMENTO_CONTENCION;
        }

        if(menu.alertaItemsInicio() == 1)
        {
            menu.verDisminucionContencion();
            variacionContencion += DECREMENTO_CONTENCION;
        }
        else
        {
            menu.verAumentoContencion();
            variacionContencion += AUMENTO_CONTENCION;
        }

        return variacionContencion;
    }
}
