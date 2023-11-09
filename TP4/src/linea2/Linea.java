package linea2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Linea {

    public static final String NOESTUTURNO = "No es tu turno";
    public static final String JUEGOTERMINADO = "El juego ya termino";
    public static final String COLUMNANOFACTIBLE = "No se puede jugar en esa columna";
    public static final String COLUMNALLENA = "Columna Llena";

    private int columnas;
    private int filas;
    public List<List<Character>> tablero;
    private Estrategia TipoDeJuego;
    private GameInProgress turno;
    private Estado estadoActual;
    private String ganador;

    public  Linea (int base, int altura, char tipoDeJuego) {
        this.turno = new TurnoRed();
        this.columnas = base;
        this.filas = altura;
        this.tablero = new ArrayList<>();
        IntStream.range(0, base)
                .forEach(i -> tablero.add(new ArrayList<>()));
        Estrategia.estrategias.stream()
                .filter(estrategia -> estrategia.isChar(tipoDeJuego))
                .forEach(estrategia -> TipoDeJuego = estrategia);
    }

    public boolean turnoRojas() {
        return turno.turnoRojas();
    }
    public boolean turnoAzules() {
        return turno.turnoAzules();
    }
    public boolean finished() {
        return estadoActual.finished();
    }

    public void playRedAt(int prompt ){
        turno.playRedAt(prompt, this);
    }
    public void playBlueAt ( int prompt ){
        turno.playBlueAt(prompt, this);
    }
    public void playAt(char quien, int donde) {
        if (donde > columnas) {
            throw new RuntimeException(COLUMNANOFACTIBLE);
        } else if (tablero.get(donde - 1).size() == filas) {
            throw new RuntimeException(COLUMNALLENA);
        } else {
            tablero.get(donde - 1).add(quien);
            this.turno = turno.change();
            comprobarTerminado(donde - 1);
        }
    }

    public boolean comprobarTerminado(int donde) {
        if (empate() || TipoDeJuego.finished(this, donde)){
            this.estadoActual = new GameOver();
            this.ganador = estadoActual.TurnoActual();
            return true;
        }
        return false;
    }

    public boolean empate() {
        return tablero.stream().reduce(true,(sub, list) -> sub && list.size() == filas, (a, b) -> a && b);
    }

    public boolean TerminadoPorLinea ( int donde) {
        Integer indexFila = tablero.get(donde).size() - 1;
        char quien = getFill(donde, indexFila);

        boolean boolfila = IntStream.iterate(donde - 3, i -> i + 1).limit(4)
                .mapToObj(col -> IntStream.range(0, 4)
                                .map( i -> getFill(col + i, indexFila))
                                .allMatch( c -> c == quien))
                .anyMatch(b -> b == true);

        boolean boolcol = IntStream.iterate(indexFila - 3, i -> i + 1).limit(4)
                .mapToObj(fila -> IntStream.range(0, 4)
                                .map( i -> getFill(donde, fila + i))
                                .allMatch( c -> c == quien))
                .anyMatch(b -> b == true);

        return boolfila || boolcol;
    }

    public boolean TerminadoPorDiagonal(int donde) {
        return isBoolDiagonal(donde, 1) || isBoolDiagonal(donde, -1);
    }

    private boolean isBoolDiagonal(int donde, int num) {
        Integer indexFila = tablero.get(donde).size() - 1;
        char quien = getFill(donde, indexFila);
        return IntStream.range(0, 4)
                .mapToObj(i -> IntStream.range(0, 4)
                        .map(j -> getFill(donde + i + j* num, indexFila + i - j))
                        .allMatch(c -> c == quien))
                .anyMatch(b -> b == true);
    }

    public String show(){
        StringBuilder tableroString = new StringBuilder();
        IntStream.iterate(filas - 1 , i -> i - 1).limit(filas)
            .forEach(fila -> {
                tableroString.append("||");
                tablero.forEach( col -> tableroString.append(" ").append(getFill(tablero.indexOf(col), fila)).append(" |") );
                tableroString.append("|\n||").append(("---|").repeat(columnas)).append("|\n");
            });
        StringBuilder a = new StringBuilder();
        IntStream.range(1, columnas + 1)
                .forEach(i -> a.append("===").append(i));
        a.append("===");
        tableroString.replace(tableroString.length()-(columnas*4+4), tableroString.length()-1, a.toString());
        return tableroString.toString();
    }

    public Character getFill(int indexCol, int indexFila) {
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