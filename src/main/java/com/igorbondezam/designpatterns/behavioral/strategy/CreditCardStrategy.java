package com.igorbondezam.designpatterns.behavioral.strategy;

import java.util.Scanner;

public class CreditCardStrategy implements PaymentStrategy {
    private CreditCard card;

    @Override
    public void collectPaymentDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do cartão: ");
        String number = "1234-5678-9012-3456"; // Simulado
        System.out.println(number);
        
        System.out.print("Digite a data de expiração 'mm/yy': ");
        String date = "12/25"; // Simulado
        System.out.println(date);
        
        System.out.print("Digite o código CVV: ");
        String cvv = "123"; // Simulado
        System.out.println(cvv);
        
        card = new CreditCard(number, date, cvv);
    }

    @Override
    public boolean pay(int paymentAmount) {
        if (cardIsPresent()) {
            System.out.println("Pagando $" + paymentAmount + " usando cartão de crédito.");
            card.setAmount(card.getAmount() - paymentAmount);
            return true;
        } else {
            return false;
        }
    }

    private boolean cardIsPresent() {
        return card != null;
    }
}

