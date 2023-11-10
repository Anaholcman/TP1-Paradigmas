package linea2;

public class Terminado extends Estado {
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
}
