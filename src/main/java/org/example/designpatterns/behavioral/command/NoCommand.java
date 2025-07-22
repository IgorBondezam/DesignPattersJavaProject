package org.example.designpatterns.behavioral.command;

public class NoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Nenhum comando atribuído a este slot");
    }

    @Override
    public void undo() {
        System.out.println("Nenhum comando para desfazer");
    }
}

