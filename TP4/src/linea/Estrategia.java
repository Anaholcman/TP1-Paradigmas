package linea;

import java.util.Arrays;
import java.util.List;

public abstract class Estrategia {
    public static List<Estrategia> estrategias = Arrays.asList( new TipoA(), new TipoB(), new TipoC() );
    public abstract boolean isChar(char letra);
    public abstract boolean finished(Linea juego, int donde);
}
