package gui;

import java.util.Scanner;

import malware.Malware;
import sistema.Sistema;
import utils.Utils;

public class MenuConsola
{
    // ------------------------------- Atributos
    private Scanner            sc       = new Scanner(System.in);
    public static final String ROJO     = "\u001B[31m";
    public static final String VERDE    = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String MORADO   = "\u001B[35m";
    public static final String RESET    = "\u001B[0m";
    public static MenuConsola  menu     = new MenuConsola();

    // ------------------------ Métodos Públicos

    // ====================================================
    // CREACIÓN
    // ====================================================

    public int printMenuPrincipal()
    {
        System.out.println();
        System.out.println("======================================================");
        System.out.println("             WANNASMILE: ATTACK SIMULATOR             ");
        System.out.println("======================================================");
        System.out.println("Para comenzar, debemos preparar los dos bandos.");
        System.out.println("Qué deseas configurar primero?");
        System.out.println("[1] La Amenaza (Malware)");
        System.out.println("[2] La Defensa (Sistema)");
        System.out.print("-> Elige una opción: ");
        return pedirOpcion(1, 2);
    }

    public int printPreferenciaSistema()
    {
        System.out.println(
            "\nPor donde quieres empezar?, un sistema preconfigurado o crear el tuyo propio?");
        System.out.println("[1] Preconfigurado");
        System.out.println("[2] Configurar el tuyo propio");
        System.out.print("-> Elige una opción: ");
        return pedirOpcion(1, 2);
    }

    public int printPreferenciaMalware()
    {
        System.out.println(
            "\nPor donde quieres empezar?, un malware preconfigurado o crear el tuyo propio?");
        System.out.println("[1] Preconfigurado");
        System.out.println("[2] Configurar el tuyo propio");
        System.out.print("-> Elige una opción: ");
        return pedirOpcion(1, 2);
    }

    public int printOpcionesPreconfiguradoSistema()
    {
        System.out.println("\n--- CONFIGURACIÓN DE DEFENSA ---");
        System.out.println("Selecciona el sistema operativo objetivo:");
        System.out.println("┌────────────────────────────┬─────────────┬──────────────┐");
        System.out.println("|           Nombre           |  Detección  |  Contención  |");
        System.out.println("├────────────────────────────┼─────────────┼──────────────┤");
        System.out.println("| [1] Windows (Dell XPS)     |     20      |      80      |");
        System.out.println("| [2] macOS (Macbook Pro M5) |     50      |      50      |");
        System.out.println("| [3] Linux (Thinkpad)       |     75      |      25      |");
        System.out.println("└────────────────────────────┴─────────────┴──────────────┘");
        System.out.print("-> Elige un sistema: ");
        return pedirOpcion(1, 3);
    }

    public int printOpcionesPreconfiguradoMalware()
    {
        System.out.println("\n--- CONFIGURACIÓN DE AMENAZA ---");
        System.out.println("Selecciona el vector de ataque base:");
        System.out.println("");
        System.out.println("┌──────────────────────────┬────────────┬─────────────────┐");
        System.out.println("|         Nombre           |   Sigilo   |   Propagación   |");
        System.out.println("├──────────────────────────┼────────────┼─────────────────┤");
        System.out.println("| [1] Zeus(Troyano)        |     50     |       50        |");
        System.out.println("| [2] Ryuk(Ransomware)     |     20     |       80        |");
        System.out.println("| [3] Emotet(Keylogger)    |     80     |       20        |");
        System.out.println("└──────────────────────────┴────────────┴─────────────────┘");
        System.out.print("-> Elige un malware: ");
        return pedirOpcion(1, 3);
    }

    public int printMalwareConfiguracion()
    {
        System.out.println("\nQue tipo de Malware quieres para tu archivo?");
        System.out.println("[1] Troyano\n[2] Ransomware\n[3] Keylogger");
        System.out.print("-> Elige un tipo: ");
        return pedirOpcion(1, 3);
    }

