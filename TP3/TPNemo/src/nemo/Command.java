package nemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Command {

    // jerarquia de comandos.
    // los comandos estan definidos. arriba abajo, etc
    // pensar en una list
    // para todo elemento en la lista, cada uno canHandle(c)
    // Command.commandFor("c")
    // los comandos ya existen como los puntos cardinales
    //

    String key;

    public static final List<Object> commandList = Arrays.asList(
        new Up(),
        new Down(),
        new Left(),
        new Right(),
        new Forward(),
        new LanzarCapsula()
    );

    private boolean canHandle(String s){
        return each.applies(s);
    }
    private abstract void commandFor(String s){
        return each.applies(s);
    }
    private abstract void execute(){
        return each.ejecutar();
    }
}
