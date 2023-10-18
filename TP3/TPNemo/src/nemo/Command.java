package nemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Command {

    // jerarquia de comandos.
    // los comandos estan definidos. arriba abajo, etc
    // pensar en una list
    // para todo elemento en la lista, cada uno canHandle(c)
    // Command.commandFor("c")
    // los comandos ya existen como los puntos cardinales
    //

    String key;

    public final List<Object> commandList = Arrays.asList(
        new Up(),
        new Down(),
        new Left(),
        new Right(),
        new Forward(),
        new LanzarCapsula()
    );

    protected abstract void commandFor(char c, Depth depth);
    private abstract void execute();

}
