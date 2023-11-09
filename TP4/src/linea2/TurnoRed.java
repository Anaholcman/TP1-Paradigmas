package linea2;

public class TurnoRed extends GameInProgress {

    public TurnoRed(){
        super('0');
    }
    public boolean turnoRojas() {
        return true;
    }
    public boolean turnoAzules() {
        return false;
    }
    public GameInProgress change() {
        return new TurnoAzul();
    }
    public void playRedAt(int prompt, Linea linea) {
        linea.playAt('0', prompt);
    }
    public void playBlueAt(int prompt, Linea linea) {
        throw new RuntimeException(Linea.NOESTUTURNO);
    }
    public String TurnoActual() {
        return "Rojo";
    }
}
