package nemo01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.*;

public class Nemotest {

    @Test
    public void test00() {
        Nemo nemo = new Nemo();
        Direccion north = new North();
        Coords coords = new Coords();
        assertEquals ( 0 , nemo.getDepth() );
        assertTrue ( nemo.InSurface() );
        assertEquals ( nemo.getLocation() , coords );
        assertEquals ( north , nemo.getDirection() );
    }
    @Test
    public void test01() {
        Nemo nemo = new Nemo();
        Direccion north = new North();
        Coords coords = new Coords();
        nemo.indications ("" );
        assertEquals ( nemo.getLocation() , coords );
        assertEquals ( nemo.getDepth() , 0 );
        assertEquals ( north , nemo.getDirection() );
    }

    @Test
    public void test02descender() {
        Nemo nemo = new Nemo();
        Direccion north = new North();
        Coords coords = new Coords();
        nemo.indications ( "d" );
        assertEquals ( nemo.getLocation() , coords );
        assertFalse ( nemo.InSurface() );
        assertEquals ( north , nemo.getDirection() );
        assertEquals ( 1 , nemo.getDepth() );
    }

    @Test
    public void test03ascender() {
        Nemo nemo = new Nemo();
        Coords coords = new Coords();
        nemo.indications ("u" );
        assertEquals ( nemo.getLocation() , coords );
        assertTrue ( nemo.InSurface() );
    }

    @Test
    public void test04rotarDerecha() {
        Nemo nemo = new Nemo();
        Direccion east = new East() ;
        nemo.indications ( "l" );
        assertEquals ( nemo.getDirection() , east );
    }

    @Test
    public void test05rotarIzquierda() {
        Nemo nemo = new Nemo();
        Direccion west = new West() ;
        nemo.indications ( "r" );
        assertEquals ( nemo.getDirection() , west );
    }

    @Test
    public void test06avanzar() {
        Nemo nemo = new Nemo();
        Direccion north = new North();
        Coords coords = new Coords();
        coords.sum( north );
        nemo.indications ( "f" );
        assertEquals ( nemo.getLocation() , coords );
        assertEquals ( north , nemo.getDirection() );
    }

    @Test
    public void test07avanzar2() {
        Nemo nemo = new Nemo();
        Direccion north = new North();
        Coords coords = new Coords();
        coords.sum( north );
        coords.sum( north );
        nemo.indications ( "ff" );
        assertEquals ( nemo.getLocation() , coords );
        assertEquals ( north, nemo.getDirection() );

    }
    @Test
    public void test08FallaTirarCapsula() {
        Nemo nemo = new Nemo();
        nemo.indications( "d d" );
        assertThrowsLike ( ()->nemo.indications("m") , "No se puede liberar la capsula" );
    }

    @Test
    public void test09girar2veces(){
        Nemo nemo = new Nemo();
        Direccion south = new South();
        nemo.indications("ll");
        assertEquals ( south , nemo.getDirection() );
    }
    @Test
    public void test09girarYVolver() {
        Nemo nemo = new Nemo();
        Direccion north = new North();
        nemo.indications("lr");
        assertEquals(north, nemo.getDirection());
    }


    @Test
    public void test10ascensoSinLimitacion() {
        Nemo nemo = new Nemo();
        nemo.indications ( "dddddd" );
        // Verificar que se pueda ascender múltiples unidades sin problemas.
        // queda en 0
        nemo.indications ( "uuuuuu" );
        assertEquals ( 0 , nemo.getDepth() );
    }

    private void assertThrowsLike(Executable executable, String message) {
        assertEquals ( message , assertThrows ( Exception.class , executable ) .getMessage() );
    }
}