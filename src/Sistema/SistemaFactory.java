package sistema;

public class SistemaFactory {

	public Sistema crearSistemaPreconfigurado(int opcion) {
		switch (opcion) {
			case 1:
				return new SistemaWindows();
			case 2:
				return new SistemaMac();
			case 3:
				return new SistemaLinux();
			default:
				return new SistemaWindows();
		}
	}

	public Sistema crearSistemaBase() {
		return new SistemaBase();
	}
}
