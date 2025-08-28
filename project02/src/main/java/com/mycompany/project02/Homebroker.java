/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.project02;

import java.util.Locale;

/**
 *
 * @author vergiliogu
 */
public class Homebroker {
    private NotificationService notificationService = NotificationService.letsGooo();
    private StockMarket stockMarket = new StockMarket();

    public Homebroker(NotificationService notificationService, StockMarket stockMarket) {
        this.notificationService = notificationService;
        this.stockMarket = stockMarket;
    }

    public static Homebroker letsGooo() {
        return new Homebroker(NotificationService.letsGooo(), new StockMarket());
    }

    public void registerOrder(Order order) {
        stockMarket.addOrder(order);
    }

    public String getStockPrice(String stockCode) {
        Double price = stockMarket.getStockPrice(stockCode);
        return String.format(Locale.US, "%s: %.2f", stockCode, price);
    }

    public void subscribeInvestor(Investor investor, Stock stock) {
        notificationService.subscribeInvestor(investor, stock);
    }
}
