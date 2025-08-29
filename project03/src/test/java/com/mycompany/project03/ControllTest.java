package com.mycompany.project03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mycompany.project03.Controll;

import static org.junit.jupiter.api.Assertions.*;


class FakeLampada implements com.mycompany.project03.Adapters.Lampada.LampadaAdapter {
    boolean ligada = false;

    @Override
    public void ligar() {
        ligada = true;
    }

    @Override
    public void desligar() {
        ligada = false;
    }

    public boolean isLigada() {
        return ligada;
    }
}

class FakeArCondicionado implements com.mycompany.project03.Adapters.ArCondicionado.ArCondicionadoAdapter {
    boolean ligado = false;
    int temperatura = 24;

    @Override
    public void ligar() {
        ligado = true;
    }

    @Override
    public void desligar() {
        ligado = false;
    }

    @Override
    public void increaseTemperature() {
        temperatura++;
    }

    @Override
    public void decreaseTemperature() {
        temperatura--;
    }

    @Override
    public void setTemperature(int temperatura) {
        this.temperatura = temperatura;
    }

    public boolean isLigado() {
        return ligado;
    }

    public int getTemperatura() {
        return temperatura;
    }
}

class FakePersiana implements com.mycompany.project03.Adapters.Persianas.PersianasAdapter {
    boolean levantada = true;

    @Override
    public void rise() {
        levantada = true;
    }

    @Override
    public void lower() {
        levantada = false;
    }

    public boolean isLevantada() {
        return levantada;
    }
}

public class ControllTest {

    private Controll controll;

    @BeforeEach
    void setUp() {
        controll = new Controll();
    }

    @Test
    void testTurnOnAllBulbs() {
        FakeLampada lampada = new FakeLampada();
        controll.newBulb(lampada);

        controll.turnOnAllBulbs();

        assertTrue(lampada.isLigada(), "A lâmpada deveria estar ligada");
    }

    @Test
    void testTurnOffAllBulbs() {
        FakeLampada lampada = new FakeLampada();
        lampada.ligar();
        controll.newBulb(lampada);

        controll.turnOffAllBulbs();

        assertFalse(lampada.isLigada(), "A lâmpada deveria estar desligada");
    }

    @Test
    void testTurnOnAllAirConditioners() {
        FakeArCondicionado ar = new FakeArCondicionado();
        controll.newAirConditioner(ar);

        controll.turnOnAllAirConditioners();

        assertTrue(ar.isLigado(), "O ar-condicionado deveria estar ligado");
    }

    @Test
    void testSetAllAirConditionersTemperature() {
        FakeArCondicionado ar = new FakeArCondicionado();
        controll.newAirConditioner(ar);

        controll.setAllAirConditionersTemperature(20);

        assertEquals(20, ar.getTemperatura(), "A temperatura deveria ser 20");
    }

    @Test
    void testModoSono() {
        FakeLampada lampada = new FakeLampada();
        FakeArCondicionado ar = new FakeArCondicionado();
        FakePersiana persiana = new FakePersiana();

        lampada.ligar();
        ar.ligar();
        persiana.rise();

        controll.newBulb(lampada);
        controll.newAirConditioner(ar);
        controll.newBlind(persiana);

        controll.modoSono();

        assertFalse(lampada.isLigada(), "Lâmpada deveria estar desligada no modo sono");
        assertFalse(ar.isLigado(), "Ar-condicionado deveria estar desligado no modo sono");
        assertFalse(persiana.isLevantada(), "Persiana deveria estar abaixada no modo sono");
    }

    @Test
    void testModoTrabalho() {
        FakeLampada lampada = new FakeLampada();
        FakeArCondicionado ar = new FakeArCondicionado();
        FakePersiana persiana = new FakePersiana();

        controll.newBulb(lampada);
        controll.newAirConditioner(ar);
        controll.newBlind(persiana);

        controll.modoTrabalho();

        assertTrue(lampada.isLigada(), "Lâmpada deveria estar ligada no modo trabalho");
        assertTrue(ar.isLigado(), "Ar-condicionado deveria estar ligado no modo trabalho");
        assertEquals(25, ar.getTemperatura(), "Ar-condicionado deveria estar em 25°C no modo trabalho");
        assertTrue(persiana.isLevantada(), "Persiana deveria estar levantada no modo trabalho");
    }
}
