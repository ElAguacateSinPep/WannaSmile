package app;

import malware.*;
import sistema.*;
import defensa.Antivirus;
import gui.*;

public class SecurityEngine
{
    // ------------------------------- Atributos
    private static SecurityEngine instanciaUnica;
    private MenuConsola           menu;

    private MalwareFactory        malwareFactory;
    private SistemaFactory        sistemaFactory;

    private Malware               malwareAtacante;
    private Sistema               sistemaDefensa;
    private Antivirus             antivirus;
    // --------------------------- Constructores
    private SecurityEngine()
    {
        this.menu = new MenuConsola();
        this.malwareFactory = new MalwareFactory();
        this.sistemaFactory = new SistemaFactory();
        this.antivirus = new Antivirus();
    }
    // ------------------------ Métodos Públicos
    public static SecurityEngine getInstance()
    {
        if (instanciaUnica == null)
        {
            // Se crea solo la primera vez
            instanciaUnica = new SecurityEngine();
        }
        return instanciaUnica;
    }

    public void iniciarSimulacion()
    {

        AsciiArtManager.imprimirhappyface();
        AsciiArtManager.imprimirLogoPrincipal();

        // Elegir orden de creación
        int eleccion = menu.ImprimirMenuPrincipal();

        if (eleccion == 1)
        { // Primero Malware
            configurarMalware();
            menu.imprimirTransicionASistema();
            configurarSistema();
        }
        else
        { // Primero Sistema
            configurarSistema();
            menu.imprimirTransicionAMalware();
            configurarMalware();
        }

        // Aqui se accede a la arquiterura de sistema y se le pasa a malware
        this.malwareAtacante.setObjetivo(this.sistemaDefensa);
        MostrarCreacion();

        // Se inicializa el antivirus
        // todo descomentar esta línea para presentar
        // esperar(3000);

        antivirus.setMalware(malwareAtacante);
        antivirus.setSistema(sistemaDefensa);
        menu.antivirusArchivoDetectado();

        antivirus.protocoloAntiIndicentes();
    }
    // ------------------------ Métodos Privados
    private void configurarMalware()
    {
        int pref = menu.imprimirPreferenciaMalware();
        if (pref == 1)
        {
            int op = menu.imprimirOpcionesPreconfiguradoMalware();
            this.malwareAtacante = malwareFactory.crearMalwarePreconfigurado(op);
        }
        else
        {
            // Creación paso a paso con Decoradores
            this.malwareAtacante = malwareFactory.crearMalwareBase();

            int tipoOp = menu.imprimirMalwareConfiguracion();
            this.malwareAtacante = new TipoDecorator(this.malwareAtacante, tipoOp);

            String nombre = menu.imprimirMalwareNombre();
            this.malwareAtacante = new NombreDecorator(this.malwareAtacante, nombre);

            int puntosSigilo = menu.imprimirMalwareSigilo();
            this.malwareAtacante = new SigiloDecorator(this.malwareAtacante, puntosSigilo);

            this.malwareAtacante = new PropagacionDecorator(this.malwareAtacante, puntosSigilo);

            int opcionElegida = menu.imprimirMalwareSistemaObjetivo();
            this.malwareAtacante = new SODecorator(this.malwareAtacante, opcionElegida);
        }
        System.out.println("[+] Malware listo en memoria.");
    }

    private void configurarSistema()
    {
        int pref = menu.imprimirPreferenciaSistema();
        if (pref == 1)
        {
            int op = menu.imprimirOpcionesPreconfiguradoSistema();
            this.sistemaDefensa = sistemaFactory.crearSistemaPreconfigurado(op);
        }
        else
        {
            // Creación paso a paso con Decoradores de Sistema

            this.sistemaDefensa = new SistemaBase();

            // 2. Envolvemos con el Nombre
            String nombre = menu.imprimirSistemaNombre();
            this.sistemaDefensa = new NombreSistemaDecorator(this.sistemaDefensa, nombre);

            // 3. Envolvemos con el Sistema Operativo
            int soOp = menu.imprimirSistemaConfiguracion();
            this.sistemaDefensa = new SOSistemaDecorator(this.sistemaDefensa, soOp);

            // 4. Envolvemos con la Arquitectura
            int arqOp = menu.imprimirSistemaArquitectura();
            this.sistemaDefensa = new ArquitecturaDecorator(this.sistemaDefensa, arqOp);

            // 5. Envolvemos con la deteccion y automaticamente con la contencion
            int puntosDeteccionContencion = menu.imprimirSistemaDeteccion();
            this.sistemaDefensa = new DeteccionDecorator(this.sistemaDefensa, puntosDeteccionContencion);
            this.sistemaDefensa = new ContencionDecorator(this.sistemaDefensa, puntosDeteccionContencion);
        }
        System.out.println("[+] Sistema de defensa desplegado.");
    }

    private void MostrarCreacion()
    {

        System.out.println("\n========================================");
        System.out.println("       ESTADO FINAL DE LA CREACIÓN");
        System.out.println("========================================");

        System.out.println("SISTEMA DEFENSA:");
        System.out.println(" -> Nombre: " + sistemaDefensa.getNombre());
        System.out.println(" -> SO: " + sistemaDefensa.getSO());
        System.out.println(" -> Arquitectura: " + sistemaDefensa.getArquitectura());
        System.out.println(" -> Puntos Detección: " + sistemaDefensa.getDeteccion());
        System.out.println(" -> Puntos Contención: " + sistemaDefensa.getContencion());

        System.out.println("\nAMENAZA ATACANTE:");
        System.out.println(" -> Nombre: " + malwareAtacante.getNombre());
        System.out.println(" -> Tipo: " + malwareAtacante.getTipo());
        System.out.println(" -> Arquitectura Objetivo: " + malwareAtacante.getArquitectura());
        System.out.println(" -> Puntos Sigilo: " + malwareAtacante.getSigilo());
        System.out.println(" -> Puntos Propagación: " + malwareAtacante.getPropagacion());
        System.out.println("========================================\n");

        // Mostrar arte ASCII final
        imprimirArteFinal();
    }

    private void imprimirArteFinal()
    {
        String tipo = malwareAtacante.getTipo();
        if (tipo.contains("Troyano"))
            AsciiArtManager.imprimirTroyano();
        else if (tipo.contains("Ransomware"))
            AsciiArtManager.imprimirRansomware();
        else if (tipo.contains("Keylogger"))
            AsciiArtManager.imprimirKeylogger();
    }

    private void esperar(int milisegundos)
    {
        try
        {
            Thread.sleep(milisegundos);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
