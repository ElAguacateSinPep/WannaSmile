package Proyecto.src.Sistema;

public class NombreSistemaDecorator extends SistemaDecorator {
	private String nombrePersonalizado;

	public NombreSistemaDecorator(Sistema envuelto, String nombre) {
		super(envuelto);
		this.nombrePersonalizado = nombre;
	}

	@Override
	public String getNombre() {
		return this.nombrePersonalizado; // Pisa el nombre por defecto
	}
}
