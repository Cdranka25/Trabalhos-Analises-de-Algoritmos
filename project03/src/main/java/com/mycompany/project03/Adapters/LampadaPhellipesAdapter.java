package com.mycompany.project03.Adapters;

import br.furb.analise.algoritmos.LampadaPhellipes;

public class LampadaPhellipesAdapter implements LampadaAdapter {
    private LampadaPhellipes lampada;

    public LampadaPhellipesAdapter() {
        this.lampada = new LampadaPhellipes();
    }

    @Override
    public void ligar() {
        lampada.setIntensidade(100);
    }

    @Override
    public void desligar() {
        lampada.setIntensidade(0);
    }
}