    public int printSistemaConfiguracion()
    {
        System.out.println("\nQue SO prefieres?");
        System.out.println("[1] Windows\n[2] MacOS\n[3] Linux");
        System.out.print("-> Elige un SO: ");
        return pedirOpcion(1, 3);
    }

    public String printMalwareNombre()
    {
        System.out.println("\nQue nombre vas a querer que tenga tu Malware?");
        System.out.print("-> Escribelo : ");
        return leerTexto();
    }

    public int printMalwareSigilo()
    {
        System.out.println("\nQue nivel de ocultación (sigilo) deseas para tu Malware? (0 - 100)");
        System.out.print("-> Puntos de sigilo: ");
        return pedirOpcion(0, 100);
    }

    public int printMalwareSistemaObjetivo()
    {
        System.out.println("\n--- OBJETIVO DEL ATAQUE ---");
        System.out.println("¿Para qué sistema operativo estás diseñando este malware?");
        System.out.println("[1] Windows");
        System.out.println("[2] macOS");
        System.out.println("[3] Linux");
        System.out.print("-> Selecciona plataforma: ");
        return pedirOpcion(1, 3); // Solo acepta 1, 2 o 3
    }

    public String printSistemaNombre()
    {
        System.out.println("\nQue nombre vas a querer que tenga tu Sistema de Defensa?");
        System.out.print("-> Escribelo : ");
        return leerTexto();
    }

    public int printSistemaArquitectura()
    {
        System.out.println("\n--- VULNERABILIDAD DEL SISTEMA ---");
        System.out.println("Que arquitectura de procesador utiliza?");
        System.out.println("[1] x64\n[2] x86\n[3] ARM");
        System.out.print("-> Elige una arquitectura: ");
        return pedirOpcion(1, 3);
    }

    public int printSistemaDeteccion()
    {
        System.out
            .println("\nQue nivel de deteccion (antivirus) deseas para tu Sistema? (0 - 100)");
        System.out.println(
            "(Nota: Los puntos restantes hasta 100 se asignaran automaticamente a la Contencion)");
        System.out.print("-> Puntos de deteccion: ");
        return pedirOpcion(0, 100);
    }

    public void printTransicionASistema()
    {
        System.out.println(
            "\n[!] Amenaza configurada. Pasando automáticamente a la configuración de Defensa...");
    }

    public void printTransicionAMalware()
    {
        System.out.println(
            "\n[!] Defensa configurada. Pasando automáticamente a la configuración de Amenaza...");
    }

    public void printMalwareListo()
    {
        System.out.println(ROJO + "\n[+] Malware listo en memoria." + RESET);
    }

    public void printSistemaDesplegado()
    {
        System.out.println(VERDE + "\n[+] Sistema de defensa desplegado." + RESET);
    }

    public void printCreacion(Sistema sistemaDefensa, Malware malwareAtacante)
    {
        System.out.println("");
        System.out.println("===========================================================");
        System.out.println("                ESTADO FINAL DE LA CREACIÓN                ");
        System.out.println("===========================================================");
        System.out.println();

        System.out.print(VERDE);
        System.out.println("SISTEMA DEFENSA:");
        System.out.println(" -> Nombre ................. " + sistemaDefensa.getNombre());
        System.out.println(" -> SO ..................... " + sistemaDefensa.getSO());
        System.out.println(" -> Arquitectura ........... " + sistemaDefensa.getArquitectura());
        System.out.println(" -> Puntos Detección ....... " + sistemaDefensa.getDeteccion());
        System.out.println(" -> Puntos Contención ...... " + sistemaDefensa.getContencion());
        System.out.print(RESET);

        System.out.print(ROJO);
        System.out.println("\nAMENAZA ATACANTE:");
        System.out.println(" -> Nombre ................. " + malwareAtacante.getNombre());
        System.out.println(" -> Tipo ................... " + malwareAtacante.getTipo());
        System.out.println(" -> Arquitectura Objetivo .. " + malwareAtacante.getArquitectura());
        System.out.println(" -> Puntos Sigilo .......... " + malwareAtacante.getSigilo());
        System.out.println(" -> Puntos Propagación ..... " + malwareAtacante.getPropagacion());
        System.out.println(RESET);
    }

