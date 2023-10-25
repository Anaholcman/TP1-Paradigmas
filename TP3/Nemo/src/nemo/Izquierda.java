package nemo;

public class Izquierda extends Commands {
    public boolean isCommand(char c) {
        return c == 'l';
    }
    public void execute(Nemo nemo) { nemo.rotarIzquierda(); }
}
