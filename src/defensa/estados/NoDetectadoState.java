package defensa.estados;

import defensa.Antivirus;
import defensa.AntivirusState;
import malware.Malware;
import ui.MenuConsola;
import utilidades.Utils;

public class NoDetectadoState implements AntivirusState
{
    @Override
    public void avanzarEstado(Antivirus antivirus)
    {
        MenuConsola.menu.printOperacionNoPermitida();
    }

    @Override
    public void mostrarDesenlace(Malware malware)
    {
        MenuConsola.menu.printAmenazaNoDetectada();
        MenuConsola.menu.printMensajeMalware(malware.getMensaje());
        Utils.esperar(5000);
        malware.ejecutarPayload();
    }
}
