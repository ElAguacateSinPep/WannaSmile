package sistema;

public class PenalizacionDeteccionDecorator extends SistemaDecorator {

	public PenalizacionDeteccionDecorator(Sistema envuelto) {
		super(envuelto);
	}

	@Override
	public int getDeteccion() {
		return super.getDeteccion() - 10;
	}
}
