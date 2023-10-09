package nemo;

public class Nemo {
    public Coords location = new Coords();
    public int depth = 0;
    public int direction = 1;

    public Coords getLocation() {    return location;    }

    public int getDirection() {  return direction;   }

    public boolean InSurface() { return this.depth==0; }
    public int getDepth() { return depth;    }

    public void indications(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == decender) {
                depth++;
            }
            if (c == ascender) {
                if (this.InSurface()) {
                    depth--;
                }
            }
            if (c == rotarIzquierda) {
                direction.rotarIzquierda();
            }
            if (c == rotarDerecha) {
                direction.rotarDerecha();
            }
            if (c == avanzar) {
                location.avanzar(direction);
            }
            if (c == liberarCapsula) {
                if (depth <=1) {
                    continue;
                } else {
                    throw new RuntimeException("No se puede liberar la capsula");
                }
            }
        }
    }


    public char decender = 'd';
    public char ascender = 'u';
    public char rotarIzquierda = 'l';
    public char rotarDerecha = 'r';
    public char avanzar = 'f';
    public char liberarCapsula = 'm';


}