package Proyecto.src.Sistema;

public class SistemaFactory {

	// Devuelve los preconfigurados que hemos creado
	public Sistema crearSistemaPreconfigurado(int opcion) {
		switch (opcion) {
			case 1:
				return new SistemaWindows();
			case 2:
				return new SistemaMac();
			case 3:
				return new SistemaLinux();
			default:
				return new SistemaWindows(); // Por defecto si hay error
		}
	}

	// Devuelve el lienzo en blanco para cuando el usuario usa Decoradores
	public Sistema crearSistemaBase() {
		return new SistemaBase();
	}
}
