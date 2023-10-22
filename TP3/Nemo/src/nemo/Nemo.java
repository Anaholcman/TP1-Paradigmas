package nemo;

public class Nemo {
    public DepthNavigator depth;
    public Coords location;
    public Cardinals direccion;

    public Nemo(){
        depth = new Surface();
        location = new Coords(0,0);
        direccion = new North();
    }

    public void indications(String s) {
        s.chars().forEach( character ->
                Commands.commandsList.stream()
                        .filter( com -> com.isCommand( (char) character) )
                        .forEach( com -> com.execute(this) ) );
    }

    public boolean isCapsuleLaunchable() {
        return depth.isSurface();
    }
    public int getDepth() {
        return depth.profundidad;
    }
    public Coords getLocation() {
        return location;
    }
    public Cardinals getDirection() {
        return direccion;
    }

    public void avanzar() {
        this.location = location.add(direccion);
    }
    public void ascender() {
        this.depth = depth.up();
    }
    public void descender() {
        this.depth = depth.down();
    }
    public void rotarDerecha() {
        this.direccion = direccion.right();
    }
    public void rotarIzquierda() {
        this.direccion = direccion.left();
    }
    public void lanzarCapsula() {
        this.depth.lanzamientoDeCapsula();
    }
}
