package sistema;

public class MejoraContencionDecorator extends SistemaDecorator {

	public MejoraContencionDecorator(Sistema envuelto) {
		super(envuelto);
	}

	@Override
	public int getContencion() {
		return super.getContencion() + 10;
	}
}
