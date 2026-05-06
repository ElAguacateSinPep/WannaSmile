package sistema;

import gui.MenuConsola;

public class SistemaMac extends SistemaBase
{
    // --------------------------- Constructores
    public SistemaMac()
    {
        this.arquitectura = "ARM";
    }
    // --------------------------------- Getters
    @Override
    public String getNombre()
    {
        return "Macbook Pro M5";
    }

    @Override
    public String getSO()
    {
        return "macOS";
    }

    @Override
    public int getDeteccion()
    {
        return 50;
    }

    @Override
    public int getContencion()
    {
        return 50;
    }

    @Override
    public int ejecutarAnalisisManual()
    {
        MenuConsola menu = new MenuConsola();
        int variacionSigilo = 0;

        if(menu.alertaAbrirArchivoNoVerificado() == 1)
            variacionSigilo += 10;
        else
            variacionSigilo -= 10;

        if(menu.alertaSegundoPlano() == 1)
            variacionSigilo += 10;
        else
            variacionSigilo -= 10;

        return variacionSigilo;
    }
}
