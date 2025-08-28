public class ArCondicionadoGellaKaza {
    private int temperatura;
    private boolean ligado;

    public void ativar() {
        ligado = true;
    }

    public void desativar() {
        ligado = false;
    }

    public void aumentarTemperatura() {
        temperatura++;
    }
    public void diminuirTemperatura() {
        temperatura--;
    }
    public boolean estaLigado() {
        return ligado;
    }
    public int getTemperatura() {
        return temperatura;
    }
}
