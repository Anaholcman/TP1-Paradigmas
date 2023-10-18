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

    @Override
    public void lanzarCapsula() {
    }

    public boolean IsSurface() {
        return false;
    }

    @Override
    public int actualDepth(int diferencial) {
        return profundidad + diferencial;
    }
}