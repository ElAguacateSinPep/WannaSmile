package sistema.decoradores;

import sistema.Sistema;
import sistema.SistemaDecorator;
import utils.GestionProtocolos;
import utils.GestorAnalisis;

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
