package nemo01;

public abstract class Depth {
    public int profundidad;
    public abstract Depth down();
    public abstract Depth up();
    public abstract void capsula();
    public abstract boolean IsSurface();
    public int value() {
        return profundidad;
    }
}
