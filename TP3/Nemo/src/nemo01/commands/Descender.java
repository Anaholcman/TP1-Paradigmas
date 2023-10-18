package nemo01.commands;

import nemo01.Nemo;

public class Descender extends Commands {
    //'d' , () -> depth.down()
    public boolean isCommand(char c) {
        return c == 'd';
    }

    public void execute(Nemo nemo) {
        nemo.depth = nemo.depth.down();
    }
}
