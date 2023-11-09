package linea2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LineaTest {

    @Test public void test01TableroEmpiezaVacio(){
        assertEquals(new Linea( 4, 4,'C' ).tablero.stream().mapToInt(List::size).sum(), 0);
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
        assertEquals(game.getFill(0,0),'0');
        assertEquals("||   |   |   |   ||\n" +
                     "||---|---|---|---||\n" +
                     "||   |   |   |   ||\n" +
                     "||---|---|---|---||\n" +
                     "||   |   |   |   ||\n" +
                     "||---|---|---|---||\n" +
                     "|| 0 |   |   |   ||\n" +
                     "===1===2===3===4===\n", game.show());
        assertTrue( game.turnoAzules() );
        assertFalse( game.turnoRojas() );
    }

    @Test public void test04QuierejugarAzulEnTurnoDeRojo() {
        Linea game = new Linea( 4, 4,'C' );
        assertThrows( RuntimeException.class, () -> game.playBlueAt( 1 ) );
    }

    @Test public void test05QuierejugarRojoEnTurnoDeAzul() {
        Linea game = new Linea( 4, 4,'C' );
        game.playRedAt(1);
        assertThrows( RuntimeException.class, () -> game.playRedAt( 1 ));
    }

    @Test public void test06QuiereJugarEnColumnaOutOfBounds(){
        Linea game = new Linea( 4, 4,'C' );
        assertThrows(RuntimeException.class, () -> game.playRedAt( 5 ));
        assertEquals(game.getFill(0,0),' ');
    }

    @Test public void test07QuiereJugarEnColumnaLlena(){
        Linea game = getGame(4,4,'C', Arrays.asList(1,1,1,1));
        assertThrows( RuntimeException.class, () -> game.playRedAt(1));
    }

    @Test public void test08JuegoNoTerminado(){
        assertFalse( getGame(4,4,'C', Arrays.asList(1,1))
                .finished());
    }

    @Test public void test09GanatipoAFila(){
        assertTrue( getGame(4,4,'A', Arrays.asList(1,1,2,2,3,3,4))
                .finished());
    }

    @Test public void test10GanatipoAColumna(){
        assertTrue( getGame(4,4,'A', Arrays.asList(1,2,1,2,1,2,1))
                .finished());
    }

    @Test public void test11NoGanatipoADiagonal(){
        assertFalse( getGame(4, 4, 'A', Arrays.asList(1, 2, 3, 4, 2, 3, 3, 4, 4, 2, 4))
                .finished());
    }

    @Test public void test12NoGanatipoBFila(){
        assertFalse( getGame(4, 4, 'B', Arrays.asList(1, 1, 2, 2, 3, 3, 4))
                .finished());
    }

    @Test public void test13NoGanatipoBColumna(){
        assertFalse( getGame(4, 4, 'B', Arrays.asList(1, 2, 1, 2, 1, 2, 1))
                .finished());
    }

    @Test public void test14GanatipoBDiagonal(){
        assertTrue( getGame(4,4,'B', Arrays.asList(1,2,3,4,2,3,3,4,4,2,4))
                .finished());
    }

    @Test public void test15GanatipoCFila(){
        assertTrue( getGame(4,4,'C', Arrays.asList(1,1,2,2,3,3,4))
                .finished());
    }

    @Test public void test16GanatipoCColumna(){
        assertTrue( getGame(4,4,'C', Arrays.asList(1,2,1,2,1,2,1))
                .finished());
    }

    @Test public void test17GanatipoCDiagonal(){
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
    @Test public void tableroConGrandesDimensiones(){
        assertEquals(new Linea( 8, 7,'C' ).tablero.stream().mapToInt(List::size).sum(), 0);
        assertEquals("||   |   |   |   |   |   |   |   ||\n" +
                     "||---|---|---|---|---|---|---|---||\n" +
                     "||   |   |   |   |   |   |   |   ||\n" +
                     "||---|---|---|---|---|---|---|---||\n" +
                     "||   |   |   |   |   |   |   |   ||\n" +
                     "||---|---|---|---|---|---|---|---||\n" +
                     "||   |   |   |   |   |   |   |   ||\n" +
                     "||---|---|---|---|---|---|---|---||\n" +
                     "||   |   |   |   |   |   |   |   ||\n" +
                     "||---|---|---|---|---|---|---|---||\n" +
                     "||   |   |   |   |   |   |   |   ||\n" +
                     "||---|---|---|---|---|---|---|---||\n" +
                     "||   |   |   |   |   |   |   |   ||\n" +
                     "===1===2===3===4===5===6===7===8===\n",
                new Linea( 8, 7,'C' ).show());
    }

   @Test public void ganadorRojoimprimeRojo(){
        assertEquals("Rojas", getGame(4,4,'B', Arrays.asList(1,2,3,4,2,3,3,4,4,2,4))
                .ganador());
    }


    @Test public void getFilledSeHaceCorrectamente(){
        Linea game = new Linea( 4, 4,'C' );
        game.playRedAt(1);
        assertEquals(game.getFill(0,0),'0');
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
