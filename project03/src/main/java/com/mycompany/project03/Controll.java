/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.project03;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.project03.Adapters.ArCondicionado.ArCondicionadoAdapter;
import com.mycompany.project03.Adapters.Lampada.LampadaAdapter;
import com.mycompany.project03.Adapters.Persianas.PersianasAdapter;

/**
 *
 * @author vergiliogu
 */
public class Controll {
    private List<LampadaAdapter> lampadas;
    private List<ArCondicionadoAdapter> arcondicionados;
    private List<PersianasAdapter> persianas;

    // public static void main(String[] args) {
    // LampadaPhellipes lp = new LampadaPhellipes();
    // lp.setIntensidade(98);
    // System.out.println(lp.getIntensidade());
    // }

    public Controll() {
        this.lampadas = new ArrayList<>();
        this.arcondicionados = new ArrayList<>();
        this.persianas = new ArrayList<>();
    }

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

    public void newBlind(PersianasAdapter persiana) {
        persianas.add(persiana);
    }

    public void modoSono() {
        for (LampadaAdapter lampada : lampadas) {
            lampada.desligar();
        }

        for (ArCondicionadoAdapter ar : arcondicionados) {
            ar.desligar();
        }

        for (PersianasAdapter p : persianas) {
            p.lower();
        }
    }

    public void modoTrabalho() {
        for (LampadaAdapter lampada : lampadas) {
            lampada.ligar();
        }

        for (ArCondicionadoAdapter ar : arcondicionados) {
            ar.ligar();
            ar.setTemperature(25);
        }

        for (PersianasAdapter p : persianas) {
            p.rise();
        }
    }
}
