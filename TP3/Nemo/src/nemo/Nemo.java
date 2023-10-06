package nemo;

public class Nemo {
    public int[] location = new int[]{0,0};
    public int depth = 0;
    public int direction = 1;

    public int[] getLocation() {    return location;    }

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
                direction= (direction+1) % 4;
            }
        }
    }



    public int north = 1;
    public int south = 2;
    public int east = 3;
    public int west = 4;

    public char decender = 'd';
    public char ascender = 'u';
    public char rotarIzquierda = 'l';
    public char rotarDerecha = 'r';
    public char avanzar = 'f';
    public char liberarCapsula = 'm';


}