package linea;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Linea {

    public static String NOESTUTURNO = "No es tu turno";
    public static String JUEGOTERMINADO = "El juego ya termino";
    public static String COLUMNANOFACTIBLE = "No se puede jugar en esa columna";
    public static String COLUMNALLENA = "Columna Llena";

    private int columnas;
    private int filas;
    public List<List<Character>> tablero;
    private Estrategia TipoDeJuego;
    private Estado stateOftheGame;
    public String jugadorActual;
    private String ganador = "No hay ganador";

    public  Linea (int base, int altura, char tipoDeJuego) {
        this.stateOftheGame = new TurnoRed();
        this.jugadorActual = "Rojo";
        this.columnas = base;
        this.filas = altura;
        this.tablero = new ArrayList<>();
        IntStream.range(0, base)
                .forEach(i -> tablero.add(new ArrayList<>()));

        this.TipoDeJuego = Estrategia.getEstrategia(tipoDeJuego);
    }

    public boolean turnoRojas() {
        return stateOftheGame.turnoRojas();
    }
    public boolean turnoAzules() {
        return stateOftheGame.turnoAzules();
    }
    public boolean finished() {
        return stateOftheGame.finished();
    }

    public void playRedAt(int prompt ){
        stateOftheGame.playRedAt(prompt, this);
    }
    public void playBlueAt ( int prompt ){
        stateOftheGame.playBlueAt(prompt, this);
    }
    public void playAt(int donde) {
        if (donde > columnas) {
            throw new RuntimeException(COLUMNANOFACTIBLE);
        } else if (tablero.get(donde - 1).size() == filas) {
            throw new RuntimeException(COLUMNALLENA);
        } else {
            tablero.get(donde - 1).add(stateOftheGame.ficha());
            this.stateOftheGame = comprobarTerminado(donde - 1);
            this.jugadorActual = stateOftheGame.quienJuega();
        }
    }

    public Estado comprobarTerminado(int donde) {
        if ( empate() ){
            return new Empate();
        } else if (TipoDeJuego.finished(this, donde)){
            this.ganador = this.jugadorActual;
            return new Terminado();
        }
        return stateOftheGame.change();
    }

    public boolean empate() {
        return tablero.stream().reduce(true,(sub, list) -> sub && list.size() == filas, (a, b) -> a && b);
    }

    public boolean TerminadoPorLinea ( int donde) {
        Integer indexFila = tablero.get(donde).size() - 1;
        char quien = obtenerFicha(donde, indexFila);

        boolean boolfila = IntStream.iterate(donde - 3, i -> i + 1).limit(4)
                .mapToObj(col -> IntStream.range(0, 4)
                                .map( i -> obtenerFicha(col + i, indexFila))
                                .allMatch( c -> c == quien))
                .anyMatch(b -> b == true);

        boolean boolcol = IntStream.iterate(indexFila - 3, i -> i + 1).limit(4)
                .mapToObj(fila -> IntStream.range(0, 4)
                                .map( i -> obtenerFicha(donde, fila + i))
                                .allMatch( c -> c == quien))
                .anyMatch(b -> b == true);

        return boolfila || boolcol;
    }

    public boolean TerminadoPorDiagonal(int donde) {
        return isBoolDiagonal(donde, 1) || isBoolDiagonal(donde, -1);
    }

    private boolean isBoolDiagonal(int donde, int num) {
        Integer indexFila = tablero.get(donde).size() - 1;
        char quien = obtenerFicha(donde, indexFila);
        return IntStream.range(0, 4)
                .mapToObj(i -> IntStream.range(0, 4)
                        .map(j -> obtenerFicha(donde + i + j * num, indexFila + i - j))
                        .allMatch(c -> c == quien))
                .anyMatch(b -> b == true);
    }

    public String show(){
        StringBuilder tableroString = new StringBuilder();
        String separador = "|\n||" +  "---|".repeat(columnas) + "|\n";

        IntStream.iterate(filas - 1 , i -> i - 1).limit(filas)
            .forEach(fila -> {
                tableroString.append("||");
                tablero.forEach( col -> tableroString
                        .append( " " +
                                 obtenerFicha(tablero.indexOf(col), fila) +
                                 " |") );
                tableroString.append( separador );
            });

        StringBuilder baseDelTablero = new StringBuilder();
        IntStream.range(1, columnas + 1)
                .forEach(i -> baseDelTablero.append("===").append(i)
                );
        baseDelTablero.append("===");

        tableroString.replace(tableroString.length() - ( separador.length() - 2 ),
                tableroString.length() -1 ,
                baseDelTablero.toString()
        );

        return tableroString.toString() + stateOftheGame.estadoActual(this);
    }

    public Character obtenerFicha(int indexCol, int indexFila) {
        if (indexCol < columnas && indexCol >= 0) {
            if (tablero.get(indexCol).size() > indexFila && indexFila >= 0) {
                return tablero.get(indexCol).get(indexFila);
            }
        }
        return ' ';
    }

    public String ganador() {
        return ganador;
    }
}