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
    public char ficha() {
        return 'X';
    }
    public void playRedAt(int prompt, Linea linea) {
        throw new RuntimeException(Linea.NOESTUTURNO);
    }
    public void playBlueAt(int prompt, Linea linea) {
        linea.playAt( prompt);
    }
    public String estadoActual(Linea game){
        return "Playing Blue";
    }

    public String quienJuega() {
        return "Azul";
    }

}
