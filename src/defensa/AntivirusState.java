package defensa;

import malware.Malware;

public interface AntivirusState
{
    public void avanzarEstado(Antivirus antivirus);

    public void mostrarDesenlace(Malware malware);
}
