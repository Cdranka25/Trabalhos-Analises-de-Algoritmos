package com.mycompany.project03.Adapters.Persianas;

import br.furb.analise.algoritmos.PersianaNatLight;

public class PersianaNatLightAdapter implements PersianasAdapter {
  private PersianaNatLight persiana;

  public PersianaNatLightAdapter() {
    this.persiana = new PersianaNatLight() {
    };
  };

  @Override
  public void rise() {
    if (!persiana.estaPalhetaAberta()) {
      persiana.abrirPalheta();
    }

    try {
      persiana.subirPalheta();
    } catch (Exception e) {
      // No treatment
    }
  }

  @Override
  public void lower() {
    persiana.descerPalheta();

    try {
      persiana.fecharPalheta();
    } catch (Exception e) {
      // No treatment
    }
  }
}
