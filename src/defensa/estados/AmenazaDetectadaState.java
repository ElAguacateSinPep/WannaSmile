package defensa.estados;

import defensa.Antivirus;
import defensa.AntivirusState;
import gui.MenuConsola;
import malware.Malware;
import utils.Utils;
import utils.GestorPayloads;

public class AmenazaDetectadaState implements AntivirusState {
	@Override
	public void avanzarEstado(Antivirus antivirus) {
		antivirus.cambiarEstado(new SeguroState());
	}

	@Override
	public void mostrarDesenlace(Malware malware) {
		MenuConsola.menu.printAmenazaDetectadaSistemaInfectado();
		MenuConsola.menu.printMensajeMalware(malware.getMensaje());
		Utils.esperar(5000);
		malware.ejecutarPayload();
	}
}
