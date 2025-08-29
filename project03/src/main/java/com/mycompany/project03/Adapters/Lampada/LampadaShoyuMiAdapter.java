package com.mycompany.project03.Adapters.Lampada;

import br.furb.analise.algoritmos.LampadaShoyuMi;

public class LampadaShoyuMiAdapter implements LampadaAdapter {
    private LampadaShoyuMi lampada;

    public LampadaShoyuMiAdapter() {
        this.lampada = new LampadaShoyuMi();
    }

    @Override
    public void ligar() {
        lampada.ligar();
    }

    @Override
    public void desligar() {
        lampada.desligar();
    }
}
