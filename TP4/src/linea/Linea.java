package linea;

import java.util.ArrayList;
import java.util.List;

public class Linea {

    private char turno;
    private int base;
    private int altura;
    private char TipoDeJuego;
    private List<List> tablero;


    public  Linea (int base, int altura, char tipoDeJuego) {
        this.turno = 'R';
        this.base = base;
        this.altura = altura;
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
        for (int i = altura -1 ; i >= 0; i--){
            for (int j = 0; j < base; j++){
                tableroString += getFill( j, i);
            }
            tableroString += "\n";
        }
        return tableroString;

    }

    private String getFill(int indexCol, int indexFila) {
        List columna = tablero.get(indexCol);
        if (columna.size() > indexFila){
            char espacio  = (char) columna.get(indexFila);
            if ('R' == espacio){
                return "R";
            }
            else if ((Character)'A' == columna.get(indexFila)) {
                return "A";
            }
        }
        return "-";
    }

    public boolean finished() {
        return false;
    }

    public void playRedkAt(int prompt)  {
        if (turno != 'R'){
            throw  new RuntimeException("No es tu turno");
        }
        else {
            if (prompt > base){
                throw new RuntimeException("No se puede jugar en esa columna");
            }
            else {
                if (tablero.get(prompt).size() == altura){
                    throw new RuntimeException("Columna Llena");
                }
                else {
                    List columna = tablero.get(prompt);
                    columna.add('R');
                    turno = 'A';
                }

            }
        }
    }

    public void playBlueAt(int prompt) {
        if (turno != 'A'){
            throw  new RuntimeException("No es tu turno");
        }
        else {
            if (prompt > base){
                throw new RuntimeException("No se puede jugar en esa columna");
            }
            else {
                if (tablero.get(prompt).size() == altura){
                    throw new RuntimeException("Columna Llena");
                }
                else{
                    List columna = tablero.get(prompt);
                    columna.add('A');
                    turno = 'R';
                }

            }
        }
    }


}

