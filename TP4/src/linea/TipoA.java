package linea;

public class TipoA extends Estrategia {
    public boolean isChar(char letra) {
        return letra == 'A';
    }
    public boolean finished(Linea juego, int donde) {
        return juego.TerminadoPorLinea( donde);
    }
}
