package linea;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LineaTest {

    @Test public void test01TableroEmpiezaVacio(){
        Linea game = new Linea(4, 4, 'C');
        assertEquals( 0, game.tablero.stream().mapToInt(List::size).sum());
        assertEquals("||   |   |   |   ||\n" +
                     "||---|---|---|---||\n" +
                     "||   |   |   |   ||\n" +
                     "||---|---|---|---||\n" +
                     "||   |   |   |   ||\n" +
                     "||---|---|---|---||\n" +
                     "||   |   |   |   ||\n" +
                     "===1===2===3===4===\n" +
                     "Playing Red",
                game.show());
        assertEquals("No hay ganador", game.ganador());
    }

    @Test public void test02EmpiezanLasRojas(){
        Linea game = new Linea( 4, 4,'C' );
        assertTrue( game.turnoRojas() );
        assertEquals( "Rojo", game.jugadorActual );
    }

    @Test public void test03TurnoLasAzules(){
        Linea game = new Linea( 4, 4,'C' );
        game.playRedAt( 1 );
        assertEquals(game.obtenerFicha(0,0),'0');
        assertEquals("||   |   |   |   ||\n" +
                     "||---|---|---|---||\n" +
                     "||   |   |   |   ||\n" +
                     "||---|---|---|---||\n" +
                     "||   |   |   |   ||\n" +
                     "||---|---|---|---||\n" +
                     "|| 0 |   |   |   ||\n" +
                     "===1===2===3===4===\n" +
                     "Playing Blue", game.show());
        assertTrue( game.turnoAzules() );
        assertFalse( game.turnoRojas() );
        assertEquals( "Azul", game.jugadorActual );
    }

    @Test public void test04QuierejugarAzulEnTurnoDeRojo() {
        Linea game = new Linea( 4, 4,'C' );
        assertThrowsLike( () -> game.playBlueAt( 1 ), Linea.NOESTUTURNO);
    }

    @Test public void test05QuierejugarRojoEnTurnoDeAzul() {
        Linea game = new Linea( 4, 4,'C' );
        game.playRedAt(1);
        assertThrowsLike( () -> game.playRedAt( 1 ), Linea.NOESTUTURNO);
    }

    @Test public void test06QuiereJugarEnColumnaOutOfBounds(){
        Linea game = new Linea( 4, 4,'C' );
        assertThrowsLike( () -> game.playRedAt( 5 ), Linea.COLUMNANOFACTIBLE);
        assertEquals(game.obtenerFicha(0,0),' ');
    }

    @Test public void test07QuiereJugarEnColumnaLlena(){
        Linea game = getGame(4,4,'C', Arrays.asList(1,1,1,1));
        assertThrowsLike( () -> game.playRedAt(1), Linea.COLUMNALLENA);

    }

    @Test public void test08JuegoNoTerminado(){
        assertFalse( getGame(4,4,'C', Arrays.asList(1,1))
                .finished());
    }

    @Test public void test09GanatipoAFila(){
        Linea game = getGame(4,4,'A', Arrays.asList(1,1,2,2,3,3,4));
        assertTrue( game.finished() );
        assertEquals( "Rojo", game.ganador());
    }

    @Test public void test10GanatipoAColumna(){
        Linea game = getGame(4,4,'A', Arrays.asList(3,1,2,1,2,1,2,1));
        assertTrue( game.finished());
        assertEquals( "Azul", game.ganador());
    }

    @Test public void test11NoGanatipoADiagonal(){
        assertFalse( getGame(4, 4, 'A', Arrays.asList(1, 2, 3, 4, 2, 3, 3, 4, 4, 2, 4))
                .finished());
    }

    @Test public void test12NoGanatipoBLinea(){
        assertFalse( getGame(4, 4, 'B', Arrays.asList(1, 1, 2, 2, 3, 3, 4))
                .finished());
    }

    @Test public void test13GanatipoBDiagonalIzquierda(){
        assertTrue( getGame(4, 4, 'B', Arrays.asList(4,3,2,1,3,2,2,1,1,3,1))
                .finished());
    }

    @Test public void test14GanatipoBDiagonalDerecha(){
        assertTrue( getGame(4,4,'B', Arrays.asList(1,2,3,4,2,3,3,4,4,2,4))
                .finished());
    }

    @Test public void test15GanatipoCLinea(){
        assertTrue( getGame(4,4,'C', Arrays.asList(1,1,2,2,3,3,4))
                .finished());
    }

    @Test public void test16GanatipoCDiagonal(){
        assertTrue( getGame(4,4,'C', Arrays.asList(1,2,3,4,2,3,3,4,4,2,4))
                .finished());
    }

    @Test public void test18TerminaElJuegoEnEmpate(){
        assertTrue( getGame(4,4,'A', Arrays.asList(1,2,3,4,4,3,2,1,4,3,2,1,1,2,3,4))
                .finished());
        assertEquals( "No hay ganador",getGame(4,4,'A', Arrays.asList(1,2,3,4,4,3,2,1,4,3,2,1,1,2,3,4))
                .ganador());
    }

    @Test public void test19NosePuedeJugarEnJuegoTerminado(){
        assertThrowsLike( () -> getGame(4,4,'A', Arrays.asList(1,1,2,2,3,3,4))
                        .playRedAt(1),
                Linea.JUEGOTERMINADO );

    }

    @Test public void test20estrategiaNoValida(){
        assertThrowsLike( () -> new Linea(4,4,'D'),
                "La estrategia no es válida. Debe ser A, B o C." );
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

    private void assertThrowsLike(Executable executable, String message) {
        assertEquals(message, assertThrows(Exception.class, executable).getMessage());
    }
}
