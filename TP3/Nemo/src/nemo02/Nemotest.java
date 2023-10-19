//package nemo02;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.function.Executable;
//
//import static org.junit.jupiter.api.Assertions.*;
//
////    public char decender = 'd';
////    public char ascender = 'u';
////    public char rotarIzquierda = 'l';
////    public char rotarDerecha = 'r';
////    public char avanzar = 'f';
////    public char liberarCapsula = 'm';
//
//public class Nemotest {
//
//    @Test
//    public void test01() {
//        compareState( new Nemo(), 0, true, 0, 0, 1, 0);
//    }
//
//    @Test
//    public void test02comandovacio() {
//        Nemo nemo = new Nemo();
//        nemo.indications ("");
//        compareState( nemo, 0,true,0, 0, 1, 0);
//    }
//
//    @Test
//    public void test03descender() {
//        Nemo nemo = new Nemo();
//        nemo.indications ( "d" );
//        compareState( nemo,1, true,0, 0, 1, 0);
//    }
//
//    @Test
//    public void test04ascender() {
//        Nemo nemo = new Nemo();
//        nemo.indications ("u" );
//        compareState( nemo, 0,true,0, 0, 1, 0);
//    }
//
//    @Test
//    public void test05ascensoSinLimitacion() {
//        Nemo nemo = new Nemo();
//        nemo.indications ( "uuuuu" );
//        compareState( nemo, 1,true, 0, 0,1, 0);
//    }
//    @Test
//    public void test06mutiplescambiodenivel() {
//        Nemo nemo = new Nemo();
//        nemo.indications ( "dddddd" );
//        nemo.indications ( "uuuuu" );
//        compareState( nemo, 1,true, 0, 0,1, 0);
//    }
//
//    @Test
//    public void test07rotarDerecha() {
//        Nemo nemo = new Nemo();
//        nemo.indications ( "r" );
//        compareState( nemo, 0,true,0, 0, 0, 1);
//    }
//
//    @Test
//    public void test08rotarIzquierda() {
//        Nemo nemo = new Nemo();
//        nemo.indications ( "l" );
//        compareState( nemo, 0,true,0, 0, 0, -1);
//    }
//
//    @Test
//    public void test09girar2veces(){
//        Nemo nemo = new Nemo();
//        nemo.indications("ll");
//        compareState( nemo, 0,true, 0, 0,-1, 0);
//    }
//
//    @Test
//    public void test10girarYVolver() {
//        Nemo nemo = new Nemo();
//        nemo.indications("rrrr");
//        compareState( nemo, 0,true, 0, 0,1, 0);
//    }
//
//    @Test
//    public void test11avanzarnorth() {
//        Nemo nemo = new Nemo();
//        nemo.indications ( "f" );
//        compareState( nemo, 0,true, 1, 0,1, 0);
//    }
//
//    @Test
//    public void test12avanzarwest() {
//        Nemo nemo = new Nemo();
//        nemo.indications ( "rf" );
//        compareState( nemo, 0,true, 1, 0,0, 1);
//    }
//
//    @Test
//    public void test13avanzareast() {
//        Nemo nemo = new Nemo();
//        nemo.indications ( "rrf" );
//        compareState( nemo, 0,true, 1, 0,-1, 0);
//    }
//
//    @Test
//    public void test14avanzarsouth() {
//        Nemo nemo = new Nemo();
//        nemo.indications ( "lf" );
//        compareState( nemo, 0,true, 1, 0,0, 1);
//    }
//
//    @Test
//    public void test15FallaTirarCapsula() {
//        Nemo nemo = new Nemo();
//        nemo.indications( "m" );
//        compareState( nemo, 0,true, 0, 0,1, 0);
//    }
//
//    @Test
//    public void test16FallaTirarCapsula() {
//        Nemo nemo = new Nemo();
//        nemo.indications( "d m" );
//        compareState( nemo, 1,true, 0, 0,1, 0);
//    }
//
//    @Test
//    public void test17FallaTirarCapsula() {
//        Nemo nemo = new Nemo();
//        nemo.indications( "d d" );
//        compareState( nemo, 2,false, 0, 0,1, 0);
//        assertThrowsLike ( ()->nemo.indications("m") , "No se puede liberar la capsula" );
//    }
//
//    private static void compareState( Nemo nemo, int depth, boolean issurface,int xcoord, int ycoord, int xdire, int ydire) {
//        assertEquals (depth, nemo.getDepth() );
//        assertEquals (issurface, nemo.InSurface() );
//        assertEquals (xcoord, nemo.getLocation().getX() );
//        assertEquals (ycoord, nemo.getLocation().getY() );
//        assertEquals (xdire, nemo.getDirection().getX() );
//        assertEquals (ydire, nemo.getDirection().getY() );
//    }
//    private void assertThrowsLike(Executable executable, String message) {
//        assertEquals ( message , assertThrows ( Exception.class , executable ) .getMessage() );
//    }
//}