package Proyecto.src.Sistema;

public abstract class SistemaDecorator implements Sistema {
	protected Sistema sistemaEnvuelto;

	public SistemaDecorator(Sistema envuelto) {
		this.sistemaEnvuelto = envuelto;
	}

	@Override
	public String getNombre() {
		return sistemaEnvuelto.getNombre();
	}

	@Override
	public String getSO() {
		return sistemaEnvuelto.getSO();
	}

	@Override
	public String getArquitectura() {
		return sistemaEnvuelto.getArquitectura();
	}

	@Override
	public int getDeteccion() {
		return sistemaEnvuelto.getDeteccion();
	}

	@Override
	public int getContencion() {
		return sistemaEnvuelto.getContencion();
	}
}
