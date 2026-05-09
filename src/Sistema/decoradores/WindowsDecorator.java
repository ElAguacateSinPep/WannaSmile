package sistema.decoradores;

import sistema.Sistema;
import sistema.SistemaDecorator;
import utils.GestorAnalisis;
import utils.GestionProtocolos;

public class WindowsDecorator extends SistemaDecorator {
	public WindowsDecorator(Sistema envuelto) {
		super(envuelto);
	}

	@Override
	public String getSO() {
		return "Windows";
	}

	@Override
	public int ejecutarAnalisisManual() {
		return GestorAnalisis.analisisWindows();
	}

	@Override
	public int ejecutarProtocoloContencion() {
		return GestionProtocolos.contencionWindows();
	}
}
