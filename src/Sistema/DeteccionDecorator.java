package Proyecto.src.Sistema;

public class DeteccionDecorator extends SistemaDecorator {
	private int puntosDeteccion;

	public DeteccionDecorator(Sistema envuelto, int puntosDeteccion) {
		super(envuelto);
		this.puntosDeteccion = puntosDeteccion;
	}

	@Override
	public int getDeteccion() {
		return this.puntosDeteccion;
	}
}
