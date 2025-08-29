package com.mycompany.project03.Adapters.ArCondicionado;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;

public class ArCondicionadoGellaKazaAdapter implements ArCondicionadoAdapter {
  private ArCondicionadoGellaKaza arCondicionado;

  public ArCondicionadoGellaKazaAdapter() {
    this.arCondicionado = new ArCondicionadoGellaKaza();
    setTemperature(25);
  }

  @Override
  public void ligar() {
    arCondicionado.ativar();
  }

  @Override
  public void desligar() {
    arCondicionado.desativar();
  }

  @Override
  public void increaseTemperature() {
    arCondicionado.aumentarTemperatura();
  }

  @Override
  public void decreaseTemperature() {
    arCondicionado.diminuirTemperatura();
  }

  @Override
  public void setTemperature(int temperatura) {
    int temperaturaAtual = arCondicionado.getTemperatura();
    int diferenca = temperatura - temperaturaAtual;

    for (int i = 0; i < Math.abs(diferenca); i++) {
      if (diferenca > 0) {
        arCondicionado.diminuirTemperatura();
      } else {
        arCondicionado.aumentarTemperatura();
      }
    }
  }
}
