package nemo01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.*;

public class Nemotest {

    @Test
    public void test01() {
        compareState( new Nemo(), 0, true, 0, 0, 1, 0);
    }

    @Test
    public void test02comandovacio() {
        Nemo nemo = new Nemo();
        nemo.indications ("");
        compareState( nemo, 0,true,0, 0, 1, 0);
    }

    @Test
    public void test03descender() {
        Nemo nemo = new Nemo();
        nemo.indications ( "d" );
        compareState( nemo,1, true,0, 0, 1, 0);
    }

    @Test
    public void test04ascender() {
        Nemo nemo = new Nemo();
        nemo.indications ("u" );
        compareState( nemo, 0,true,0, 0, 1, 0);
    }

    @Test
    public void test05ascensoSinLimitacion() {
        Nemo nemo = new Nemo();
        nemo.indications ( "uuuuu" );
        compareState( nemo, 0,true, 0, 0,1, 0);
    }
    @Test
    public void test06mutiplescambiodenivel() {
        Nemo nemo = new Nemo();
        nemo.indications ( "dddddd" );
        nemo.indications ( "uuuuu" );
        compareState( nemo, 1,true, 0, 0,1, 0);
    }

    @Test
    public void test07rotarDerecha() {
        Nemo nemo = new Nemo();
        nemo.indications ( "r" );
        compareState( nemo, 0,true,0, 0, 0, 1);
    }

    @Test
    public void test08rotarIzquierda() {
        Nemo nemo = new Nemo();
        nemo.indications ( "l" );
        compareState( nemo, 0,true,0, 0, 0, -1);
    }

    @Test
    public void test09girar2veces(){
        Nemo nemo = new Nemo();
        nemo.indications("ll");
        compareState( nemo, 0,true, 0, 0,-1, 0);
    }

    @Test
    public void test10girarYVolver() {
        Nemo nemo = new Nemo();
        nemo.indications("rrrr");
        compareState( nemo, 0,true, 0, 0,1, 0);
    }

    @Test
    public void test11avanzarnorth() {
        Nemo nemo = new Nemo();
        nemo.indications ( "f" );
        compareState( nemo, 0,true, 1, 0,1, 0);
    }

    @Test
    public void test12avanzarwest() {
        Nemo nemo = new Nemo();
        nemo.indications ( "rf" );
        compareState( nemo, 0,true, 0, 1,0, 1);
    }

    @Test
    public void test13avanzareast() {
        Nemo nemo = new Nemo();
        nemo.indications ( "rrf" );
        compareState( nemo, 0,true, -1, 0,-1, 0);
    }

    @Test
    public void test14avanzarsouth() {
        Nemo nemo = new Nemo();
        nemo.indications ( "lf" );
        compareState( nemo, 0,true, 0, -1,0, -1);
    }

    @Test
    public void test15FallaTirarCapsula() {
        Nemo nemo = new Nemo();
        nemo.indications( "m" );
        compareState( nemo, 0,true, 0, 0,1, 0);
    }

    @Test
    public void test16FallaTirarCapsula() {
        Nemo nemo = new Nemo();
        nemo.indications( "d m" );
        compareState( nemo, 1,true, 0, 0,1, 0);
    }

    @Test
    public void test17FallaTirarCapsula() {
        Nemo nemo = new Nemo();
        nemo.indications( "d d" );
        compareState( nemo, 2,false, 0, 0,1, 0);
        assertThrowsLike ( ()->nemo.indications("m") , "No se puede liberar la capsula" );
    }

    private static void compareState( Nemo nemo, int depth, boolean issurface,int xcoord, int ycoord, int xdire, int ydire) {
        assertEquals (depth, nemo.getDepth() );
        assertEquals (issurface, nemo.InSurface() );
        assertEquals (xcoord, nemo.getLocation().getX() );
        assertEquals (ycoord, nemo.getLocation().getY() );
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