package sistema;

public class SistemaBase implements Sistema {
	// ------------------------------- Atributos
	// [VULNERABILIDAD] El ÚNICO atributo real guardado en memoria
	public String arquitectura;

	// --------------------------- Constructores
	public SistemaBase() {
		this.arquitectura = "Ninguna";
	}

	// ------------------------ Métodos Públicos
	@Override
	public String getNombre() {
		return "Sistema Desconocido";
	}

	@Override
	public String getSO() {
		return "Ninguno";
	}

	@Override
	public String getArquitectura() {
		return this.arquitectura;
	}

	@Override
	public int getDeteccion() {
		return 0;
	}

	@Override
	public int getContencion() {
		return 0;
	}

	@Override
	public int ejecutarAnalisisManual() {
		return 0;
	}

	@Override
	public int ejecutarProtocoloContencion() {
		return 0;
	}
}
