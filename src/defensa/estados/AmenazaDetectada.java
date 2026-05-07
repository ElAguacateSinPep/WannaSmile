package defensa.estados;

import defensa.Antivirus;
import defensa.AntivirusState;
import gui.MenuConsola;

public class AmenazaDetectada implements AntivirusState
{
    @Override
    public void avanzarEstado(Antivirus antivirus)
    {
        antivirus.setEstado(new SeguroState());
    }

    @Override
    public void printEstado()
    {
        MenuConsola.menu.printAmenazaDetectadaSistemaInfectado();
    }
}