    // ====================================================
    // COMPORTAMIENTO
    // ====================================================

    // ====================================================
    // Antivirus

    public void printAntivirusArchivoDetectado()
    {
        System.out.println(AMARILLO);
        System.out.println(
            """
                ╔═════════════════════════════════════════════════════════╗
                ║                ! ANTIVIRUS: ADVERTENCIA !               ║
                ╠═════════════════════════════════════════════════════════╣
                ║  Nuevo archivo desconocido detectado                    ║
                ║  Iniciando protocolo de respuesta ante incidentes...    ║
                ╚═════════════════════════════════════════════════════════╝
                """);
        System.out.print(RESET);
    }

    public void printMalwareDetectado()
    {
        System.out.print(AMARILLO);
        System.out.println(
            """
                ╔═════════════════════════════════════════════════════════╗
                ║                  ! ANTIVIRUS: ALERTA !                  ║
                ╠═════════════════════════════════════════════════════════╣
                ║  El archivo descargado contiene software malicioso      ║
                ║  Iniciando protocolo de contención                      ║
                ║                                                         ║
                ║  Estado del sistema: Muy mal                            ║
                ╚═════════════════════════════════════════════════════════╝
                """);
        System.out.print(RESET);
    }

    public void printInicioAnalisisManual()
    {
        System.out.println("--- ANALISIS MANUAL ---");
    }

    public void printInicioAnalisisAutomatico()
    {
        System.out.println("--- ANALISIS AUTOMATICO ---");
    }

    public void printInicioRespuesta()
    {
        System.out.println("--- Respuesta ante incidentes ---");
    }

    // ====================================================
    // Anlálisis > config manual > general
    // ====================================================

    public void printStatsAnalisis(int deteccion, int sigilo)
    {
        System.out.println(MORADO);
        System.out.println("╭────────────── STATS ───────────╮");
        System.out.printf("│ DETECCIÓN = %3d | SIGILO = %3d │%n", deteccion, sigilo);
        System.out.println("╰─────────────────┴──────────────╯");
        System.out.println(RESET);
    }

    public void printAumentoSigilo()
    {
        System.out.println(ROJO + "+ 10 Sigilo\n" + RESET);
    }

    public void printDisminucionSigilo()
    {
        System.out.println(VERDE + "- 10 Sigilo\n" + RESET);
    }

    // ====================================================
    // Anlálisis > config manual > windows

    public int alertaAceptarPermisos()
    {
        System.out.println(
            "Windows Defender: Este archivo solicita permisos de administrador."
                + "\n¿Permitir?"
                + "\n[1] - Si"
                + "\n[2] - No");
        System.out.print("-> Elige una opción: ");
        int opcion = pedirOpcion(1, 2);
        System.out.println();
        return opcion;
    }

    public int alertaIgnorarAdvertencia()
    {
        System.out.println(
            "Windows Defender detecta comportamiento sospechoso."
                + "\n¿Ignorar advertencia?"
                + "\n[1] - Si"
                + "\n[2] - No");
        System.out.print("-> Elige una opción: ");
        int opcion = pedirOpcion(1, 2);
        System.out.println();
        return opcion;
    }

    // ====================================================
    // Anlálisis > config manual > mac

    public int alertaAbrirArchivoNoVerificado()
    {
        System.out.println(
            "Este archivo proviene de un desarrollador no verificado."
                + "\n¿Abrir igualmente?"
                + "\n[1] - Si"
                + "\n[2] - No");
        System.out.print("-> Elige una opción: ");
        int opcion = pedirOpcion(1, 2);
        System.out.println();
        return opcion;
    }

