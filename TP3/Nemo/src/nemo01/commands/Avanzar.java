package nemo01.commands;

import nemo01.Nemo;

public class Avanzar extends Commands {
    //'f' , () -> location.add( getDirection() )
    public boolean isCommand(char c) {
        return c == 'f';
    }

    public void execute(Nemo nemo) {
        nemo.location = nemo.location.add( nemo.direccion );
    }
}
