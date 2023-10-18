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
        location = new Coords();
        direccion = new North();
    }
    public void indications(String s) {
        s.chars().forEach( character ->
                Commands.commandsList.stream()
                        .filter( com -> com.isCommand( (char) character) )
                        .forEach( com -> com.execute(this) ) );
    }
    public boolean InSurface() {
        return depth.IsSurface();
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
}
