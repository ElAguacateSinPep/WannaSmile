package Proyecto.src.Sistema;

public class SistemaWindows extends SistemaBase {

	public SistemaWindows() {
		// [VULNERABILIDAD] Solo puede ser x64, x86 o ARM
		this.arquitectura = "x64";
	}

	@Override
	public String getNombre() {
		return "Dell XPS"; // Nombre exacto del menú
	}

	@Override
	public String getSO() {
		return "Windows"; // SO exacto del menú
	}

	@Override
	public int getDeteccion() {
		return 40; // Detección media (Windows Defender estándar)
	}

	@Override
	public int getContencion() {
		return 60; // 40 + 60 = 100
	}
}
