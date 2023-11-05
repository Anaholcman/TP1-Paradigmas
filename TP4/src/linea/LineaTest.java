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

    @Test public void testTurnoLasAzules(){
        Linea game = new Linea( 4, 4,'C' );
        game.playRedkAt( 1 );
        assertTrue(game.turnoAzules());
        assertFalse(game.turnoRojas());
    }

    @Test public void testJueganLasRojas(){ //mal
        Linea game = new Linea( 4, 4,'C' );
        game.playRedkAt( 1 );
        assertTrue(game.show().equals("----\n----\n----\nR---\n"));
    }
    @Test public void testJueganLasAzules(){
        Linea game = new Linea( 4, 4,'C' );
        game.playRedkAt( 1 );
        game.playBlueAt( 1 );
        assertTrue(game.show().equals("----\n----\nA---\nR---\n"));
    }

    @Test public void testQuierejugarAzulEnTurnoDeRojo() {
        Linea game = new Linea( 4, 4,'C' );
        game.setTurno('R');
        assertTrue(game.turnoRojas());
        assertFalse(game.turnoAzules());
        assertThrows(RuntimeException.class, () -> game.playBlueAt( 1 ));
    }

    @Test public void testQuierejugarRojoEnTurnoDeAzul() {
        Linea game = new Linea( 4, 4,'C' );
        game.setTurno('R');
        game.playRedkAt(1);
        assertTrue(game.turnoAzules());
        assertFalse(game.turnoRojas());
        assertThrows(RuntimeException.class, () -> game.playRedkAt( 1 ));
    }

    @Test public void testQuiereJugarRojoEnColumnaOutOfBounds(){
        Linea game = new Linea( 4, 4,'C' );
        assertThrows(RuntimeException.class, () -> game.playRedkAt( 5 ));
        assertTrue(game.show().equals("----\n----\n----\n----\n"));
    }

    @Test public void testQuiereJugarAzulEnColumnaOutOfBounds(){ // podria borrarse
        Linea game = new Linea( 4, 4,'C' );
        game.playRedkAt(1);
        assertThrows(RuntimeException.class, () -> game.playBlueAt(5));
    }

    @Test public void testQuiereJugarRojoEnColumnaLlena(){
        Linea game = new Linea( 4, 4,'C' );
        game.playRedkAt(1);
        game.playBlueAt(1);
        game.playRedkAt(1);
        game.playBlueAt(1);
        assertThrows(RuntimeException.class, () -> game.playRedkAt(1));
    }
    @Test public void testQuiereJugarAzulEnColumnaLlena(){
        Linea game = new Linea( 4, 4,'C' );
        game.playRedkAt(1);
        game.playBlueAt(1);
        game.playRedkAt(1);
        game.playBlueAt(1);
        assertThrows(RuntimeException.class, () -> game.playBlueAt(1));
    }
    @Test public void testJuegoNoTerminado(){
        Linea game = new Linea( 4, 4,'C' );
        game.playRedkAt(1);
        game.playBlueAt(1);
        assertFalse(game.finished());
    }
    @Test public void testGanatipoA(){
        Linea game = new Linea( 4, 4,'A' );
        game.playRedkAt(1);
        game.playBlueAt(1);
        game.playRedkAt(2);
        game.playBlueAt(2);
        game.playRedkAt(3);
        game.playBlueAt(3);
        game.playRedkAt(4);
        assertTrue(game.finished());
    }
    @Test public void testGanatipoB(){
        Linea game = new Linea( 4, 4,'B' );
        game.playRedkAt(1);
        game.playBlueAt(2);
        game.playRedkAt(3);
        game.playBlueAt(4);
        game.playRedkAt(2);
        game.playBlueAt(3);
        game.playRedkAt(3);
        game.playBlueAt(4);
        game.playRedkAt(4);
        game.playBlueAt(2);
        game.playRedkAt(4);
        assertTrue(game.finished());
    }
    @Test public void testGanatipoC(){
        Linea game = new Linea( 4, 4,'C' );
        game.playRedkAt(1);
        game.playBlueAt(2);
        game.playRedkAt(3);
        game.playBlueAt(4);
        game.playRedkAt(2);
        game.playBlueAt(3);
        game.playRedkAt(3);
        game.playBlueAt(4);
        game.playRedkAt(4);
        game.playBlueAt(2);
        game.playRedkAt(4);
        assertTrue(game.finished());
    }



}
