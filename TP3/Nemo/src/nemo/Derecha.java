package nemo;

public class Derecha extends Commands {
    public boolean isCommand(char c) {
        return c == 'r';
    }
    public void execute(Nemo nemo) {nemo.rotarDerecha();}
}
