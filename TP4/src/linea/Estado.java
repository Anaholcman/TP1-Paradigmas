package linea;

public abstract class Estado {
    public abstract String estadoActual(Linea game);
    public abstract char ficha();
    public abstract String quienJuega();

    public boolean turnoRojas() {
        return false;
    }
    public boolean turnoAzules() {
        return false;
    }
    public boolean finished() {
        return false;
    }

    public abstract Estado change();
    public abstract void playRedAt(int prompt, Linea linea);
    public abstract void playBlueAt(int prompt, Linea linea);
}
