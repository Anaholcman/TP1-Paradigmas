package linea;

import java.util.ArrayList;
import java.util.List;

public class Linea {

    private char turno;
    private int base;
    private int altura;
    private char TipoDeJuego;
    private ArrayList<List> tablero;

    public  Linea (int base, int altura, char tipoDeJuego) {
        turno = 'R';
        this.base = base;
        this.altura = altura;
        TipoDeJuego = tipoDeJuego;
        tablero = new ArrayList<>();
        if (altura < 4 || base < 4){
            throw new RuntimeException("No se puede hacer un tablero menor a 4");
        }
        for (int i = 0; i < base; i++){
            tablero.add( new ArrayList<>(altura) );
            for (int j = 0; j < altura; j++){
                tablero.get(i).add('-');
            }
        }


    }

    public boolean turnoRojas() {
        return turno == 'R';
    }

    public boolean turnoAzules() {
        return turno == 'A';
    }

    public String show() {
        String tableroString = "";
        for (int i = altura; i > 0; i--){
            for (int j = 0; j < base; j++){
                tableroString += tablero.get(j).get(i);
            }
            tableroString += "\n";
        }
        return tableroString;

    }

    public boolean finished() {
        return false;
    }

    public void playRedkAt(int prompt)  {
        if (turno != 'R'){
            throw  new RuntimeException("No es tu turno");
        }
        else {
            turno = 'A';
        }
    }

    public void playBlueAt(int prompt) {
        if (turno != 'A'){
            throw  new RuntimeException("No es tu turno");
        }
        else {
            turno = 'R';
        }
    }


}

