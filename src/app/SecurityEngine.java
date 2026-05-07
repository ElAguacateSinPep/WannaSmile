package app;

import malware.*;
import sistema.*;
import utils.Utils;
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

        AsciiArtManager.printhappyface();
        AsciiArtManager.printLogoPrincipal();

        // Elegir orden de creación
        int eleccion = menu.printMenuPrincipal();

        if (eleccion == 1)
        { // Primero Malware
            configurarMalware();
            menu.printTransicionASistema();
            configurarSistema();
        }
        else
        { // Primero Sistema
            configurarSistema();
            menu.printTransicionAMalware();
            configurarMalware();
        }

        // Aqui se accede a la arquiterura de sistema y se le pasa a malware
        this.malwareAtacante.setObjetivo(this.sistemaDefensa);
        printCreacion();

        // Se inicializa el antivirus
        // todo descomentar esta línea para presentar
        // Utils.esperar(3000);

        antivirus.setMalware(malwareAtacante);
        antivirus.setSistema(sistemaDefensa);
        menu.printAntivirusArchivoDetectado();

        antivirus.protocoloAntiIndicentes();
    }

    // ------------------------ Métodos Privados
    private void configurarMalware()
    {
        int pref = menu.printPreferenciaMalware();
        if (pref == 1)
        {
            int op = menu.printOpcionesPreconfiguradoMalware();
            this.malwareAtacante = malwareFactory.crearMalwarePreconfigurado(op);
        }
        else
        {
            // Creación paso a paso con Decoradores
            this.malwareAtacante = malwareFactory.crearMalwareBase();

            int tipoOp = menu.printMalwareConfiguracion();
            this.malwareAtacante = new TipoDecorator(this.malwareAtacante, tipoOp);

            String nombre = menu.printMalwareNombre();
            this.malwareAtacante = new NombreDecorator(this.malwareAtacante, nombre);

            int puntosSigilo = menu.printMalwareSigilo();
            this.malwareAtacante = new SigiloDecorator(this.malwareAtacante, puntosSigilo);

            this.malwareAtacante = new PropagacionDecorator(this.malwareAtacante, puntosSigilo);

            int opcionElegida = menu.printMalwareSistemaObjetivo();
            this.malwareAtacante = new SODecorator(this.malwareAtacante, opcionElegida);
        }
        menu.printMalwareListo();
    }

    private void configurarSistema()
    {
        int pref = menu.printPreferenciaSistema();
        if (pref == 1)
        {
            int op = menu.printOpcionesPreconfiguradoSistema();
            this.sistemaDefensa = sistemaFactory.crearSistemaPreconfigurado(op);
        }
        else
        {
            // Creación paso a paso con Decoradores de Sistema

            this.sistemaDefensa = new SistemaBase();

            // 2. Envolvemos con el Nombre
            String nombre = menu.printSistemaNombre();
            this.sistemaDefensa = new NombreSistemaDecorator(this.sistemaDefensa, nombre);

            // 3. Envolvemos con el Sistema Operativo
            int soOp = menu.printSistemaConfiguracion();
            this.sistemaDefensa = new SOSistemaDecorator(this.sistemaDefensa, soOp);

            // 4. Envolvemos con la Arquitectura
            int arqOp = menu.printSistemaArquitectura();
            this.sistemaDefensa = new ArquitecturaDecorator(this.sistemaDefensa, arqOp);

            // 5. Envolvemos con la deteccion y automaticamente con la contencion
            int puntosDeteccionContencion = menu.printSistemaDeteccion();
            this.sistemaDefensa = new DeteccionDecorator(this.sistemaDefensa,
                puntosDeteccionContencion);
            this.sistemaDefensa = new ContencionDecorator(this.sistemaDefensa,
                puntosDeteccionContencion);
        }
        menu.printSistemaDesplegado();
    }

    private void printCreacion()
    {
        menu.printCreacion(sistemaDefensa, malwareAtacante);

        // Mostrar arte ASCII final
        printArteFinal();
    }

    private void printArteFinal()
    {
        String tipo = malwareAtacante.getTipo();
        if (tipo.contains("Troyano"))
            AsciiArtManager.printTroyano();
        else if (tipo.contains("Ransomware"))
            AsciiArtManager.printRansomware();
        else if (tipo.contains("Keylogger"))
            AsciiArtManager.printKeylogger();
    }
}
