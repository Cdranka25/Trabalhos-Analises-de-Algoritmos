package model;

public class LampadaPhellipes {
    private int intensidade;

    public void setIntensidade(int intensidade) {
        if (intensidade < 0) {
            this.intensidade = 0;
        } else if (intensidade > 100) {
            this.intensidade = 100;
        } else {
            this.intensidade = intensidade;
        }
    }

    public int getInstensidade() {
        return intensidade;
    }
}
