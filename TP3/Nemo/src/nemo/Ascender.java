package nemo;

public class Ascender extends Commands {
    public boolean isCommand(char c) {
        return c == 'u' ;
    }
    public void execute(Nemo nemo) { nemo.ascender(); }
}
