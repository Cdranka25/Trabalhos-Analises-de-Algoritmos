/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.project03;

import java.util.List;

import com.mycompany.project03.Adapters.ArCondicionado.ArCondicionadoAdapter;
import com.mycompany.project03.Adapters.Lampada.LampadaAdapter;

/**
 *
 * @author vergiliogu
 */
public class Controll {
    private List<LampadaAdapter> lampadas;
    private List<ArCondicionadoAdapter> arcondicionados;
    // private List<LampadaAdapter> persianas;

    // public static void main(String[] args) {
    //     LampadaPhellipes lp = new LampadaPhellipes();
    //     lp.setIntensidade(98);
    //     System.out.println(lp.getIntensidade());
    // }

    public void newBulb(LampadaAdapter lampada) {
        lampadas.add(lampada);
    }

    public void turnOnAllBulbs() {
        for (LampadaAdapter lampada : lampadas) {
            lampada.ligar();
        }
    }

    public void turnOffAllBulbs() {
        for (LampadaAdapter lampada : lampadas) {
            lampada.desligar();
        }
    }

    public void newAirConditioner(ArCondicionadoAdapter arcondicionado) {
        arcondicionados.add(arcondicionado);
    }

    public void turnOnAllAirConditioners() {
        for (ArCondicionadoAdapter arcondicionado : arcondicionados) {
            arcondicionado.ligar();
        }
    }

    public void turnOffAllAirConditioners() {
        for (ArCondicionadoAdapter arcondicionado : arcondicionados) {
            arcondicionado.desligar();
        }
    }

    public void increaseAllAirConditionersTemperature() {
        for (ArCondicionadoAdapter arcondicionado : arcondicionados) {
            arcondicionado.increaseTemperature();
        }
    }

    public void decreaseAllAirConditionersTemperature() {
        for (ArCondicionadoAdapter arcondicionado : arcondicionados) {
            arcondicionado.decreaseTemperature();
        }
    }

    public void setAllAirConditionersTemperature(int temperatura) {
        for (ArCondicionadoAdapter arcondicionado : arcondicionados) {
            arcondicionado.setTemperature(temperatura);
        }
    }

    // public void newBlind(LampadaAdapter persiana) {
    //     persianas.add(persiana);
    // }

}
