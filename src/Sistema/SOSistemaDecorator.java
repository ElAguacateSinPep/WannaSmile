package sistema;

public class SOSistemaDecorator extends SistemaDecorator {
	private String sistemaOperativo;

	public SOSistemaDecorator(Sistema envuelto, int opcionMenu) {
		super(envuelto);

		switch (opcionMenu) {
			case 1:
				this.sistemaOperativo = "Windows";
				break;
			case 2:
				this.sistemaOperativo = "macOS";
				break;
			case 3:
				this.sistemaOperativo = "Linux";
				break;
			default:
				this.sistemaOperativo = "Desconocido";
				break;
		}
	}

	@Override
	public String getSO() {
		return this.sistemaOperativo;
	}
}
