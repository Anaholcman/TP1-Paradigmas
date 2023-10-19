package nemo01.commands;

import nemo01.Nemo;

public class Derecha extends Commands {
    //'r' , () -> direccion.right()
    public boolean isCommand(char c) {
        return c == 'r';
    }
    public void execute(Nemo nemo) {
        nemo.direccion = nemo.direccion.right();
    }
}
