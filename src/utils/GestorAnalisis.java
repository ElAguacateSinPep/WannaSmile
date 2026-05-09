package utils;

import gui.MenuConsola;

public class GestorAnalisis {
	// Definimos las variaciones de sigilo aqui para no depender de SistemaBase
	private static final int AUMENTO_SIGILO = 10;
	private static final int DECREMENTO_SIGILO = -10;

	public static int analisisWindows() {
		MenuConsola menu = new MenuConsola();
		int variacion = 0;

		if (menu.alertaAceptarPermisos() == 1) {
			menu.printAumentoSigilo();
			variacion += AUMENTO_SIGILO;
		} else {
			menu.printDisminucionSigilo();
			variacion += DECREMENTO_SIGILO;
		}

		if (menu.alertaIgnorarAdvertencia() == 1) {
			menu.printAumentoSigilo();
			variacion += AUMENTO_SIGILO;
		} else {
			menu.printDisminucionSigilo();
			variacion += DECREMENTO_SIGILO;
		}

		return variacion;
	}

	public static int analisisMac() {
		MenuConsola menu = new MenuConsola();
		int variacion = 0;

		if (menu.alertaAbrirArchivoNoVerificado() == 1) {
			menu.printAumentoSigilo();
			variacion += AUMENTO_SIGILO;
		} else {
			menu.printDisminucionSigilo();
			variacion += DECREMENTO_SIGILO;
		}

		if (menu.alertaSegundoPlano() == 1) {
			menu.printAumentoSigilo();
			variacion += AUMENTO_SIGILO;
		} else {
			menu.printDisminucionSigilo();
			variacion += DECREMENTO_SIGILO;
		}

		return variacion;
	}

	public static int analisisLinux() {
		MenuConsola menu = new MenuConsola();
		int variacion = 0;

		if (menu.alertaFirewall() == 1) {
			menu.printDisminucionSigilo();
			variacion += DECREMENTO_SIGILO;
		} else {
			menu.printAumentoSigilo();
			variacion += AUMENTO_SIGILO;
		}

		if (menu.alertaSODesactualizado() == 1) {
			menu.printDisminucionSigilo();
			variacion += DECREMENTO_SIGILO;
		} else {
			menu.printAumentoSigilo();
			variacion += AUMENTO_SIGILO;
		}

		if (menu.alertaConexion() == 1) {
			menu.printAumentoSigilo();
			variacion += AUMENTO_SIGILO;
		} else {
			menu.printDisminucionSigilo();
			variacion += DECREMENTO_SIGILO;
		}

		return variacion;
	}
}
