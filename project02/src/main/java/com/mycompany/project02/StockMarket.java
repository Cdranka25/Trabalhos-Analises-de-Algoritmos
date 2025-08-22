/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project02;

import java.util.List;

/**
 *
 * @author vergiliogu
 */
public class StockMarket {
  private NotificationService notificationService = NotificationService.letsGooo();
  private List<Order> orders;
  private List<Stock> stocks;

  public void addOrder(Order order) {
    orders.add(order);

    searchForMatchingOrders(order);
  }

  public void searchForMatchingOrders(Order newOrder) {
    for (Order existingOrder : orders) {
      if (existingOrder.stock.code.equals(newOrder.stock.code) &&
          existingOrder.orderType != newOrder.orderType &&
          existingOrder.price.equals(newOrder.price)) {
            removeMatchingOrders(newOrder, existingOrder);
            updateStockPrice(newOrder.stock, newOrder.price);
            notificationService.notifyInvestors(newOrder.stock);
      }
    }
  }

  private void removeMatchingOrders(Order order1, Order order2) {
    orders.removeIf(existingOrder -> existingOrder == order1 || existingOrder == order2);
  }

  private void updateStockPrice(Stock stock, Double newPrice) {
    stock.currentPrice = newPrice;
  }

  public void addStock(Stock stock) {
    stocks.add(stock);
    notificationService.subscribeStock(stock);
  }

  public Double getStockPrice(String stockCode) {
    for (Stock stock : stocks) {
      if (stock.code.equals(stockCode)) {
        return stock.currentPrice;
      }
    }

    throw new IllegalArgumentException("Stock with code " + stockCode + " not found.");
  }
}
