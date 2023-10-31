package linea;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LineaTest {

    @Test public void testTableroEmpiezaVacio(){
        Linea game = new Linea( 4, 4,'C' );
        assertTrue(game.show().equals("----\n----\n----\n----\n"));

    }

    @Test public void testNoSePuedeHacer3x3(){
        assertThrows(RuntimeException.class, () -> new Linea( 3, 3,'C' ));
    }
    @Test public void testEmpiezanLasRojas(){
        Linea game = new Linea( 4, 4,'C' );
        assertTrue(game.turnoRojas());
    }

    @Test public void testJueganLasAzules(){
        Linea game = new Linea( 4, 4,'C' );
        game.playRedkAt( 1 );
        assertTrue(game.turnoAzules());
        assertFalse(game.turnoRojas());

    }

    @Test public void testJueganLasRojas(){
        Linea game = new Linea( 4, 4,'C' );
        game.playRedkAt( 1 );
        game.playBlueAt( 1 );
        assertTrue(game.show().equals("----\n----\n----\n----\n"));

    }
}