    public int alertaSegundoPlano()
    {
        System.out.println(
            "macOS solicita permiso para ejecutar el archivo en segundo plano."
                + "\n¿Permitir?"
                + "\n[1] - Si"
                + "\n[2] - No");
        System.out.print("-> Elige una opción: ");
        int opcion = pedirOpcion(1, 2);
        System.out.println();
        return opcion;
    }

    // ====================================================
    // Anlálisis > config manual > linux

    public int alertaFirewall()
    {
        System.out.println(
            "El firewall de linux está desactivado."
                + "\n¿Deseas activarlo?"
                + "\n[1] - Si"
                + "\n[2] - No");
        System.out.print("-> Elige una opción: ");
        int opcion = pedirOpcion(1, 2);
        System.out.println();
        return opcion;
    }

    public int alertaSODesactualizado()
    {
        System.out.println(
            "Linux está desactualizado. "
                + "\n¿Deseas actualizar a la última versión?"
                + "\n[1] - Si"
                + "\n[2] - No");
        System.out.print("-> Elige una opción: ");
        int opcion = pedirOpcion(1, 2);
        System.out.println();
        return opcion;
    }

    public int alertaConexion()
    {
        System.out.println(
            "PortDaemon ha bloqueado una conexión sospechosa."
                + "\n¿Permitirla manualmente?"
                + "\n[1] - Si"
                + "\n[2] - No");
        System.out.print("-> Elige una opción: ");
        int opcion = pedirOpcion(1, 2);
        System.out.println();
        return opcion;
    }

    // ====================================================
    // Análisis Automático
    // ====================================================

    public void printVariacionDeteccion(int variacion)
    {
        if (variacion >= 0)
        {
            System.out.println(VERDE + "+ " + variacion + " Deteccion\n" + RESET);
        }
        else
        {
            System.out.println(ROJO + variacion + " Deteccion\n" + RESET);
        }
    }

    public void logsAnalisisRaido()
    {
        Utils.esperar(800);

        System.out.println("[ Analisis Rapido ] Escaneando firmas basicas del archivo...");

        Utils.esperar(800);
        System.out.println("[ Analisis Rapido ] Verificacion superficial completada.");

        Utils.esperar(800);
        System.out.println("[ ADVERTENCIA ] Algunas amenazas avanzadas podrian no detectarse.");

        Utils.esperar(800);

        System.out.println();
    }

    public void logsAnalisisProfundo()
    {
        Utils.esperar(800);

        System.out.println(
            "[ Analisis Profundo ] Revisando procesos, memoria y actividad sospechosa......");

        Utils.esperar(800);
        System.out.println(
            "[ INFO ] Escaneo avanzado completado.");

        Utils.esperar(800);

        System.out.println();
    }

    public void logsAnalisisHeuristico()
    {
        Utils.esperar(800);

        System.out
            .println(
                "[ Analisis Heurístico ] Analizando patrones de comportamiento desconocidos...");

        Utils.esperar(800);
        System.out
            .println(
                "[ Analisis Heurístico ] Comparando actividad del archivo con amenazas registradas..");

        Utils.esperar(800);
        System.out
            .println("[ Analisis Heurístico ] Detectando anomalías en tiempo de ejecución...");

        Utils.esperar(800);
        System.out
            .println("[ INFO ] Escaneo Heurístico completado.");

        Utils.esperar(800);

        System.out.println();
    }

    // ====================================================
    // Respuesta ante incidentes > general
    // ====================================================

    public void printStatsRespuesta(int propagacion, int contencion)
    {
        System.out.println(MORADO);
        System.out.println("╭──────────────── STATS ───────────────╮");
        System.out.printf("│ PROPAGACION = %3d | CONTENCION = %3d │%n", propagacion, contencion);
        System.out.println("╰───────────────────┴──────────────────╯");
        System.out.println(RESET);
    }

