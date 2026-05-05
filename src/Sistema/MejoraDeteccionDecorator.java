package sistema;

public class MejoraDeteccionDecorator extends SistemaDecorator {

	public MejoraDeteccionDecorator(Sistema envuelto) {
		super(envuelto);
	}

	@Override
	public int getDeteccion() {
		return super.getDeteccion() + 10;
	}
}
