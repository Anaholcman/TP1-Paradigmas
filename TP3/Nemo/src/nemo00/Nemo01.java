//package nemo00;
//
//import nemo01.coords.Coords;
//import nemo01.depth.Depth;
//import nemo01.direccion.Direccion;
//import nemo01.direccion.North;
//import nemo01.direccion.Surface;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Nemo01 {
//    public Depth depth;
//    public Coords location;
//    public Direccion direccion;
//    private Map <Character, Runnable> movements = new HashMap<>();
//
//    public Nemo01(){
//        depth = new Surface();
//        location = new Coords();
//        direccion = new North();
//        movements.put ( 'd' , () -> depth.down() );
//        movements.put ( 'u' , () -> depth.up() );
//        movements.put ( 'l' , () -> direccion.left() );
//        movements.put ( 'r' , () -> direccion.right() );
//        movements.put ( 'f' , () -> location.add( getDirection() ) );
//        movements.put ( 'm' , () -> depth.capsula() );
//    }
//
//    public boolean InSurface() {
//        return depth.IsSurface();
//    }
//
//    public Coords getLocation() {
//        return location;
//    }
//
//    public Direccion getDirection() {
//        return direccion;
//    }
//
//    public void indications(String s) {
//        s.chars().forEach( (c) -> movements.get(c) );
//    }
//
//    public int getDepth() {
//        return depth.value();
//    }
//}
