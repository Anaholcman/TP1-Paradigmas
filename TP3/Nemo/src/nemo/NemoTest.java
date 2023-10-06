package nemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NemoTest {
    @Test public void test00nemostartcondition() {
        Nemo nemo = new Nemo();
        assertArrayEquals( new int[]{0,0}, nemo.getLocation() );
        assertTrue( nemo.InSurface() );
        assertEquals( nemo.north , nemo.getDirection() );
    }

    @Test public void test01nohacenada() {
        Nemo nemo = new Nemo();
        nemo.indications("");
        assertArrayEquals( new int[]{0,0}, nemo.getLocation() );
        assertTrue( nemo.InSurface() );
        assertEquals( nemo.north , nemo.getDirection() );
    }

    @Test public void test02descender() {
        Nemo nemo = new Nemo();
        nemo.indications("d");
        assertArrayEquals( new int[]{0,0}, nemo.getLocation() );
        assertFalse( nemo.InSurface() );
        assertEquals( nemo.north , nemo.getDirection() );
        assertEquals ( 1 , nemo.getDepth() );
    }
}

