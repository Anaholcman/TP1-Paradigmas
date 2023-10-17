package nemo;

public class BelowSurface extends Depth {
    public BelowSurface(){
        profundidad = 1;
    }
    public Depth down() {
        return new Deep();
    }
    public Depth up() {
        return new Surface();
    }
    public void capsula() {
    }
    public boolean IsSurface() {
        return false;
    }
}