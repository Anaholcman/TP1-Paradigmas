package nemo01;

import nemo01.depth.Deep;
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
        createSubmarineWithCommand("");
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
        compareDirections(nemo, -1, 0);
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
        assertThrowsLike ( ()->nemo.indications("m") , Deep.NoSePuedeLiberarLaCapsula );
    }

    @Test
    public void test18DescenderyAvanzar() {
        Nemo nemo = new Nemo();
        nemo.indications( "df" );
        compareDepths(nemo, 1);
        //compareCapacityOfLaunch(nemo, true);  para mi no hace falta
        compareCoords(nemo, 1, 0);
    }

    @Test
    public void test19DescenderGirarYAvanzar(){
        Nemo nemo = new Nemo();
        nemo.indications( "drf" );
        compareDepths(nemo, 1);
        compareCapacityOfLaunch(nemo, true);
        compareCoords(nemo, 0, 1);
        compareDirections(nemo, 0, 1);
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

    private Nemo createSubmarineWithCommand(String command){ ///// CHECK!!!!!
        Nemo nemo = new Nemo();
        nemo.indications(command);
        return nemo;
    }

}
