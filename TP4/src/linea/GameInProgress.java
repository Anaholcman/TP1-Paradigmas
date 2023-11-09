package linea;

public abstract class GameInProgress extends Estado{

    public char jugadorActual;
    public GameInProgress(char NuevojugadorActual) {
        jugadorActual = NuevojugadorActual;
    }
        @Override
        public boolean finished() {
            return false;
        }


}
