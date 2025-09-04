package com.mycompany.project03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ControllTest {

    static class FakeLampada implements com.mycompany.project03.Adapters.Lampada.LampadaAdapter {
        private boolean ligada = false;

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

    static class FakeArCondicionado implements com.mycompany.project03.Adapters.ArCondicionado.ArCondicionadoAdapter {
        private boolean ligado = false;
        private int temperatura = 24;

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

    static class FakePersiana implements com.mycompany.project03.Adapters.Persianas.PersianasAdapter {
        private boolean levantada = true;

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

    private Controll controll;

    @BeforeEach
    void setUp() {
        controll = new Controll();
    }

    @Test
    void testTurnOnAllBulbs() {
        FakeLampada lamp = new FakeLampada();
        controll.newBulb(lamp);

        controll.turnOnAllBulbs();

        assertTrue(lamp.isLigada(), "A lâmpada deveria estar ligada");
    }

    @Test
    void testTurnOffAllBulbs() {
        FakeLampada lamp = new FakeLampada();
        lamp.ligar(); 
        controll.newBulb(lamp);

        controll.turnOffAllBulbs();

        assertFalse(lamp.isLigada(), "A lâmpada deveria estar desligada");
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
        FakeLampada lamp = new FakeLampada();
        FakeArCondicionado ar = new FakeArCondicionado();
        FakePersiana pers = new FakePersiana();

        lamp.ligar();
        ar.ligar();
        pers.rise();

        controll.newBulb(lamp);
        controll.newAirConditioner(ar);
        controll.newBlind(pers);

        controll.modoSono();

        assertFalse(lamp.isLigada(), "Lâmpada deveria estar desligada no modo sono");
        assertFalse(ar.isLigado(), "Ar-condicionado deveria estar desligado no modo sono");
        assertFalse(pers.isLevantada(), "Persiana deveria estar abaixada no modo sono");
    }

    @Test
    void testModoTrabalho() {
        FakeLampada lamp = new FakeLampada();
        FakeArCondicionado ar = new FakeArCondicionado();
        FakePersiana pers = new FakePersiana();

        controll.newBulb(lamp);
        controll.newAirConditioner(ar);
        controll.newBlind(pers);

        controll.modoTrabalho();

        assertTrue(lamp.isLigada(), "Lâmpada deveria estar ligada no modo trabalho");
        assertTrue(ar.isLigado(), "Ar-condicionado deveria estar ligado no modo trabalho");
        assertEquals(25, ar.getTemperatura(), "Ar-condicionado deveria estar em 25°C no modo trabalho");
        assertTrue(pers.isLevantada(), "Persiana deveria estar levantada no modo trabalho");
    }
}