package org.example.designpatterns.behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int totalCost = 0;
    private boolean isClosed = false;
    private List<String> items = new ArrayList<>();

    public void processOrder(PaymentStrategy strategy) {
        strategy.collectPaymentDetails();
        // Aqui poderíamos coletar dados do usuário, mas vamos simular
        if (strategy.pay(totalCost)) {
            System.out.println("Pagamento bem-sucedido.");
            isClosed = true;
        } else {
            System.out.println("FALHA no pagamento.");
        }
    }

    public void setTotalCost(int cost) {
        this.totalCost = cost;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void addItem(String item, int cost) {
        items.add(item);
        totalCost += cost;
    }

    public List<String> getItems() {
        return items;
    }
}

