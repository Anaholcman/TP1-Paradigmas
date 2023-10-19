package nemo01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.*;

public class Nemotest {
    @Test
    public void test01InitialSetUp() {
        compareState( new Nemo(), 0,true,0, 0, 1, 0);
    }

    @Test
    public void test02ComandoVacio() {
        Nemo nemo = new Nemo();
        nemo.indications ("");
        compareState( nemo, 0,true,0, 0, 1, 0);
    }

    @Test
    public void test03Descender() {
        Nemo nemo = new Nemo();
        nemo.indications ( "d" );
        compareDepths(nemo, 1);
        compareCapacityOfLaunch(nemo, true);
    }

    @Test
    public void test04AscenderDesdeSurface() {
        Nemo nemo = new Nemo();
        nemo.indications ("u" );
        compareDepths(nemo, 0);
        compareCapacityOfLaunch(nemo, true);
    }

    @Test
    public void test05MultiplesAscensosDesdeSurface() {
        Nemo nemo = new Nemo();
        nemo.indications ( "uuuuu" );
        compareDepths(nemo, 0);
        compareCapacityOfLaunch(nemo, true);
    }
    @Test
    public void test06MutiplesCambiosDeNivel() {
        Nemo nemo = new Nemo();
        nemo.indications ( "dddddduuuu" ); // baja 6 sube 4
        compareDepths(nemo, 2);
        compareCapacityOfLaunch(nemo, false); // pensar si sacarlo o no
    }

    @Test
    public void test07RotarDerecha() {
        Nemo nemo = new Nemo();
        nemo.indications ( "r" );
        compareDirections(nemo, 0, 1);
    }

    @Test
    public void test08RotarIzquierda() {
        Nemo nemo = new Nemo();
        nemo.indications ( "l" );
        compareDirections(nemo, 0, -1);
    }

    @Test
    public void test09Girar90grados(){
        Nemo nemo = new Nemo();
        nemo.indications("ll"); // gira90grados
        compareDirections(nemo, 0, -1);
    }

    @Test
    public void test10Girar360grados() {
        Nemo nemo = new Nemo();
        nemo.indications("rr"); // gira 90 grados
        compareDirections(nemo, -1, 0);
        nemo.indications("rr"); // gira 90 grados
        compareDirections(nemo, 1, 0);
    }

    @Test
    public void test11AvanzarNorth() {
        Nemo nemo = new Nemo();
        nemo.indications ( "f" );
        compareCoords(nemo, 1, 0);
        compareDirections(nemo, 1, 0);
    }

    @Test
    public void test12AvanzarWest() {
        Nemo nemo = new Nemo();
        nemo.indications ( "rf" );
        compareCoords(nemo, 0, 1);
        compareDirections(nemo, 0,1);
    }

    @Test
    public void test13AvanzarEast() {
        Nemo nemo = new Nemo();
        nemo.indications ( "rrf" );
        compareState( nemo, 0,true, -1, 0,-1, 0);
    }

    @Test
    public void test14AvanzarSouth() {
        Nemo nemo = new Nemo();
        nemo.indications ( "lf" );
        compareState( nemo, 0,true, 0, -1,0, -1);
    }

    @Test
    public void test15TirarCapsulaEnSuperficie() {
        Nemo nemo = new Nemo();
        nemo.indications( "m" );
        compareDepths(nemo, 0);
        compareCapacityOfLaunch(nemo, true);
    }

    @Test
    public void test16TirarCapsulaEnBelowSurface() {
        Nemo nemo = new Nemo();
        nemo.indications( "d m" );
        compareDepths(nemo, 1);
        compareCapacityOfLaunch(nemo, true);
    }

    @Test
    public void test17TirarCapsulaEnDeep() {
        Nemo nemo = new Nemo();
        nemo.indications( "d d" );
        compareDepths(nemo, 2);
        compareCapacityOfLaunch(nemo, false);
        assertThrowsLike ( ()->nemo.indications("m") , "No se puede liberar la capsula" );
    }

    private static void compareState( Nemo nemo, int depth, boolean canLaunch,int xcoord, int ycoord, int xdire, int ydire) {
       compareDepths(nemo, depth);
       compareCapacityOfLaunch(nemo, canLaunch);
       compareCoords(nemo, xcoord, ycoord);
       compareDirections(nemo, xdire, ydire);
    }
    private static void compareDepths( Nemo nemo, int depth) {
        assertEquals (depth, nemo.getDepth() );
    }
    private static void compareCapacityOfLaunch( Nemo nemo, boolean canLaunch) {
        assertEquals (canLaunch, nemo.isCapsuleLaunchable() );
    }
    private static void compareCoords( Nemo nemo, int xcoord, int ycoord) {
        assertEquals (xcoord, nemo.getLocation().getX() );
        assertEquals (ycoord, nemo.getLocation().getY() );
    }
    private static void compareDirections( Nemo nemo, int xdire, int ydire) {
        assertEquals (xdire, nemo.getDirection().getX() );
        assertEquals (ydire, nemo.getDirection().getY() );
    }

