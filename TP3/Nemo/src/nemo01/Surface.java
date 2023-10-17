package nemo01;

public class Surface extends Depth {
    public Surface(){
        profundidad = 0;
    }
    public Depth down() {
        return new BelowSurface();
    }
    public Depth up() {
        return this;
    }
    public void capsula() {

    }
    public boolean IsSurface() {
        return true;
    }
}
