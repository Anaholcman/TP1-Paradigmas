package linea2;

public abstract class GameInProgress {
protected char jugadorActual;

    public GameInProgress(char jugador) {
        jugadorActual = jugador;
    }
    public abstract boolean turnoRojas();
    public abstract boolean turnoAzules();
    public abstract GameInProgress change();
    public boolean finished() {
        return false;
    }

    public void playRedAt(int prompt, Linea linea) {
    }
    public void playBlueAt(int prompt, Linea linea) {
    }
}
