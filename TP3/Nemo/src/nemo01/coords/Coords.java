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
        x += direction.getx();
        y += direction.gety();
        return this;
    }
    public boolean equals(Coords obj) {
        return x == obj.x && y == obj.y;
    }
    public String toString() {
        return "(" + x + "," + y + ")";
    }

}
