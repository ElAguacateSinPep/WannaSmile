package defensa.estados;

import defensa.Antivirus;
import defensa.AntivirusState;
import gui.MenuConsola;
import malware.Malware;

public class SeguroState implements AntivirusState
{
    @Override
    public void avanzarEstado(Antivirus antivirus)
    {
        MenuConsola.menu.printOperacionNoPermitida();
    }

    @Override
    public void mostrarDesenlace(Malware malware)
    {
        MenuConsola.menu.printAmenazaDetectadaNeutralizada();
    }
}
