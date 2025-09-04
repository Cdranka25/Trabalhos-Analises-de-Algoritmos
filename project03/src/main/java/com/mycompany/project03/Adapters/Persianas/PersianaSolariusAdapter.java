package com.mycompany.project03.Adapters.Persianas;

import br.furb.analise.algoritmos.PersianaSolarius;

public class PersianaSolariusAdapter implements PersianasAdapter {
    private PersianaSolarius persiana;

    @Override
    public void rise() {
        if (!persiana.estaAberta())
            persiana.subirPersiana();
    }

    @Override
    public void lower() {
        if (persiana.estaAberta())
            persiana.descerPersiana();
    }

}