package sistema;

public class SistemaMac extends SistemaBase {

	public SistemaMac() {
		this.arquitectura = "ARM";
	}

	@Override
	public String getNombre() {
		return "Macbook Pro M5";
	}

	@Override
	public String getSO() {
		return "macOS";
	}

	@Override
	public int getDeteccion() {
		return 50;
	}

	@Override
	public int getContencion() {
		return 50;
	}
}
