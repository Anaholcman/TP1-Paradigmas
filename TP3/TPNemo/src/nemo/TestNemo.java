package nemo;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class TestNemo {

    @Test
    public void test00CreaNemo() {
        Nemo nemo = new Nemo();
        Direccion north = new North();
        Coords coords = new Coords();
        assertEquals(0, nemo.getDepth());
        assertTrue(nemo.InSurface());
        assertTrue(nemo.getLocation().equals(coords));
        assertTrue(nemo.getDirection().equals(north));
    }

    @Test
    public void test01NolePasoNada() {
        Nemo nemo = new Nemo();
        Direccion north = new North();
        Coords coords = new Coords();
        nemo.indications("");
        assertTrue(nemo.getLocation().equals(coords));
        assertEquals(nemo.getDepth(), 0);
        assertTrue(nemo.getDirection().equals(north));
    }

    @Test
    public void test02descender() {
        Nemo nemo = new Nemo();
        Direccion north = new North();
        Coords coords = new Coords();
        nemo.indications("d");
        assertTrue(nemo.getLocation().equals(coords));
        assertEquals(1, nemo.getDepth());
        assertFalse(nemo.InSurface());
        assertTrue(nemo.getDirection().equals(north));
    }

    @Test
    public void test03ascender() {
        Nemo nemo = new Nemo();
        Coords coords = new Coords();
        nemo.indications("u");
        assertTrue(nemo.getLocation().equals(coords));
        assertTrue(nemo.InSurface());
    }

    @Test
    public void test04rotarDerecha() {
        Nemo nemo = new Nemo();
        Direccion east = new East();
        nemo.indications("r");
        assertTrue(nemo.getDirection().equals(east));
    }

    @Test
    public void test05rotarIzquierda() {
        Nemo nemo = new Nemo();
        Direccion west = new West();
        nemo.indications("l");
        assertTrue(nemo.getDirection().equals(west));
    }

    @Test
    public void test06avanzar() {
        Nemo nemo = new Nemo();
        Direccion north = new North();
        Coords coords = new Coords();
        coords.add(north);
        nemo.indications("f");
        assertTrue(nemo.getLocation().equals(coords));
        assertTrue(nemo.getDirection().equals(north));
    }

    @Test
    public void test07avanzar2() {
        Nemo nemo = new Nemo();
        Direccion north = new North();
        Coords coords = new Coords();
        coords.add(north);
        coords.add(north);
        nemo.indications("ff");
        assertTrue(nemo.getLocation().equals(coords));
        assertTrue(nemo.getDirection().equals(north));
    }

    @Test
    public void test08FallaTirarCapsula() {
        Nemo nemo = new Nemo();
        nemo.indications("d d");
        assertThrowsLike(() -> nemo.indications("m"), "No se puede liberar la capsula");
    }

    @Test
    public void test09girar2veces() {
        Nemo nemo = new Nemo();
        Direccion south = new South();
        nemo.indications("ll");
        assertTrue(nemo.getDirection().equals(south));
    }

    @Test
    public void test09girarYVolver() {
        Nemo nemo = new Nemo();
        Direccion north = new North();
        nemo.indications("lr");
        assertTrue(nemo.getDirection().equals(north));
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
