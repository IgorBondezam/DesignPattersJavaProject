package org.example.designpatterns.behavioral.strategy;

public interface PaymentStrategy {
    boolean pay(int paymentAmount);
    void collectPaymentDetails();
}

