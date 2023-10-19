package nemo02;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

//    public char decender = 'd';
//    public char ascender = 'u';
//    public char rotarIzquierda = 'l';
//    public char rotarDerecha = 'r';
//    public char avanzar = 'f';
//    public char liberarCapsula = 'm';

public class Nemotest {

    @Test
    public void test00() {
        compareState( new Nemo(), 0, true, 0, 0, 1, 0);
    }

    @Test
    public void test01() {
        Nemo nemo = new Nemo();
        nemo.indications ("" );
        compareState( nemo, 0,true,0, 0, 1, 0);
    }

    @Test
    public void test02descender() {
        Nemo nemo = new Nemo();
        nemo.indications ( "d" );
        compareState( nemo,1, true,0, 0, 1, 0);
    }

    @Test
    public void test03ascender() {
        Nemo nemo = new Nemo();
        nemo.indications ("u" );
        compareState( nemo, 0,true,0, 0, 1, 0);
    }

    @Test
    public void test04rotarDerecha() {
        Nemo nemo = new Nemo();
        nemo.indications ( "r" );
        compareState( nemo, 0,true,0, 0, 0, 1);
    }

    @Test
    public void test05rotarIzquierda() {
        Nemo nemo = new Nemo();
        nemo.indications ( "l" );
        compareState( nemo, 0,true,0, 0, 0, -1);
    }

    @Test
    public void test06avanzar() {
        Nemo nemo = new Nemo();
        nemo.indications ( "f" );
        compareState( nemo, 0,true, 1, 0,1, 0);
    }

    @Test
    public void test07avanzar2() {
        Nemo nemo = new Nemo();
        nemo.indications ( "ff" );
        compareState( nemo, 0,true, 2, 0,1, 0);
    }
    @Test
    public void test08FallaTirarCapsula() {
        Nemo nemo = new Nemo();
        nemo.indications( "d d" );
        compareState( nemo, 2,false, 0, 0,1, 0);
        assertThrowsLike ( ()->nemo.indications("m") , "No se puede liberar la capsula" );
    }

    @Test
    public void test09girar2veces(){
        Nemo nemo = new Nemo();
        nemo.indications("ll");
        compareState( nemo, 0,true, 0, 0,-1, 0);
    }
    @Test
    public void test09girarYVolver() {
        Nemo nemo = new Nemo();
        nemo.indications("lr");
        compareState( nemo, 0,true, 0, 0,1, 0);
    }


    @Test
    public void test10ascensoSinLimitacion() {
        Nemo nemo = new Nemo();
        nemo.indications ( "dddddd" );
        nemo.indications ( "uuuuuu" );
        compareState( nemo, 0,true, 0, 0,1, 0);
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