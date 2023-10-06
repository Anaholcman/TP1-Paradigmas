package nemo;

public class Nemo {

    public int[] location = new int[]{0, 0};
    public int depth = 0;
    public int direction = 1;
    public int north = 1;
    public int east = 2;
    public int south = 3;
    public int west = 0;

    public char descender = 'd';
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

    public int[] getLocation() {
        return location;
    }

    public int getDirection() {
        return direction;
    }
    public boolean InSurface() {
        return this.depth == 0;
    }

    public int getDepth() {
        return depth;
    }

    public void indications(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == descender) {
                depth++;
            }
            if (c == ascender) {
                if (!this.InSurface()) {
                    depth--;
                }
            }
            if (c == rotarIzquierda) {
                direction = (direction + 1) % 4; // impar
            }
            if (c == rotarDerecha) {
                direction = (direction - 1) % 4; // par
            }
            if (c == avanzar) {
                if (direction == north) {
                    location[1]++;
                }
                if (direction == east) {
                    location[0]++;
                }
                if (direction == south) {
                    location[1]--;
                }
                if (direction == west) {
                    location[0]--;
                }
            }
            if (c == liberarCapsula) {
                if (depth <= 1) {
                    // dice que no se detecta un cambio cuando se tira la capsula
                } else {
                    throw new RuntimeException("No se puede liberar la capsula");
                }
            }
        }
    }



}






