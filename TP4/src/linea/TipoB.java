package linea;

public class TipoB extends Estrategia {
    public boolean isChar(char letra) {
        return letra == 'B';
    }
    public boolean finished(Linea juego, int donde) {
        return juego.TerminadoPorDiagonal( donde);
    }
}
