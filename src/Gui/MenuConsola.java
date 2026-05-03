package Proyecto.src.Gui;

import java.util.Scanner;

public class MenuConsola {

	private Scanner sc;

	public MenuConsola() {
		this.sc = new Scanner(System.in);
	}

	public int ImprimirMenuPrincipal() {
		System.out.println("\n========================================");
		System.out.println("       WANNASMILE: ATTACK SIMULATOR");
		System.out.println("========================================");
		System.out.println("Para comenzar, debemos preparar los dos bandos.");
		System.out.println("Qué deseas configurar primero?");
		System.out.println("[1] La Amenaza (Malware)");
		System.out.println("[2] La Defensa (Sistema)");
		System.out.print("-> Elige una opción: ");
		return pedirOpcion(1, 2);
	}

	public int imprimirPreferenciaSistema() {
		System.out.println("\nPor donde quieres empezar?, un sistema preconfigurado o crear el tuyo propio?");
		System.out.println("[1] Preconfigurado");
		System.out.println("[2] Configurar el tuyo propio");
		System.out.print("-> Elige una opción: ");
		return pedirOpcion(1, 2);
	}

	public int imprimirPreferenciaMalware() {
		System.out.println("\nPor donde quieres empezar?, un malware preconfigurado o crear el tuyo propio?");
		System.out.println("[1] Preconfigurado");
		System.out.println("[2] Configurar el tuyo propio");
		System.out.print("-> Elige una opción: ");
		return pedirOpcion(1, 2);
	}

	public int imprimirOpcionesPreconfiguradoSistema() {
		System.out.println("\n--- CONFIGURACIÓN DE DEFENSA ---");
		System.out.println("Selecciona el sistema operativo objetivo:");
		System.out.println("[1] Windows (Dell XPS)\n[2] macOS (Macbook Pro M5)\n[3] Linux (Thinkpad)");
		System.out.print("-> Elige un sistema: ");
		return pedirOpcion(1, 3);
	}

	public int imprimirOpcionesPreconfiguradoMalware() {
		System.out.println("\n--- CONFIGURACIÓN DE AMENAZA ---");
		System.out.println("Selecciona el vector de ataque base:");
		System.out.println("[1] Zeus(Troyano)\n[2] Ryuk(Ransomware)\n[3] Emotet(Keylogger)\n");
		System.out.print("-> Elige un malware: ");
		return pedirOpcion(1, 3);
	}

	public int imprimirMalwareConfiguracion() {
		System.out.println("\nQue tipo de Malware quieres para tu archivo?");
		System.out.println("[1] Troyano\n[2] Ransomware\n[3] Keylogger");
		System.out.print("-> Elige un tipo: ");
		return pedirOpcion(1, 3);
	}

	public int imprimirSistemaConfiguracion() {
		System.out.println("\nQue SO prefieres?");
		System.out.println("[1] Windows\n[2] MacOS\n[3] Linux");
		System.out.print("-> Elige un SO: ");
		return pedirOpcion(1, 3);
	}

	public String imprimirMalwareNombre() {
		System.out.println("\nQue nombre vas a querer que tenga tu Malware?");
		System.out.print("-> Escribelo : ");
		return leerTexto();
	}

	public int imprimirMalwareSigilo() {
		System.out.println("\nQue nivel de ocultación (sigilo) deseas para tu Malware? (0 - 100)");
		System.out.print("-> Puntos de sigilo: ");
		return pedirOpcion(0, 100);
	}

	public int imprimirMalwareSistemaObjetivo() {
		System.out.println("\n--- OBJETIVO DEL ATAQUE ---");
		System.out.println("¿Para qué sistema operativo estás diseñando este malware?");
		System.out.println("[1] Windows");
		System.out.println("[2] macOS");
		System.out.println("[3] Linux");
		System.out.print("-> Selecciona plataforma: ");
		return pedirOpcion(1, 3); // Solo acepta 1, 2 o 3
	}

	public String imprimirSistemaNombre() {
		System.out.println("\nQue nombre vas a querer que tenga tu Sistema de Defensa?");
		System.out.print("-> Escribelo : ");
		return leerTexto();
	}

	public int imprimirSistemaArquitectura() {
		System.out.println("\n--- VULNERABILIDAD DEL SISTEMA ---");
		System.out.println("Que arquitectura de procesador utiliza?");
		System.out.println("[1] x64\n[2] x86\n[3] ARM");
		System.out.print("-> Elige una arquitectura: ");
		return pedirOpcion(1, 3);
	}

	public int imprimirSistemaDeteccion() {
		System.out.println("\nQue nivel de deteccion (antivirus) deseas para tu Sistema? (0 - 100)");
		System.out.println("(Nota: Los puntos restantes hasta 100 se asignaran automaticamente a la Contencion)");
		System.out.print("-> Puntos de deteccion: ");
		return pedirOpcion(0, 100);
	}

	public void imprimirTransicionASistema() {
		System.out.println("\n[!] Amenaza configurada. Pasando automáticamente a la configuración de Defensa...");
	}

	public void imprimirTransicionAMalware() {
		System.out.println("\n[!] Defensa configurada. Pasando automáticamente a la configuración de Amenaza...");
	}

	// Pide un número y obliga al usuario a que esté entre el MIN y el MAX
	private int pedirOpcion(int min, int max) {
		int opcion = -1;
		boolean opcionValida = false;

		do {
			try {
				// Leemos el número de forma segura (sin el bug del Enter)
				opcion = Integer.parseInt(sc.nextLine());

				// Comprobamos si está en el rango permitido
				if (opcion >= min && opcion <= max) {
					opcionValida = true; // Todo correcto, salimos del bucle
				} else {
					System.out.print("[Error] Opción fuera de rango. Elige entre " + min + " y " + max + ": ");
				}
			} catch (NumberFormatException e) {
				// Si ha metido una letra en vez de un número
				System.out.print("[Error] No has introducido un número válido. Inténtalo de nuevo: ");
			}
		} while (!opcionValida);

		return opcion;
	}

	private String leerTexto() {
		String texto = "";
		// Mientras el texto esté vacío o solo tenga espacios, sigue preguntando
		while (texto.trim().isEmpty()) {
			texto = sc.nextLine();

			if (texto.trim().isEmpty()) {
				System.out.print("[!] El nombre no puede estar vacío. Escribe algo: ");
			}
		}
		return texto.trim(); // Devuelve el texto quitando espacios extra a los lados
	}
}
