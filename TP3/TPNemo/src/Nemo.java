package TPNemo.src;

public class Nemo {

    public int profundidad;
    public int[] location = new int[]{0,0};
    private final String direccionInicial = "norte";
    private final int norte = 1;
    private final int sur = 2;
    private final int este = 3;
    private final int oeste = 4;
    public char decender = 'd';
    public char ascender = 'u';
    public char rotarIzquierda = 'l';
    public char rotarDerecha = 'r';
    public char avanzar = 'f';
    public char liberarCapsula = 'm';

    //- 'd' que le indica a Nemo descender una unidad.
    //- 'u' que le indica a Nemo ascender una unidad.
    //- 'l' que le indica a Nemo rotar 90 grados a izquierda.
    //- 'r' que le indica a Nemo rotar 90 grados a derecha.
    //- 'f' que le indica a Nemo avanzar una unidad.
    //- 'm' que le indica a Nemo liberar la cápsula.

    public boolean estaEnLaSuperficie(int profundidad) {
        return this.profundidad == 0;
    }

    public int[] getLocation(){
        return this.location;
    }

    public void indication (String Direccion){
        for (int i = 0; i < Direccion.length(); i++) {
            char c = Direccion.charAt(i);

            if (Direccion.equals("d")) {
                this.profundidad += 1;
            }
            if (Direccion.equals("u")) {
                if (this.estaEnLaSuperficie(this.profundidad)) {
                    return;
                }
                this.profundidad -= 1;
            }

        }

    }

    public String getDireccionInicial() {
        return direccionInicial;
    }
}
