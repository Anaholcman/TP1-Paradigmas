package nemo;

public class Up extends Command {
    private String key = "l";

    public Depth depth;
    public Coords location;
    public Direccion direccion;

    private boolean applies(String x){
        return this.key==x;
    }

    protected Command commandFor(String s, Depth depth){

    }
    private void ejecute(){
        Depth.profundidad ++;
    }
}
