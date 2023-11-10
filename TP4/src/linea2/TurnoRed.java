package linea2;

public class TurnoRed extends Estado {
    public boolean turnoRojas() {
        return true;
    }
    public Estado change() {
//        if (linea.comprobarTerminado('R',donde)){
//            return new Terminado();
//        }
        return new TurnoAzul();
    }
    public void playRedAt(int prompt, Linea linea) {
        linea.playAt( prompt);
    }
    public void playBlueAt(int prompt, Linea linea) {
        throw new RuntimeException(Linea.NOESTUTURNO);
    }

    public String estadoActual(Linea game){
        return "Playing Red";
    }

    public char ficha() {
        return '0';
    }

}
