package linea;

public class Terminado extends Estado {
    public char ficha() {
        return ' ';
    }
    public String quienJuega() {
        return null;
    }
    public String estadoActual(Linea game){
        return "Juego terminado \n El ganador es " + game.ganador();
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
