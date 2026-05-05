package sistema;

public class PenalizacionContencionDecorator extends SistemaDecorator {

	public PenalizacionContencionDecorator(Sistema envuelto) {
		super(envuelto);
	}

	@Override
	public int getContencion() {
		return super.getContencion() - 10;
	}
}
