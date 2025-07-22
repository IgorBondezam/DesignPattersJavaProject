package org.example.designpatterns;

import org.example.designpatterns.creational.factorymethod.FactoryMethodDemo;
import org.example.designpatterns.creational.abstractfactory.AbstractFactoryDemo;
import org.example.designpatterns.creational.builder.BuilderDemo;
import org.example.designpatterns.creational.prototype.PrototypeDemo;
import org.example.designpatterns.creational.singleton.SingletonDemo;

import org.example.designpatterns.structural.adapter.AdapterDemo;
import org.example.designpatterns.structural.bridge.BridgeDemo;
import org.example.designpatterns.structural.composite.CompositeDemo;
import org.example.designpatterns.structural.decorator.DecoratorDemo;
import org.example.designpatterns.structural.facade.FacadeDemo;
import org.example.designpatterns.structural.flyweight.FlyweightDemo;
import org.example.designpatterns.structural.proxy.ProxyDemo;

import org.example.designpatterns.behavioral.chainofresponsibility.ChainOfResponsibilityDemo;
import org.example.designpatterns.behavioral.command.CommandDemo;
import org.example.designpatterns.behavioral.iterator.IteratorDemo;
import org.example.designpatterns.behavioral.observer.ObserverDemo;
import org.example.designpatterns.behavioral.strategy.StrategyDemo;
import org.example.designpatterns.behavioral.templatemethod.TemplateMethodDemo;
import org.example.designpatterns.behavioral.visitor.VisitorDemo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            printMenu();
            try {
                System.out.print("Escolha um padrão para demonstrar (0 para sair): ");
                choice = scanner.nextInt();
                System.out.println("\n" + "=".repeat(70) + "\n");

                switch (choice) {
                    case 1: FactoryMethodDemo.demonstrate(); break;
                    case 2: AbstractFactoryDemo.demonstrate(); break;
                    case 3: BuilderDemo.demonstrate(); break;
                    case 4: PrototypeDemo.demonstrate(); break;
                    case 5: SingletonDemo.demonstrate(); break;

                    case 6: AdapterDemo.demonstrate(); break;
                    case 7: BridgeDemo.demonstrate(); break;
                    case 8: CompositeDemo.demonstrate(); break;
                    case 9: DecoratorDemo.demonstrate(); break;
                    case 10: FacadeDemo.demonstrate(); break;
                    case 11: FlyweightDemo.demonstrate(); break;
                    case 12: ProxyDemo.demonstrate(); break;

                    case 13: ChainOfResponsibilityDemo.demonstrate(); break;
                    case 14: CommandDemo.demonstrate(); break;
                    case 15: IteratorDemo.demonstrate(); break;
                    case 16: ObserverDemo.demonstrate(); break;
                    case 17: StrategyDemo.demonstrate(); break;
                    case 18: TemplateMethodDemo.demonstrate(); break;
                    case 19: VisitorDemo.demonstrate(); break;

                    case 0: System.out.println("Saindo..."); break;
                    default: System.out.println("Opção inválida. Tente novamente.");
                }
                System.out.println("\n" + "=".repeat(70) + "\n");
                if (choice != 0) {
                    System.out.println("Pressione Enter para continuar...");
                    scanner.nextLine();
                    scanner.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine();
                choice = -1;
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("=== DEMONSTRAÇÃO DE DESIGN PATTERNS ===");
        System.out.println("--- Padrões Criacionais ---");
        System.out.println("1. Factory Method");
        System.out.println("2. Abstract Factory");
        System.out.println("3. Builder");
        System.out.println("4. Prototype");
        System.out.println("5. Singleton");
        System.out.println("--- Padrões Estruturais ---");
        System.out.println("6. Adapter");
        System.out.println("7. Bridge");
        System.out.println("8. Composite");
        System.out.println("9. Decorator");
        System.out.println("10. Facade");
        System.out.println("11. Flyweight");
        System.out.println("12. Proxy");
        System.out.println("--- Padrões Comportamentais ---");
        System.out.println("13. Chain of Responsibility");
        System.out.println("14. Command");
        System.out.println("15. Iterator");
        System.out.println("16. Observer");
        System.out.println("17. Strategy");
        System.out.println("18. Template Method");
        System.out.println("19. Visitor");
        System.out.println("-----------------------------------");
        System.out.println("0. Sair");
    }
}

