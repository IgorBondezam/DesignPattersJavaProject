package org.example.designpatterns.behavioral.strategy;

import org.example.utils.CmdVisualUtils;

public class StrategyDemo {
    
    public static void demonstrate() {
        System.out.println("=== STRATEGY PATTERN ===");
        System.out.println("Problema: Definir família de algoritmos e torná-los intercambiáveis");
        System.out.println("Solução: Encapsular algoritmos em classes separadas e torná-los intercambiáveis\n");
        
        // Criando pedido
        Order order = firstScenarioOrder();

        CmdVisualUtils.separetorCmd(50);


        // Teste 1: Pagamento com cartão de crédito
        System.out.println("Teste 1: Pagamento com cartão de crédito");
        PaymentStrategy creditCardStrategy = new CreditCardStrategy();
        order.processOrder(creditCardStrategy);


        CmdVisualUtils.separetorCmd(50);



        // Criando novo pedido para testar PayPal
        Order order2 = secondScenarioOrder();


        // Teste 2: Pagamento com PayPal
        System.out.println("\nTeste 2: Pagamento com PayPal");
        PaymentStrategy payPalStrategy = new PayPalStrategy(true);
        order2.processOrder(payPalStrategy);
        
        CmdVisualUtils.separetorCmd(50);



        // Teste 3: Demonstrando intercambialidade
        System.out.println("Teste 3: Mudando estratégia de pagamento");
        Order order3 = new Order();
        order3.addItem("Livro", 30);
        
        System.out.println("Pedido: " + order3.getItems() + " - Total: $" + order3.getTotalCost());



        // Primeiro tentativa com PayPal
        System.out.println("\nTentativa 1: PayPal");
        PaymentStrategy strategy = new PayPalStrategy(true); //Vai dar errado por causa dessa flag com isso caindo no if abaixo
        order3.processOrder(strategy);



        // Se não funcionou, criar novo pedido e tentar com cartão
        if (!order3.isClosed()) {
            System.out.println("\nTentativa 2: Cartão de Crédito");
            strategy = new CreditCardStrategy(); // A mesma instância da acima, porém mudando o tipo para o creditCard
            order3.processOrder(strategy);
        }





        System.out.println("\nVantagens:");
        System.out.println("- Permite trocar algoritmos em tempo de execução");
        System.out.println("- Isola detalhes de implementação dos algoritmos");
        System.out.println("- Substitui herança por composição");
        System.out.println("- Segue o princípio Open/Closed");
        System.out.println("- Elimina condicionais complexas");
    }

    private static Order firstScenarioOrder() {
        Order order =
                new Order();
        order.addItem("Notebook", 1200);
        order.addItem("Mouse", 25);
        order.addItem("Teclado", 75);

        System.out.println("Pedido criado:");
        System.out.println("Itens: " + order.getItems());
        System.out.println("Total: $" + order.getTotalCost());
        return order;
    }

    private static Order secondScenarioOrder() {
        Order order2 = new Order();
        order2.addItem("Smartphone", 800);
        order2.addItem("Capa", 20);

        System.out.println("Novo pedido criado:");
        System.out.println("Itens: " + order2.getItems());
        System.out.println("Total: $" + order2.getTotalCost());
        return order2;
    }
}

