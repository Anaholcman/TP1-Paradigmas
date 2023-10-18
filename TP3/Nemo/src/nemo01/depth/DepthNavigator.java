package nemo01.depth;

public abstract class DepthNavigator {
    public int profundidad;
    public DepthNavigator anterior;
    public abstract DepthNavigator down();
    public abstract DepthNavigator up();
    public abstract void capsula();
    public abstract boolean IsSurface();
}
