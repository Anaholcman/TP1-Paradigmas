package nemo01.commands;

import nemo01.Nemo;

public class Avanzar extends Commands {
    public boolean isCommand(char c) {
        return c == 'f';
    }

    public void execute(Nemo nemo){ nemo.avanzar();}
}
