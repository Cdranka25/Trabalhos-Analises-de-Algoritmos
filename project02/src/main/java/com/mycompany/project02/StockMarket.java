/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author vergiliogu
 */
public class StockMarket {
  private NotificationService notificationService = NotificationService.letsGooo();
  private List<Order> orders;
  private List<Stock> stocks;

  public StockMarket() {
    this.orders = new ArrayList<>();
    this.stocks = new ArrayList<>();
  }

  public void addOrder(Order order) {
    orders.add(order);

    searchForMatchingOrders(order);
  }

  public void searchForMatchingOrders(Order newOrder) {
    Iterator<Order> iterator = orders.iterator();
    while (iterator.hasNext()) {
      Order existingOrder = iterator.next();
      if (existingOrder.stock.code.equals(newOrder.stock.code) &&
          existingOrder.orderType != newOrder.orderType &&
          existingOrder.price.equals(newOrder.price)) {

        iterator.remove();

        orders.remove(newOrder);

        updateStockPrice(newOrder.stock, newOrder.price);
        notificationService.notifyInvestors(newOrder.stock);
        return;
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

  public List<Stock> getStocks() {
    return Collections.unmodifiableList(this.stocks);
  }
}
