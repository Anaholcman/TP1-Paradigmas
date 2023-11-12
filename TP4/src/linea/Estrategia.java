package linea;

import java.util.Arrays;
import java.util.List;

public abstract class Estrategia {
    public static final String ESTRATEGIAINVALIDA = "La estrategia no es válida. Debe ser A, B o C.";
    public static List<Estrategia> estrategias = Arrays.asList( new TipoA(), new TipoB(), new TipoC() );
    public abstract boolean isChar(char letra);
    public abstract boolean finished(Linea juego, int donde);

    public static Estrategia getEstrategia(char tipoDeJuego) {
        return estrategias.stream()
                        .filter(estrategia -> estrategia.isChar(tipoDeJuego))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException(ESTRATEGIAINVALIDA));
    }
}
