/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author vergiliogu
 */
public class NotificationService {
  private HashMap<String, List<Investor>> stockObservers = new HashMap<>();

  public static NotificationService letsGooo() {
    return new NotificationService();
  }

  public void subscribeStock(Stock stock) {
    stockObservers.putIfAbsent(stock.code, new ArrayList<>());
  }

  public void subscribeInvestor(Investor investor, Stock stock) {
    List<Investor> investors = stockObservers.get(stock.code);
    investors.add(investor);
  }

  public void notifyInvestors(Stock stock) {
    List<Investor> investors = stockObservers.get(stock.code);

    for (Investor investor : investors) {
      System.out
          .println("Notifying " + investor.name + " about stock: " + stock.code + " with price: " + stock.currentPrice);
    }
  }
}
