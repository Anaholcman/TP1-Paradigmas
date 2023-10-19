package nemo01.coords;

import nemo01.direccion.Cardinals;

public class Coords {
    public int x;
    public int y;
    public Coords(){
        x = 0;
        y = 0;
    }
    public Coords add(Cardinals direction) {
        x += direction.getX();
        y += direction.getY();
        return this;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
