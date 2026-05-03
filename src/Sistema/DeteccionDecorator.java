package Proyecto.src.Sistema;

public class DeteccionDecorator extends SistemaDecorator {
	private int puntosDeteccion;
	private int puntosContencion; // Se calculará automáticamente

	public DeteccionDecorator(Sistema envuelto, int puntosDeteccion) {
		super(envuelto);

		// Asignamos la detección que eligió el usuario
		this.puntosDeteccion = puntosDeteccion;

		// ¡Equilibrio automático! Si le pones 80 de detección, tendrá 20 de contención.
		this.puntosContencion = 100 - puntosDeteccion;
	}

	@Override
	public int getDeteccion() {
		return this.puntosDeteccion;
	}

	@Override
	public int getContencion() {
		return this.puntosContencion; // Devuelve el valor calculado
	}
}