    public void printAumentoContencion()
    {
        System.out.println(VERDE + "+ 20 Contencion\n" + RESET);
    }

    public void printDisminucionContencion()
    {
        System.out.println(ROJO + "- 20 Contencion\n" + RESET);
    }

    public void printOperacionNoPermitida()
    {
        System.out.println("Operacion no permitida");
    }

    // ====================================================
    // Respuesta ante incidentes > windows

    public int alertaSeguridad()
    {
        System.out.println(
            "Windows Defender no puede garantizar la seguridad del archivo."
                + "\n¿Ejecutar?"
                + "\n[1] - Si"
                + "\n[2] - No");
        System.out.print("-> Elige una opción: ");
        int opcion = pedirOpcion(1, 2);
        System.out.println();
        return opcion;
    }

    public int alertaArchivoDesconocido()
    {
        System.out.println(
            "Archivo desconocido intenta comunicarse con Internet."
                + "\n¿Permitir acceso?"
                + "\n[1] - Si"
                + "\n[2] - No");
        System.out.print("-> Elige una opción: ");
        int opcion = pedirOpcion(1, 2);
        System.out.println();
        return opcion;
    }

    public int alertaWindowsFirewall()
    {
        System.out.println(
            "Windows Firewall ha bloqueado una conexión sospechosa."
                + "\n¿Permitirla manualmente?"
                + "\n[1] - Si"
                + "\n[2] - No");
        System.out.print("-> Elige una opción: ");

        int opcion = pedirOpcion(1, 2);
        System.out.println();
        return opcion;
    }

    // ====================================================
    // Respuesta ante incidentes > mac

    public int alertaPuertoLocal()
    {
        System.out.println(
            "El archivo intenta abrir un puerto local. "
                + "\n¿Permitir apertura de puerto?"
                + "\n[1] - Si"
                + "\n[2] - No");
        System.out.print("-> Elige una opción: ");
        int opcion = pedirOpcion(1, 2);
        System.out.println();
        return opcion;
    }

    public int alertaAccesoFinder()
    {
        System.out.println(
            "El archivo solicita acceso al Finder. "
                + "\n¿Permitir acceso completo?"
                + "\n[1] - Si"
                + "\n[2] - No");
        System.out.print("-> Elige una opción: ");
        int opcion = pedirOpcion(1, 2);
        System.out.println();
        return opcion;
    }

    public int alertaItemsInicio()
    {
        System.out.println(
            "El archivo intenta añadirse a ítems de inicio. "
                + "\n¿Proceder?"
                + "\n[1] - Si"
                + "\n[2] - No");
        System.out.print("-> Elige una opción: ");
        int opcion = pedirOpcion(1, 2);
        System.out.println();
        return opcion;
    }

    // ====================================================
    // Respuesta ante incidentes > linux

    public int alertaSudo()
    {
        System.out.println(
            "Terminal: El archivo intenta ejecutarse con sudo."
                + "\n¿Introducir contraseña?"
                + "\n[1] - Si"
                + "\n[2] - No");
        System.out.print("-> Elige una opción: ");
        int opcion = pedirOpcion(1, 2);
        System.out.println();
        return opcion;
    }

    public int alertaPropagacionSisArchivos()
    {
        System.out.println(
            "El archivo intenta copiarse en varias ubicaciones del sistema."
                + "\n¿Permitir?"
                + "\n[1] - Si"
                + "\n[2] - No");
        System.out.print("-> Elige una opción: ");
        int opcion = pedirOpcion(1, 2);
        System.out.println();
        return opcion;
    }

    // Seleccionar estrategia de análisis
    public int seleccionarTipoAnalisisAutomatico()
    {
        System.out.println(
            "Ahora vamos a realizar un Análisis automático del archivo\n"
                + "¿Qué tipo de análisis deseas realizar?"
                + "\n[1] - Análisis Rápido"
                + "\n[2] - Análisis Profundo"
                + "\n[3] - Análisis Heurístico");
        System.out.print("-> Elige una opción: ");
        int opcion = pedirOpcion(1, 3);
        System.out.println();
        return opcion;
    }

