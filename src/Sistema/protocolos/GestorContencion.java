package sistema.protocolos;

import ui.MenuConsola;

public class GestorContencion
{
    // Definimos las variaciones de contencion aqui
    private static final int AUMENTO_CONTENCION    = 20;
    private static final int DECREMENTO_CONTENCION = -20;

    public static int contencionWindows()
    {
        MenuConsola menu = new MenuConsola();
        int variacion = 0;

        if (menu.alertaSeguridad() == 1)
        {
            menu.printDisminucionContencion();
            variacion += DECREMENTO_CONTENCION;
        }
        else
        {
            menu.printAumentoContencion();
            variacion += AUMENTO_CONTENCION;
        }

        if (menu.alertaArchivoDesconocido() == 1)
        {
            menu.printDisminucionContencion();
            variacion += DECREMENTO_CONTENCION;
        }
        else
        {
            menu.printAumentoContencion();
            variacion += AUMENTO_CONTENCION;
        }

        if (menu.alertaWindowsFirewall() == 1)
        {
            menu.printDisminucionContencion();
            variacion += DECREMENTO_CONTENCION;
        }
        else
        {
            menu.printAumentoContencion();
            variacion += AUMENTO_CONTENCION;
        }

        return variacion;
    }

    public static int contencionMac()
    {
        MenuConsola menu = new MenuConsola();
        int variacion = 0;

        if (menu.alertaPuertoLocal() == 1)
        {
            menu.printDisminucionContencion();
            variacion += DECREMENTO_CONTENCION;
        }
        else
        {
            menu.printAumentoContencion();
            variacion += AUMENTO_CONTENCION;
        }

        if (menu.alertaAccesoFinder() == 1)
        {
            menu.printDisminucionContencion();
            variacion += DECREMENTO_CONTENCION;
        }
        else
        {
            menu.printAumentoContencion();
            variacion += AUMENTO_CONTENCION;
        }

        if (menu.alertaItemsInicio() == 1)
        {
            menu.printDisminucionContencion();
            variacion += DECREMENTO_CONTENCION;
        }
        else
        {
            menu.printAumentoContencion();
            variacion += AUMENTO_CONTENCION;
        }

        return variacion;
    }

    public static int contencionLinux()
    {
        MenuConsola menu = new MenuConsola();
        int variacion = 0;

        if (menu.alertaSudo() == 1)
        {
            menu.printDisminucionContencion();
            variacion += DECREMENTO_CONTENCION;
        }
        else
        {
            menu.printAumentoContencion();
            variacion += AUMENTO_CONTENCION;
        }

        if (menu.alertaPropagacionSisArchivos() == 1)
        {
            menu.printDisminucionContencion();
            variacion += DECREMENTO_CONTENCION;
        }
        else
        {
            menu.printAumentoContencion();
            variacion += AUMENTO_CONTENCION;
        }

        return variacion;
    }
}
