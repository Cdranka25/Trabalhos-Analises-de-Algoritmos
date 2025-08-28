public class ArCondicionadoVentoBaumn {
    private int temperatura;
    private boolean ligado;

    public void ligar() {
        ligado = true;
    }

    public void desligar() {
        ligado = false;
    }

    public void definirTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public boolean estaLigado() {
        return ligado;
    }

    public int getTemperatura() {
        return temperatura;
    }
}
