package nemo01.commands;

import nemo01.Nemo;

public class Ascender extends Commands {
    //'u' , () -> depth.up()
    public boolean isCommand(char c) {
        return c == 'u' ;
    }

    public void execute(Nemo nemo) {
        nemo.depth = nemo.depth.up();
    }
}