    private void assertThrowsLike(Executable executable, String message) {
        assertEquals ( message , assertThrows ( Exception.class , executable ) .getMessage() );
    }

}

//public class Nemotest {
//    @Test
//    public void test00() {
//        Nemo nemo = new Nemo();
//        Cardinals north = new North();
//        Coords coords = new Coords();
//        assertEquals ( 0 , nemo.getDepth() );
//        assertTrue ( nemo.InSurface() );
//        assertTrue( nemo.getLocation().equals(coords) );
//        assertTrue( nemo.getDirection().equals(north));
//    }
//    @Test
//    public void test01() {
//        Nemo nemo = new Nemo();
//        Cardinals north = new North();
//        Coords coords = new Coords();
//        nemo.indications ("" );
//        assertTrue( nemo.getLocation().equals(coords) );
//        assertEquals ( nemo.getDepth() , 0 );
//        assertTrue( nemo.getDirection().equals(north));
//    }
//
//    @Test
//    public void test02descender() {
//        Nemo nemo = new Nemo();
//        Cardinals north = new North();
//        Coords coords = new Coords();
//        nemo.indications ( "d" );
//        assertTrue( nemo.getLocation().equals(coords) );
//        assertEquals ( 1 , nemo.getDepth() );
//        assertFalse ( nemo.InSurface() );
//        assertTrue( nemo.getDirection().equals(north));
//    }
//
//    @Test
//    public void test03ascender() {
//        Nemo nemo = new Nemo();
//        Coords coords = new Coords();
//        nemo.indications ("u" );
//        assertTrue( nemo.getLocation().equals(coords) );
//        assertTrue ( nemo.InSurface() );
//    }
//
//    @Test
//    public void test04rotarDerecha() {
//        Nemo nemo = new Nemo();
//        Cardinals east = new East() ;
//        nemo.indications ( "r" );
//        assertTrue( nemo.getDirection().equals(east));
//    }
//
//    @Test
//    public void test05rotarIzquierda() {
//        Nemo nemo = new Nemo();
//        Cardinals west = new West() ;
//        nemo.indications ( "l" );
//        assertTrue( nemo.getDirection().equals(west));
//    }
//
//    @Test
//    public void test06avanzar() {
//        Nemo nemo = new Nemo();
//        Cardinals north = new North();
//        Coords coords = new Coords();
//        coords.add( north );
//        nemo.indications ( "f" );
//        assertTrue( nemo.getLocation().equals(coords) );
//        assertTrue( nemo.getDirection().equals(north));
//    }
//
//    @Test
//    public void test07avanzar2() {
//        Nemo nemo = new Nemo();
//        Cardinals north = new North();
//        Coords coords = new Coords();
//        coords.add( north );
//        coords.add( north );
//        nemo.indications ( "ff" );
//        assertTrue( nemo.getLocation().equals(coords) );
//        assertTrue( nemo.getDirection().equals(north));
//    }
//    @Test
//    public void test08FallaTirarCapsula() {
//        Nemo nemo = new Nemo();
//        nemo.indications( "d d" );
//        assertThrowsLike ( ()->nemo.indications("m") , "No se puede liberar la capsula" );
//    }
//
//    @Test
//    public void test09girar2veces(){
//        Nemo nemo = new Nemo();
//        Cardinals south = new South();
//        nemo.indications("ll");
//        assertTrue( nemo.direccion.equals(south));
//    }
//    @Test
//    public void test09girarYVolver() {
//        Nemo nemo = new Nemo();
//        Cardinals north = new North();
//        nemo.indications("lr");
//        assertTrue( nemo.getDirection().equals(north));
//    }
//
//
//    @Test
//    public void test10ascensoSinLimitacion() {
//        Nemo nemo = new Nemo();
//        nemo.indications ( "dddddd" );
//        // Verificar que se pueda ascender múltiples unidades sin problemas.
//        // queda en 0
//        nemo.indications ( "uuuuuu" );
//        assertEquals ( 0 , nemo.getDepth() );
//    }
//
//    private void assertThrowsLike(Executable executable, String message) {
//        assertEquals ( message , assertThrows ( Exception.class , executable ) .getMessage() );
//    }
//}