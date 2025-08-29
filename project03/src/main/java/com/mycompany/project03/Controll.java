/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.project03;

import java.util.List;

import com.mycompany.project03.Adapters.LampadaAdapter;

/**
 *
 * @author vergiliogu
 */
public class Controll {
    private List<LampadaAdapter> lampadas;
    // private List<LampadaAdapter> arcondicionados;
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

    // public void newAirConditioner(LampadaAdapter arcondicionado) {
    //     arcondicionados.add(arcondicionado);
    // }

    // public void newBlind(LampadaAdapter persiana) {
    //     persianas.add(persiana);
    // }

}
