package nemo01;

import nemo01.commands.Commands;
import nemo01.coords.Coords;
import nemo01.depth.DepthNavigator;
import nemo01.depth.Surface;
import nemo01.direccion.Cardinals;
import nemo01.direccion.North;

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
        return depth.canLaunchCapsule();
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
        this.location =location.add(this.direccion);
    }
    public void ascender() {
        this.depth = depth.up();
    }
    public void descender() {
        this.depth = this.depth.down();
    }
    public void rotarDerecha() {
        this.direccion = this.direccion.right();
    }

    public void rotarIzquierda() {
        this.direccion = this.direccion.left();

    }

    public void lanzarCapsula() {
        this.depth.lanzamientoDeCapsula();
    }
}
