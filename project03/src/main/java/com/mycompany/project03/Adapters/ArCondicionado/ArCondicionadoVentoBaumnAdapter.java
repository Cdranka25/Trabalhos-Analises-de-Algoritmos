package com.mycompany.project03.Adapters.ArCondicionado;

import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;

public class ArCondicionadoVentoBaumnAdapter implements ArCondicionadoAdapter {
  private ArCondicionadoVentoBaumn arCondicionado;

  public ArCondicionadoVentoBaumnAdapter() {
    this.arCondicionado = new ArCondicionadoVentoBaumn();
    arCondicionado.definirTemperatura(25);
  }

  @Override
  public void ligar() {
    arCondicionado.ligar();
  }

  @Override
  public void desligar() {
    arCondicionado.desligar();
  }

  @Override
  public void increaseTemperature() {
    int temperaturaAtual = arCondicionado.getTemperatura();
    arCondicionado.definirTemperatura(temperaturaAtual + 1);
  }

  @Override
  public void decreaseTemperature() {
    int temperaturaAtual = arCondicionado.getTemperatura();
    arCondicionado.definirTemperatura(temperaturaAtual - 1);
  }

  @Override
  public void setTemperature(int temperatura) {
    arCondicionado.definirTemperatura(temperatura);
  }
}
