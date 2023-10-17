package nemo;
import java.util.HashMap;
import java.util.Map;

public class Nemo {
    public Depth depth;
    public Coords location;
    public Direccion direccion;

    public Nemo() {
        depth = new Surface();
        location = new Coords();
        direccion = new North();
    }

    public boolean InSurface() {
        return depth.IsSurface();
    }

    public Coords getLocation() {
        return location;
    }

    public Direccion getDirection() {
        return direccion;
    }


    public void indications1(String s ){
        Command.commandList.commandFor("c").ejecutar();
    }
    public int getDepth() {
        return depth.value();
    }
}








