package Proyecto.src.Sistema;

public interface Sistema {
	String getNombre();

	String getSO();

	String getArquitectura();

	int getDeteccion(); // Capacidad de encontrar el malware (ej. 0-100)

	int getContencion(); // Capacidad de bloquear/eliminar el malware (ej. 0-100)
}
