package linea;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LineaTest {

    @Test public void test01TableroEmpiezaVacio(){
        assertEquals("||   |   |   |   ||\n" +
                        "||---|---|---|---||\n" +
                        "||   |   |   |   ||\n" +
                        "||---|---|---|---||\n" +
                        "||   |   |   |   ||\n" +
                        "||---|---|---|---||\n" +
                        "||   |   |   |   ||\n" +
                        "===1===2===3===4===\n",
                new Linea( 4, 4,'C' ).show());
    }

    @Test public void test02EmpiezanLasRojas(){
        assertTrue( new Linea( 4, 4,'C' ).turnoRojas() );
    }

    @Test public void test03TurnoLasAzules(){
        Linea game = new Linea( 4, 4,'C' );
        game.playRedAt( 1 );
        assertEquals("||   |   |   |   ||\n" +
                "||---|---|---|---||\n" +
                "||   |   |   |   ||\n" +
                "||---|---|---|---||\n" +
                "||   |   |   |   ||\n" +
                "||---|---|---|---||\n" +
                "|| R |   |   |   ||\n" +
                "===1===2===3===4===\n", game.show());
        assertTrue( game.turnoAzules() );
        assertFalse( game.turnoRojas() );
    }

    @Test public void test04QuierejugarAzulEnTurnoDeRojo() {
        Linea game = new Linea( 4, 4,'C' );
        assertTrue( game.turnoRojas() );
        assertFalse( game.turnoAzules() );
        assertThrows( RuntimeException.class, () -> game.playBlueAt( 1 ) );
    }

    @Test public void test05QuierejugarRojoEnTurnoDeAzul() {
        Linea game = new Linea( 4, 4,'C' );
        game.playRedAt(1);
        assertTrue( game.turnoAzules() );
        assertFalse( game.turnoRojas() );
        assertThrows( RuntimeException.class, () -> game.playRedAt( 1 ));
    }

    @Test public void test06QuiereJugarRojoEnColumnaOutOfBounds(){
        Linea game = new Linea( 4, 4,'C' );
        assertThrows(RuntimeException.class, () -> game.playRedAt( 5 ));
        assertEquals("||   |   |   |   ||\n" +
                "||---|---|---|---||\n" +
                "||   |   |   |   ||\n" +
                "||---|---|---|---||\n" +
                "||   |   |   |   ||\n" +
                "||---|---|---|---||\n" +
                "||   |   |   |   ||\n" +
                "===1===2===3===4===\n", game.show());
    }

    @Test public void test07QuiereJugarRojoEnColumnaLlena(){
        Linea game = getGame(4,4,'C', Arrays.asList(1,1,1,1));
        assertThrows( RuntimeException.class, () -> game.playRedAt(1));
        assertEquals("|| A |   |   |   ||\n" +
                "||---|---|---|---||\n" +
                "|| R |   |   |   ||\n" +
                "||---|---|---|---||\n" +
                "|| A |   |   |   ||\n" +
                "||---|---|---|---||\n" +
                "|| R |   |   |   ||\n" +
                "===1===2===3===4===\n", game.show());
    }

    @Test public void test08JuegoNoTerminado(){
        assertFalse( getGame(4,4,'C', Arrays.asList(1,1))
                .finished());
    }

    @Test public void test09GanatipoA(){
        assertTrue( getGame(4,4,'A', Arrays.asList(1,1,2,2,3,3,4))
                .finished());
    }

    @Test public void test10GanatipoB(){
        assertTrue( getGame(4,4,'C', Arrays.asList(1,2,3,4,2,3,3,4,4,2,4))
                .finished());
    }

    @Test public void test11GanatipoCconLinea(){
        assertTrue( getGame(4,4,'C', Arrays.asList(1,1,2,2,3,3,4))
                .finished());
    }

    @Test public void test12GanatipoCconDiagonal(){
        assertTrue( getGame(4,4,'C', Arrays.asList(1,2,3,4,2,3,3,4,4,2,4))
                .finished());
    }

    @Test public void test13TerminaElJuegoEnEmpate(){
        assertTrue( getGame(4,4,'A', Arrays.asList(1,2,3,4,4,3,2,1,4,3,2,1,1,2,3,4))
                .finished());
    }

    @Test public void test14NosePuedeJugarEnJuegoTerminado(){
        assertThrows( RuntimeException.class,
                () -> getGame(4,4,'A', Arrays.asList(1,1,2,3,3,4))
                        .playBlueAt(1) );
    }


    private Linea getGame(int base, int altura, char juego, List<Integer> movimientos) {
        Linea game = new Linea( base, altura,juego );
        movimientos.forEach(m -> playAt( game, m ) );
        return game;
    }

    private void playAt(Linea game, Integer m) {
        if (game.turnoRojas()){
            game.playRedAt(m);
        } else {
            game.playBlueAt(m);
        }
    }
}
