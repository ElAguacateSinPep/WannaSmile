package defensa.estados;

import defensa.Antivirus;
import defensa.AntivirusState;
import gui.MenuConsola;

public class NoDetectadoState implements AntivirusState
{
    @Override
    public void avanzarEstado(Antivirus antivirus)
    {
        MenuConsola.menu.printOperacionNoPermitida();
    }

    @Override
    public void mostrarDesenlace()
    {
        MenuConsola.menu.printAmenazazaNoDetectada();
    }
}
