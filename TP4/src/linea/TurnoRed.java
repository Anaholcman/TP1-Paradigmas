package linea;

public class TurnoRed extends Estado {
    public String estadoActual(Linea game){
        return "Playing Red";
    }
    public char ficha() {
        return '0';
    }
    public String quienJuega() {
        return "Rojo";
    }

    public boolean turnoRojas() {
        return true;
    }

    public Estado change() {
        return new TurnoAzul();
    }
    public void playRedAt(int prompt, Linea linea) {
        linea.playAt( prompt);
    }
    public void playBlueAt(int prompt, Linea linea) {
        throw new RuntimeException(Linea.NOESTUTURNO);
    }

}
