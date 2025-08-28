/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project02;

/**
 *
 * @author vergiliogu
 */
public class Order {
    public OrderType orderType;
    public Double price;
    public Stock stock;
    public Investor investor;

    public Order(OrderType orderType, Double price, Stock stock, Investor investor) {
        this.orderType = orderType;
        this.price = price;
        this.stock = stock;
        this.investor = investor;
    }
}
