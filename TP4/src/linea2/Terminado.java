package linea2;

public class Terminado extends Estado {

    public String ultimoTurno;
    public Estado change() {
        return this;
    }
    public boolean finished() {
        return true;
    }
    public void playRedAt(int prompt, Linea linea) {
        throw new RuntimeException(Linea.JUEGOTERMINADO);
    }
    public void playBlueAt(int prompt, Linea linea) {
        throw new RuntimeException(Linea.JUEGOTERMINADO);
    }




    public String estadoActual(Linea game){
        if (game.empate()){
            return "Juego terminado \n Empate";
        }
        else{
            return "Juego terminado \n El ganador es " + game.ganador();
        }
    }


}
