package antivirus;

import malware.*;
import sistema.*;

public class ProtocoloAntivirus
{
    // ------------------------------- Atributos
    private Malware archivo;
    private Sistema sistema;

    // ------------------------ Métodos Públicos
    // <Template Method>
    public void procesarArchivo()
    {
        if (analizarArchivo(this.archivo))
        {
            responder(this.archivo);
        }

        // Comportamiento común TEMPALTE METHOD
        mostrarResultado();
    }

    private boolean analizarArchivo(Malware Malware)
    {

        return false;
    }

    private void responder(Malware archivo)
    {

    }

    private void mostrarResultado()
    {

    }
    // </Template Method>
}
