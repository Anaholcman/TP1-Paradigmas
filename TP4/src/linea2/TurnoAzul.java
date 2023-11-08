package linea2;

public class TurnoAzul extends Estado {
    public boolean turnoAzules() {
        return true;
    }
    public Estado change() {
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

}