    // ====================================================
    // Mostrar Resultado
    // ====================================================

    public void printAmenazazaNoDetectada()
    {
        System.out.println(MenuConsola.ROJO +
            """
                ╔══════════════════════════════════════════════════════════════╗
                ║                     SISTEMA COMPROMETIDO                     ║
                ╠══════════════════════════════════════════════════════════════╣
                ║  El malware logró evadir los mecanismos de detección         ║
                ║  y se infiltró en el sistema sin ser identificado.           ║
                ║                                                              ║
                ║  Estado final: INFECTADO                                     ║
                ╚══════════════════════════════════════════════════════════════╝
                """ + MenuConsola.RESET);
        AsciiArtManager.printSistemaInfectado();
    }

    public void printAmenazaDetectadaSistemaInfectado()
    {
        System.out.println(MenuConsola.AMARILLO +
            """
                ╔══════════════════════════════════════════════════════════════╗
                ║                   CONTENCIÓN INSUFICIENTE                    ║
                ╠══════════════════════════════════════════════════════════════╣
                ║  La amenaza fue detectada correctamente,                     ║
                ║  pero el protocolo de respuesta no logró detenerla.          ║
                ║                                                              ║
                ║  El malware continúa propagándose por el sistema.            ║
                ║                                                              ║
                ║  Estado final: INFECTADO                                     ║
                ╚══════════════════════════════════════════════════════════════╝
                """ + MenuConsola.RESET);
        AsciiArtManager.printSistemaInfectado();
    }

    public void printAmenazaDetectadaNeutralizada()
    {
        System.out.println(MenuConsola.VERDE +
            """
                ╔═════════════════════════════════════════════════════╗
                ║                 AMENAZA NEUTRALIZADA                ║
                ╠═════════════════════════════════════════════════════╣
                ║  El antivirus detectó y contuvo el malware          ║
                ║  antes de que pudiera comprometer el sistema.       ║
                ║                                                     ║
                ║  Todos los procesos maliciosos han sido eliminados. ║
                ║                                                     ║
                ║  Estado final: SEGURO                               ║
                ╚═════════════════════════════════════════════════════╝
                """ + MenuConsola.RESET);
        AsciiArtManager.printEscudoSistemaSeguro();
    }

    // ====================================================
    // Entrada de datos
    // ====================================================

    // Pide un número y obliga al usuario a que esté entre el MIN y el MAX
    private int pedirOpcion(int min, int max)
    {
        int opcion = -1;
        boolean opcionValida = false;

        do
        {
            try
            {
                // Leemos el número de forma segura (sin el bug del Enter)
                opcion = Integer.parseInt(sc.nextLine());

                // Comprobamos si está en el rango permitido
                if (opcion >= min && opcion <= max)
                {
                    opcionValida = true; // Toodo correcto, salimos del bucle
                }
                else
                {
                    System.out.print(
                        "[Error] Opción fuera de rango. Elige entre " + min + " y " + max + ": ");
                }
            } catch (NumberFormatException e)
            {
                // Si ha metido una letra en vez de un número
                System.out
                    .print("[Error] No has introducido un número válido. Inténtalo de nuevo: ");
            }
        } while (!opcionValida);

        return opcion;
    }

    private String leerTexto()
    {
        String texto = "";
        // Mientras el texto esté vacío o solo tenga espacios, sigue preguntando
        while (texto.trim().isEmpty())
        {
            texto = sc.nextLine();

            if (texto.trim().isEmpty())
            {
                System.out.print("[!] El nombre no puede estar vacío. Escribe algo: ");
            }
        }
        return texto.trim(); // Devuelve el texto quitando espacios extra a los lados
    }
}
