package linea;

public class TurnoAzul extends Estado {
    public String estadoActual(Linea game){
        return "Playing Blue";
    }
    public String quienJuega() {
        return "Azul";
    }
    public char ficha() {
        return 'X';
    }

    public boolean turnoAzules() {
        return true;
    }

    public Estado change() {
        return new TurnoRed();
    }

    public void playRedAt(int prompt, Linea linea) {
        throw new RuntimeException(Linea.NOESTUTURNO);
    }
    public void playBlueAt(int prompt, Linea linea) {
        linea.playAt( prompt);
    }
}
