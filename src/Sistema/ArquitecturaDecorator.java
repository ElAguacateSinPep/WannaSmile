package Proyecto.src.Sistema;

public class ArquitecturaDecorator extends SistemaDecorator {
	private String arquitecturaElegida;

	public ArquitecturaDecorator(Sistema envuelto, int opcionMenu) {
		super(envuelto);

		// Solo las 3 opciones permitidas
		switch (opcionMenu) {
			case 1:
				this.arquitecturaElegida = "x64";
				break;
			case 2:
				this.arquitecturaElegida = "x86";
				break;
			case 3:
				this.arquitecturaElegida = "ARM";
				break;
			default:
				this.arquitecturaElegida = "Desconocida";
				break;
		}
	}

	@Override
	public String getArquitectura() {
		return this.arquitecturaElegida;
	}
}
