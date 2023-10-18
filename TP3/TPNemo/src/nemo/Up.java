package nemo;

public class Up extends Command {
    private String key = "l";

    public Depth depth;
    public Coords location;
    public Direccion direccion;

    private boolean applies(String x){
        return this.key==x;
    }


    private void ejecute(){
        Depth.profundidad ++;
    }

    @Override
    protected void commandFor(char c, Depth depth) {
        return applies(String.valueOf(c)));
    }
}
