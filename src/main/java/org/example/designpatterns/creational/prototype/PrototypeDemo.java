package org.example.designpatterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class PrototypeDemo {
    
    public static void demonstrate() {
        System.out.println("=== PROTOTYPE PATTERN ===");
        System.out.println("Problema: Copiar objetos existentes sem tornar o código dependente de suas classes");
        System.out.println("Solução: Delegar o processo de clonagem para os próprios objetos\n");
        
        List<Shape> shapes = new ArrayList<>();
        List<Shape> shapesCopy = new ArrayList<>();

        // Criando formas originais
        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "Vermelho";
        shapes.add(circle);

        Circle anotherCircle = (Circle) circle.clone();
        shapes.add(anotherCircle);

        Rectangle rectangle = new Rectangle();
        rectangle.width = 10;
        rectangle.height = 20;
        rectangle.x = 5;
        rectangle.y = 10;
        rectangle.color = "Azul";
        shapes.add(rectangle);

        System.out.println("Formas originais:");
        for (Shape shape : shapes) {
            shape.draw();
            System.out.println();
        }

        // Clonando todas as formas
        System.out.println("Clonando todas as formas...\n");
        for (Shape shape : shapes) {
            shapesCopy.add(shape.clone());
        }

        System.out.println("Formas clonadas:");
        for (Shape shape : shapesCopy) {
            shape.draw();
            System.out.println();
        }

        // Verificando se são objetos diferentes mas com conteúdo igual
        System.out.println("Verificando clonagem:");
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) != shapesCopy.get(i)) {
                System.out.println("✓ Forma " + (i+1) + ": Objetos diferentes (clonagem bem-sucedida)");
            } else {
                System.out.println("✗ Forma " + (i+1) + ": Mesmo objeto (falha na clonagem)");
            }
            
            if (shapes.get(i).equals(shapesCopy.get(i))) {
                System.out.println("✓ Forma " + (i+1) + ": Conteúdo idêntico");
            } else {
                System.out.println("✗ Forma " + (i+1) + ": Conteúdo diferente");
            }
            System.out.println();
        }

        System.out.println("Vantagens:");
        System.out.println("- Clona objetos sem acoplar a classes concretas");
        System.out.println("- Elimina código de inicialização repetitivo");
        System.out.println("- Produz objetos complexos mais convenientemente");
        System.out.println("- Alternativa à herança para lidar com configurações de objetos complexos");
    }
}

