package nemo;

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
    public void indications(String s){
        s.chars().forEach(character -> Command.command

    public int getDepth() {
        return depth.actualDepth(0);
    }
}








