package nemo;

public class Surface extends Depth{
    public Surface(){
        profundidad = 0;
    }
    public Depth down() {
        return new BelowSurface();
    }
    public Depth up() {
        return this;
    }

    @Override
    public void lanzarCapsula() {
    }

    public boolean IsSurface() {
        return true;
    }

    @Override
    public int actualDepth(int diferencial) {
        return profundidad + diferencial;
    }
}
