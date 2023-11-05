package linea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Linea {

    private char turno;
    private int columnas;
    private int filas;
    private char TipoDeJuego;
    private List<Integer> ultimo;
    private List<List> tablero;


    public  Linea (int base, int altura, char tipoDeJuego) {
        this.turno = 'R';
        this.columnas = base;
        this.filas = altura;
        TipoDeJuego = tipoDeJuego;
        if (altura < 4 || base < 4){
            throw new RuntimeException("No se puede hacer un tablero menor a 4");
        } else {
            this.tablero = new ArrayList<>();
            for (int i = 0; i < base; i++){
                this.tablero.add( new ArrayList<>() );
            }
        }

    }
    public void setTurno(char turno) {
        this.turno = turno;
    }

    public boolean turnoRojas() {
        return turno == 'R';
    }

    public boolean turnoAzules() {
        return turno == 'A';
    }

    public String show() {
        String tableroString = "";
        for (int i = filas -1; i >= 0; i--){
            for (int j = 0; j < columnas; j++){
                tableroString += getFill( j, i);
            }
            tableroString += "\n";
        }
        return tableroString;

    }

    private String getFill(int indexCol, int indexFila) {
         if  (indexCol < columnas && indexFila < filas && indexCol >= 0 && indexFila >= 0) {
             List columna = tablero.get(indexCol);
             if (columna.size() > indexFila) {
                 char espacio = (char) columna.get(indexFila);
                 if ('R' == espacio) {
                     return "R";
                 } else if ((Character) 'A' == columna.get(indexFila)) {
                     return "A";
                 }
             }
         }
             return "-";

    }

    public boolean finished() {
        if (TipoDeJuego == 'A') {
            return finishedA();
        } else if (TipoDeJuego == 'B') {
            return finishedB();
        } else if (TipoDeJuego == 'C') {
            return finishedA() || finishedB();
        } else {
                throw new RuntimeException("Tipo de juego no valido");
            }
        }

        public void playRedkAt ( int prompt){
            if (turno == 'A') {
                throw new RuntimeException("No es tu turno");
            } else if (turno == 'T') {
                throw new RuntimeException("El juego ya termino");

            } else {
                if (prompt > columnas) {
                    throw new RuntimeException("No se puede jugar en esa columna");
                } else {
                    if (tablero.get(prompt - 1).size() == filas) {
                        throw new RuntimeException("Columna Llena");
                    } else {
                        List columna = tablero.get(prompt - 1);
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
                throw new RuntimeException("No es tu turno");
            } else if (turno == 'T') {
                throw new RuntimeException("El juego ya termino");
            } else {
                if (prompt > columnas) {
                    throw new RuntimeException("No se puede jugar en esa columna");
                } else {
                    if (tablero.get(prompt - 1).size() == filas) {
                        throw new RuntimeException("Columna Llena");
                    } else {
                        turno = 'R';
                        List columna = tablero.get(prompt - 1);
                        columna.add('A');
                        ultimo = Arrays.asList(prompt - 1, columna.size() - 1);
                        if (finished()) {
                            turno = 'T';
                        }

                    }

                }
            }
        }


        private boolean finishedA () {
            String ganador = getFill(ultimo.get(0), ultimo.get(1));
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
                    if (getFill(j, ultimo.get(0)).equals(ganador) &&
                            getFill(j + 1, ultimo.get(0)).equals(ganador) &&
                            getFill(j + 2, ultimo.get(0)).equals(ganador) &&
                            getFill(j + 3, ultimo.get(0)).equals(ganador)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean finishedB () {
            String ganador = getFill(ultimo.get(0), ultimo.get(1));
            for (int i = 0; i < 4; i++) {
                if (getFill(ultimo.get(0) - 3 + i, ultimo.get(1) - 3 + i).equals(ganador) &&
                        getFill(ultimo.get(0) - 2 + i, ultimo.get(1) - 2 + i).equals(ganador) &&
                        getFill(ultimo.get(0) - 1 + i, ultimo.get(1) - 1 + i).equals(ganador) &&
                        getFill(ultimo.get(0) + i, ultimo.get(1) + i).equals(ganador)) {
                    return true;
                }
                if (getFill(ultimo.get(0) + 3 + i, ultimo.get(1) - 3 + i).equals(ganador) &&
                        getFill(ultimo.get(0) + 2 + i, ultimo.get(1) - 2 + i).equals(ganador) &&
                        getFill(ultimo.get(0) + 1 + i, ultimo.get(1) - 1 + i).equals(ganador) &&
                        getFill(ultimo.get(0) + i, ultimo.get(1) + i).equals(ganador)) {
                    return true;
                }
            }
            return false;
        }

}

