package nemo;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class TestNemo {

    @Test
    public void test00() {
        Nemo nemo = new Nemo();
        assertTrue(nemo.depth == 0);
        assertTrue(nemo.InSurface());
        assertArrayEquals(nemo.getLocation(), new int[]{0, 0});
        assertEquals(nemo.north, nemo.getDirection());

    }

    @Test
    public void test01() {
        Nemo nemo = new Nemo();
        nemo.indications("");
        assertArrayEquals(nemo.getLocation(), new int[]{0, 0});
        assertEquals(nemo.getDepth(), 0);
        assertEquals(nemo.north, nemo.getDirection());
    }

    @Test
    public void test02descender() {
        Nemo nemo = new Nemo();
        nemo.indications("d");
        assertArrayEquals(new int[]{0, 0}, nemo.getLocation());
        assertFalse(nemo.InSurface());
        assertEquals(nemo.north, nemo.getDirection());
        assertEquals(1, nemo.getDepth());
    }

    @Test
    public void test03ascender() {
        Nemo nemo = new Nemo();
        nemo.indications("u");
        assertArrayEquals(new int[]{0, 0}, nemo.getLocation());
        assertTrue(nemo.InSurface());

    }

    @Test
    public void test04rotarDerecha() {
        Nemo nemo = new Nemo();
        nemo.indications("l");
        assertEquals(nemo.getDirection(), nemo.east);
    }

    @Test
    public void test05rotarIzquierda() {
        Nemo nemo = new Nemo();
        nemo.indications("r");
        assertEquals(nemo.getDirection(), nemo.west);
    }

    @Test
    public void test06avanzar() {
        Nemo nemo = new Nemo();
        nemo.indications("f");
        assertArrayEquals(new int[]{0, 1}, nemo.getLocation());
        assertEquals(nemo.north, nemo.getDirection());
    }

    @Test
    public void test07avanzar2() {
        Nemo nemo = new Nemo();
        nemo.indications("ff");
        assertArrayEquals(new int[]{0, 2}, nemo.getLocation());
        assertEquals(nemo.north, nemo.getDirection());

    }
    @Test
    public void test08FallaTirarCapsula() {
        Nemo nemo = new Nemo();
        assertThrowsLike(()->nemo.indications("m"), "No se puede liberar la capsula");
    }


    @Test
    public void test09girar2veces(){
        Nemo nemo = new Nemo();
        nemo.indications("ll");
        assertEquals(nemo.south, nemo.getDirection());
    }
    @Test
    public void test09girarYVolver() {
        Nemo nemo = new Nemo();
        nemo.indications("lr");
        assertEquals(nemo.north, nemo.getDirection());
    }


    @Test
    public void test10ascensoSinLimitacion() {
        Nemo nemo = new Nemo();
        nemo.indications("dddddd");
        // Verificar que se pueda ascender múltiples unidades sin problemas.
        // queda en 0
        nemo.indications("uuuuuu");
        assertEquals(0, nemo.getDepth());
    }

    private void assertThrowsLike(Executable executable, String message) {
        assertEquals(message, assertThrows(Exception.class, executable).getMessage());
    }
}
