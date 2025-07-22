package com.igorbondezam.designpatterns.behavioral.strategy;

import java.util.Scanner;

public class PayPalStrategy implements PaymentStrategy {
    private String email;
    private String password;
    private boolean signedIn;

    public PayPalStrategy(boolean signedIn) {
        this.signedIn = signedIn;
    }

    @Override
    public void collectPaymentDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o email do PayPal: ");
        this.email = "user@example.com"; // Simulado
        System.out.println(this.email);
        
        System.out.print("Digite a senha do PayPal: ");
        this.password = "password123"; // Simulado
        System.out.println("********");
        
        // Simular login
        if(this.signedIn) {
            System.out.println("Login no PayPal bem-sucedido.");
        } else {
            System.out.println("Falha ao realizar o login.");
        }
    }

    @Override
    public boolean pay(int paymentAmount) {
        if (signedIn) {
            System.out.println("Pagando $" + paymentAmount + " usando PayPal.");
            return true;
        } else {
            return false;
        }
    }
}

