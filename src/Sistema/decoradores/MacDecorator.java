package sistema.decoradores;

import sistema.Sistema;
import sistema.SistemaDecorator;
import utils.GestorAnalisis;
import utils.GestionProtocolos;

public class MacDecorator extends SistemaDecorator {
	public MacDecorator(Sistema envuelto) {
		super(envuelto);
	}

	@Override
	public String getSO() {
		return "macOS";
	}

	@Override
	public int ejecutarAnalisisManual() {
		return GestorAnalisis.analisisMac();
	}

	@Override
	public int ejecutarProtocoloContencion() {
		return GestionProtocolos.contencionMac();
	}
}
