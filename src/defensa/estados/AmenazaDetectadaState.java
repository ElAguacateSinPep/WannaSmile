package defensa.estados;

import defensa.Antivirus;
import defensa.AntivirusState;
import malware.Malware;
import malware.payloads.GestorPayloads;
import ui.MenuConsola;
import utilidades.Utils;

public class AmenazaDetectadaState implements AntivirusState
{
    @Override
    public void avanzarEstado(Antivirus antivirus)
    {
        antivirus.cambiarEstado(new SeguroState());
    }

    @Override
    public void mostrarDesenlace(Malware malware)
    {
        MenuConsola.menu.printAmenazaDetectadaSistemaInfectado();
        MenuConsola.menu.printMensajeMalware(malware.getMensaje());
        Utils.esperar(8000);
        malware.ejecutarPayload();
    }
}
