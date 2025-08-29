/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.project03;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mycompany.project03.Adapters.ArCondicionado.ArCondicionadoAdapter;
import com.mycompany.project03.Adapters.Lampada.LampadaAdapter;
import com.mycompany.project03.Adapters.Persianas.PersianasAdapter;

import br.furb.analise.algoritmos.LampadaPhellipes;
import br.furb.analise.algoritmos.LampadaShoyuMi;

import org.junit.jupiter.api.DisplayName;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author user
 */

public class ControllTest {

    private Controll controll;
    private List<LampadaAdapter> lampadas;
    private List<ArCondicionadoAdapter> arcondicionados;
    private List<PersianasAdapter> persianas;

    public ControllTest() {
        controll = new Controll();
        this.lampadas = new ArrayList<>();
        this.arcondicionados = new ArrayList<>();
        this.persianas = new ArrayList<>();
    }

    @BeforeAll
    public static void initAll() {

    }


    @Test
    public void Teste01_addBulb() {

    }
}
