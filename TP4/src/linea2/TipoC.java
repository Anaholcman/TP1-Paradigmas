package linea2;

public class TipoC extends Estrategia {
    public boolean isChar(char letra) {
        return letra == 'C';
    }
    public boolean finished(Linea juego, int donde) {
        return juego.TerminadoPorLinea( donde ) || juego.TerminadoPorDiagonal( donde );
    }
}
