package linea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Linea {

    public static final String TABLERONOFACTIBLE = "No se puede hacer un tablero menor a 4";
    public static final String TIPODEJUEGONOVALIDO = "Tipo de juego no valido";
    public static final String NOESTUTURNO = "No es tu turno";
    public static final String JUEGOTERMINADO = "El juego ya termino";
    public static final String COLUMNANOFACTIBLE = "No se puede jugar en esa columna";
    public static final String COLUMNALLENA = "Columna Llena";
    private char turno;
    private int columnas;
    private int filas;
    private char TipoDeJuego;
    private List<Integer> ultimo;
    private List<List<Character>> tablero;

    public Linea(int base, int altura, char tipoDeJuego) {
        this.turno = 'R';
        this.columnas = base;
        this.filas = altura;
        this.ultimo = new ArrayList<>();
        TipoDeJuego = tipoDeJuego;
        if (altura < 4 || base < 4){
            throw new RuntimeException(TABLERONOFACTIBLE);
        } else {
            this.tablero = new ArrayList<>();
            for (int i = 0; i < base; i++){
                this.tablero.add( new ArrayList<>() );
            }
        }
    }

    public boolean turnoRojas() {
        return turno == 'R';
    }
    public boolean turnoAzules() {
        return turno == 'A';
    }

    public String show(){
        StringBuilder tableroString = new StringBuilder();
        IntStream.iterate(filas -1 , i -> i - 1).limit(filas)
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

    private Character getFill(int indexCol, int indexFila) {
        if (indexCol < columnas && indexCol >= 0) {
            if (tablero.get(indexCol).size() > indexFila && indexFila >= 0) {
                return tablero.get(indexCol).get(indexFila);
            }
        }
        return ' ';
    }


    public void playRedAt ( int prompt){
        if (turno == 'A') {
            throw new RuntimeException(NOESTUTURNO);
        } else if (turno == 'T') {
            throw new RuntimeException(JUEGOTERMINADO);
        } else {
            if (prompt > columnas) {
                throw new RuntimeException(COLUMNANOFACTIBLE);
            } else {
                if (tablero.get(prompt - 1).size() == filas) {
                    throw new RuntimeException(COLUMNALLENA);
                } else {
                    List<Character> columna = tablero.get(prompt - 1);
                    columna.add('R');
                    ultimo = Arrays.asList(prompt - 1, columna.size() - 1);
                    if (finished()) {
                        turno = 'T';
                    } else {
                        turno = 'A';
                    }
                }
            }
        }
    }

    public void playBlueAt ( int prompt){
        if (turno == 'R') {
            throw new RuntimeException(NOESTUTURNO);
        } else if (turno == 'T') {
            throw new RuntimeException(JUEGOTERMINADO);
        } else {
            if (prompt > columnas) {
                throw new RuntimeException(COLUMNANOFACTIBLE);
            } else {
                if (tablero.get(prompt - 1).size() == filas) {
                    throw new RuntimeException(COLUMNALLENA);
                } else {
                    turno = 'R';
                    List<Character> columna = tablero.get(prompt - 1);
                    columna.add('A');
                    ultimo = Arrays.asList(prompt - 1, columna.size() - 1);
                    if (finished()) {
                        turno = 'T';
                    }
                }
            }
        }
    }

    public boolean finished() {
        if (turno == 'T') {
            return true;
        } else if (ultimo.isEmpty()) {
            return false;
        } else if ( tablero.stream().reduce(true,(sub, list) -> sub && list.size() == filas, (a, b) -> a && b)) {
            return true;
        } else {
            if (TipoDeJuego == 'A') {
                return finishedA();
            } else if (TipoDeJuego == 'B') {
                return finishedB();
            } else if (TipoDeJuego == 'C') {
                return finishedA() || finishedB();
            }
        }
        throw new RuntimeException(TIPODEJUEGONOVALIDO);
    }

    private boolean finishedA () {
        Character ganador = getFill(ultimo.get(0), ultimo.get(1));
        for (int i = ultimo.get(0) - 3; i < ultimo.get(0); i++) {
            if (i >= 0 && i < columnas) {
                if (getFill(i, ultimo.get(1)).equals(ganador) &&
                        getFill(i + 1, ultimo.get(1)).equals(ganador) &&
                        getFill(i + 2, ultimo.get(1)).equals(ganador) &&
                        getFill(i + 3, ultimo.get(1)).equals(ganador)) {
                    return true;
                }
            }
        }
        for (int j = ultimo.get(1) - 3; j < ultimo.get(1); j++) {
            if (j >= 0 && j < filas) {
                if (getFill(ultimo.get(0), j ).equals(ganador) &&
                        getFill(ultimo.get(0), j + 1).equals(ganador) &&
                        getFill(ultimo.get(0), j + 2).equals(ganador) &&
                        getFill(ultimo.get(0), j + 3).equals(ganador)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean finishedB () {
        Character ganador = getFill(ultimo.get(0), ultimo.get(1));
        for (int i = ultimo.get(0), j = ultimo.get(1); i < ultimo.get(0)+4 && j < ultimo.get(1)+4; i++, j++) {
            if (getFill(i - 3, j - 3).equals(ganador) &&
                    getFill(i - 2, j - 2).equals(ganador) &&
                    getFill(i - 1, j - 1).equals(ganador) &&
                    getFill(i, j).equals(ganador)) {
                return true;
            }
            if (getFill(i + 3, j - 3).equals(ganador) &&
                    getFill(i + 2, j - 2).equals(ganador) &&
                    getFill(i + 1, j - 1).equals(ganador) &&
                    getFill(i , j).equals(ganador)) {
                return true;
            }
        }
        return false;
    }


}