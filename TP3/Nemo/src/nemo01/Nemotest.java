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
        compareState( createSubmarineWithCommand(""), 0,true,0, 0, 1, 0);
    }

    @Test
    public void test03Descender() {
        Nemo nemo = createSubmarineWithCommand("d");
        compareDepths(nemo, 1);
        compareCapacityOfLaunch(nemo, true);
    }

    @Test
    public void test04AscenderDesdeSurface() {
        Nemo nemo = createSubmarineWithCommand("u");
        compareDepths(nemo, 0);
        compareCapacityOfLaunch(nemo, true);
    }

    @Test
    public void test05MultiplesAscensosDesdeSurface() {
        Nemo nemo = createSubmarineWithCommand("uuuuu");
        compareDepths(nemo, 0);
        compareCapacityOfLaunch(nemo, true);
    }
    @Test
    public void test06MutiplesCambiosDeNivel() {
        Nemo nemo = createSubmarineWithCommand("dddddduuuu");
        compareDepths(nemo, 2);
        compareCapacityOfLaunch(nemo, false); // pensar si sacarlo o no
    }

    @Test
    public void test07RotarDerecha() {
        compareDirections(createSubmarineWithCommand("r"), 0, 1);
    }

    @Test
    public void test08RotarIzquierda() {
        compareDirections(createSubmarineWithCommand("l"), 0, -1);
    }

    @Test
    public void test09Girar90grados(){
        compareDirections(createSubmarineWithCommand("ll"), -1, 0);
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
        Nemo nemo = createSubmarineWithCommand("f");
        compareCoords(nemo, 1, 0);
        compareDirections(nemo, 1, 0);
    }

    @Test
    public void test12AvanzarWest() {
        Nemo nemo = createSubmarineWithCommand("rf");
        compareCoords(nemo, 0, 1);
        compareDirections(nemo, 0,1);
    }

    @Test
    public void test13AvanzarEast() {
        Nemo nemo = createSubmarineWithCommand( "rrf" );
        compareState( nemo, 0,true, -1, 0,-1, 0);
    }

    @Test
    public void test14AvanzarSouth() {
        Nemo nemo = createSubmarineWithCommand("lf");
        compareState( nemo, 0,true, 0, -1,0, -1);
    }

    @Test
    public void test15TirarCapsulaEnSuperficie() {
        Nemo nemo = createSubmarineWithCommand("m");
        compareDepths(nemo, 0);
        compareCapacityOfLaunch(nemo, true);
    }

    @Test
    public void test16TirarCapsulaEnBelowSurface() {
        Nemo nemo = createSubmarineWithCommand("d m");
        compareDepths(nemo, 1);
        compareCapacityOfLaunch(nemo, true);
    }

    @Test
    public void test17TirarCapsulaEnDeep() {
        Nemo nemo = createSubmarineWithCommand("d d");
        compareDepths(nemo, 2);
        compareCapacityOfLaunch(nemo, false);
        assertThrowsLike ( ()->nemo.indications("m") , Deep.NoSePuedeLiberarLaCapsula );
    }

    @Test
    public void test18DescenderyAvanzar() {
        Nemo nemo = createSubmarineWithCommand("df");
        compareDepths(nemo, 1);
        //compareCapacityOfLaunch(nemo, true);  para mi no hace falta
        compareCoords(nemo, 1, 0);
    }

    @Test
    public void test19DescenderGirarYAvanzar(){
        Nemo nemo = createSubmarineWithCommand("drf");
        compareDepths(nemo, 1);
        compareCapacityOfLaunch(nemo, true);
        compareCoords(nemo, 0, 1);
        compareDirections(nemo, 0, 1);
    }

    private static void compareState( Nemo nemo,  int depth, boolean canLaunch,int xcoord, int ycoord, int xdire, int ydire) {
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

    private Nemo createSubmarineWithCommand(String command){
        Nemo nemo = new Nemo();
        nemo.indications(command);
        return nemo;
    }

}
