package org.example.designpatterns.behavioral.command;

import java.util.Stack;

public class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;
    private Stack<Command> undoStack;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];
        undoStack = new Stack<>();

        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        System.out.println("Botão ON " + slot + " pressionado:");
        onCommands[slot].execute();
        undoStack.push(onCommands[slot]);
    }

    public void offButtonWasPushed(int slot) {
        System.out.println("Botão OFF " + slot + " pressionado:");
        offCommands[slot].execute();
        undoStack.push(offCommands[slot]);
    }

    public void undoButtonWasPushed() {
        if (!undoStack.isEmpty()) {
            System.out.println("Botão DESFAZER pressionado:");
            Command lastCommand = undoStack.pop();
            lastCommand.undo();
        } else {
            System.out.println("Nenhum comando para desfazer");
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuff = new StringBuilder();
        stringBuff.append("\n------ Controle Remoto ------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getSimpleName()
                    + "    " + offCommands[i].getClass().getSimpleName() + "\n");
        }
        stringBuff.append("[undo] " + (!undoStack.isEmpty() ? undoStack.peek().getClass().getSimpleName() : "Nenhum") + "\n");
        return stringBuff.toString();
    }
}

