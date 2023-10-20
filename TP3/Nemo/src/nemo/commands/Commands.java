package nemo01.commands;

import nemo01.Nemo;
import nemo01.direccion.Cardinals;

import java.util.Arrays;
import java.util.List;

public abstract class Commands {
    public static List<Commands> commandsList = Arrays.asList(
            new Descender(),
            new Ascender(),
            new Izquierda(),
            new Derecha(),
            new Avanzar(),
            new Lanzar()
    );
    public abstract boolean isCommand(char c);
    public abstract void execute(Nemo nemo);
}
