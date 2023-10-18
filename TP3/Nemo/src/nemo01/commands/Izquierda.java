package nemo01.commands;

import nemo01.Nemo;

public class Izquierda extends Commands {
    // 'l' , () -> direccion.left()
    public boolean isCommand(char c) {
        return c == 'l';
    }

    public void execute(Nemo nemo) {
        nemo.direccion = nemo.direccion.left();
    }
}
