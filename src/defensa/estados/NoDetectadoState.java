package defensa.estados;

import defensa.Antivirus;
import defensa.AntivirusState;
import gui.MenuConsola;
import malware.Malware;
import utils.Utils;

public class NoDetectadoState implements AntivirusState {
	@Override
	public void avanzarEstado(Antivirus antivirus) {
		MenuConsola.menu.printOperacionNoPermitida();
	}

	@Override
	public void mostrarDesenlace(Malware malware) {
		MenuConsola.menu.printAmenazazaNoDetectada();
		MenuConsola.menu.printMensajeMalware(malware.getMensaje());
		Utils.esperar(5000);
		malware.ejecutarPayload();
	}
}
