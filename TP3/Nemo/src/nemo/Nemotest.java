package nemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Nemotest {
    @Test
    public void test01InitialSetUp() {
        compareState ( new Nemo(), 0,true,0, 0, 1, 0 );
    }

    @Test
    public void test02ComandoVacio() {
        compareState ( createSubmarineWithCommand(" "), 0,true,0, 0, 1, 0 );
    }

    @Test
    public void test03Descender() {
        compareState ( createSubmarineWithCommand("d"), 1,true,0, 0, 1, 0 );
    }

    @Test
    public void test04DescenderDeep() {
        compareDepthsState( createSubmarineWithCommand("dd"), 2, false );
    }

    @Test
    public void test05AscenderDesdeSurface() {
        compareState ( createSubmarineWithCommand("u"), 0,true,0, 0, 1, 0 );
    }

    @Test
    public void test06MultiplesAscensosDesdeSurface() {
        compareDepthsState( createSubmarineWithCommand("uuuuu"), 0, true );
    }

    @Test
    public void test07MutiplesCambiosDeNivel() {
        compareDepthsState( createSubmarineWithCommand("dddddd uuuuu"), 1, true );
    }

    @Test
    public void test08RotarDerecha() {
        compareState ( createSubmarineWithCommand("r"), 0,true, 0, 0,0, 1 );
    }

    @Test
    public void test09RotarIzquierda() {
        compareState ( createSubmarineWithCommand("l"), 0,true, 0, 0,0, -1 );
    }

    @Test
    public void test10Girar180grados(){
        compareDirections ( createSubmarineWithCommand("ll"), -1, 0 );
    }

    @Test
    public void test11Girar360grados() {
        compareDirections ( createSubmarineWithCommand("rrrr"), 1, 0);
    }

    @Test
    public void test12AvanzarNorth() {
        compareState ( createSubmarineWithCommand("f"), 0, true, 1, 0, 1, 0);
    }

    @Test
    public void test13AvanzarWest() {
        compareState ( createSubmarineWithCommand("rf"), 0, true, 0, 1, 0, 1);
    }

    @Test
    public void test14AvanzarEast() {
        compareState ( createSubmarineWithCommand( "rrf" ), 0,true, -1, 0,-1, 0);
    }

    @Test
    public void test15AvanzarSouth() {
        compareState ( createSubmarineWithCommand("lf"), 0,true, 0, -1,0, -1);
    }

    @Test
    public void test16TirarCapsulaEnSuperficie() {
        compareState ( createSubmarineWithCommand("m"), 0,true, 0, 0,1, 0);
    }

    @Test
    public void test17TirarCapsulaEnBelowSurface() {
        compareDepthsState( createSubmarineWithCommand("d m"), 1, true);
    }

    @Test
    public void test18TirarCapsulaEnDeep() {
        assertEquals ( Deep.NoSePuedeLiberarLaCapsula , assertThrows ( Exception.class , ()-> createSubmarineWithCommand("d d m") ) .getMessage() );
    }

    @Test
    public void test19DescenderyAvanzar() {
        compareState ( createSubmarineWithCommand("df"), 1,true, 1, 0,1, 0);
    }

    @Test
    public void test20DescenderGirarYAvanzar(){
        compareState ( createSubmarineWithCommand("ddrf"), 2,false, 0, 1, 0,1);
    }

    private static void compareState( Nemo nemo,  int depth, boolean canLaunch,int xcoord, int ycoord, int xdire, int ydire) {
        compareDepthsState(nemo, depth, canLaunch);
        compareCoords(nemo, xcoord, ycoord);
        compareDirections(nemo, xdire, ydire);
    }
    private static void compareDepthsState(Nemo nemo, int depth, boolean canLaunch) {
        assertEquals (depth, nemo.getDepth() );
        assertEquals (canLaunch, nemo.isCapsuleLaunchable() );
    }

    private static void compareCoords( Nemo nemo, int xcoord, int ycoord) {
        assertEquals ( xcoord, nemo.getLocation().getX() );
        assertEquals ( ycoord, nemo.getLocation().getY() );
    }
    private static void compareDirections( Nemo nemo, int xdire, int ydire) {
        assertEquals ( xdire, nemo.getDirection().getX() );
        assertEquals ( ydire, nemo.getDirection().getY() );
    }

    private Nemo createSubmarineWithCommand(String command){
        Nemo nemo = new Nemo();
        nemo.indications(command);
        return nemo;
    }

}
