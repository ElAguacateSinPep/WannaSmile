package Proyecto.src.Sistema;

public class SistemaBase implements Sistema {

	// [VULNERABILIDAD] El ÚNICO atributo real guardado en memoria
	public String arquitectura;

	public SistemaBase() {
		this.arquitectura = "Ninguna";
	}

	@Override
	public String getNombre() {
		return "Sistema Desconocido";
	} // Sin variable

	@Override
	public String getSO() {
		return "Ninguno";
	} // Sin variable

	@Override
	public String getArquitectura() {
		return this.arquitectura;
	}

	@Override
	public int getDeteccion() {
		return 0;
	} // Sin variable

	@Override
	public int getContencion() {
		return 0;
	} // Sin variable
}
