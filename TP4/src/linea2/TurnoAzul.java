package linea2;

public class TurnoAzul extends GameInProgress {

    public TurnoAzul() {
        super('X');
    }

    @Override
    public boolean turnoRojas() {
        return false;
    }

    public boolean turnoAzules() {
        return true;
    }
    public GameInProgress change() { //
//        if (linea.comprobarTerminado('A',donde)){
//            return new Terminado();
//        }
        return new TurnoRed();
    }
    public void playRedAt(int prompt, Linea linea) {
        throw new RuntimeException(Linea.NOESTUTURNO);
    }
    public void playBlueAt(int prompt, Linea linea) {
        linea.playAt('X', prompt);
    }
    public String TurnoActual() {
        return "Azul";
    }

}
