package nemo01.depth;

public class Surface extends DepthNavigator {
    public Surface() {
        profundidad = 0;
    }
    public DepthNavigator down() {
        return new BelowSurface();
    }
    public DepthNavigator up() {
        return this;
    }
    public void lanzamientoDeCapsula() {}
    public boolean canLaunchCapsule() {
        return true;
    }
}