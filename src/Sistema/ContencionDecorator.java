package sistema;

public class ContencionDecorator extends SistemaDecorator {
	private int puntosContencion;

	public ContencionDecorator(Sistema envuelto, int puntosDeteccion) {
		super(envuelto);
		this.puntosContencion = 100 - puntosDeteccion;
	}

	@Override
	public int getContencion() {
		return this.puntosContencion;
	}
}
