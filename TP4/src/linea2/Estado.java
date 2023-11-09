package linea2;

public abstract class Estado {

    public boolean turnoRojas() {
        return false;
    }
    public boolean turnoAzules() {
        return false;
    }
    public abstract boolean finished();
    public abstract Estado change();
    public abstract void playRedAt(int prompt, Linea linea);
    public abstract void playBlueAt(int prompt, Linea linea);
    public abstract String TurnoActual();
}
