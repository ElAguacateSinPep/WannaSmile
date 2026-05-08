package defensa.estados;

import defensa.Antivirus;
import defensa.AntivirusState;
import gui.MenuConsola;

public class AmenazaDetectadaState implements AntivirusState
{
    @Override
    public void avanzarEstado(Antivirus antivirus)
    {
        antivirus.cambiarEstado(new SeguroState());
    }

    @Override
    public void mostrarDesenlace()
    {
        MenuConsola.menu.printAmenazaDetectadaSistemaInfectado();
    }
}
