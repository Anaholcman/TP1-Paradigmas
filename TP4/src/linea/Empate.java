package linea;

public class Empate extends Estado {
    public String estadoActual(Linea game) {
        return "Juego terminado en empate";
    }
    public char ficha() {
        return ' ';
    }
    public String quienJuega() {
        return null;
    }

    public boolean finished() {
        return true;
    }

    public Estado change() {
        return this;
    }
    public void playRedAt(int prompt, Linea linea) {
        throw new RuntimeException(Linea.JUEGOTERMINADO);
    }
    public void playBlueAt(int prompt, Linea linea) {
        throw new RuntimeException(Linea.JUEGOTERMINADO);
    }
}
