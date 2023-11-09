package linea2;

public class GameOver extends Estado {

    private String ultimoJugador;
    public Estado change() {
        return this;
    }
    public boolean finished() {
        return true;
    }
    public void playRedAt(int prompt, Linea linea) {
        throw new RuntimeException(Linea.JUEGOTERMINADO);
    }
    public void playBlueAt(int prompt, Linea linea) {
        throw new RuntimeException(Linea.JUEGOTERMINADO);
    }

    @Override
    public String TurnoActual() {
        return ultimoJugador;
    } // quiero que devuelva el ganador


}
