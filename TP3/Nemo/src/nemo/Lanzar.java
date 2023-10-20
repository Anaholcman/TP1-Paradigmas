package nemo;

public class Lanzar extends Commands {
    public boolean isCommand(char c) {
        return c == 'm';
    }
    public void execute(Nemo nemo) {
        nemo.lanzarCapsula();
    }
}
