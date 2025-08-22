/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.project02;

/**
 *
 * @author vergiliogu
 */
public class Homebroker {
    private NotificationService notificationService = NotificationService.letsGooo();
    private StockMarket stockMarket = new StockMarket();

    public static Homebroker letsGooo() {
        return new Homebroker();
    }

    public void registerOrder(Order order) {
        stockMarket.addOrder(order);
    }

    public String getStockPrice(String stockCode) {
        Double price = stockMarket.getStockPrice(stockCode);
        return String.format("%s: %.2f", stockCode,price);
    }

    public void subscribeInvestor(Investor investor, Stock stock) {
        notificationService.subscribeInvestor(investor, stock);
    }
}
