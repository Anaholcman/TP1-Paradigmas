package nemo01;

public abstract class Direccion {
    public int x;
    public int y;
    public int getx() {
        return x;
    }
    public int gety() {
        return y;
    }
    public abstract Direccion right();
    public abstract Direccion left();
    public String toString() {
        return "(" + x + "," + y + ")";
    }
    public boolean equals(Direccion obj) {
        return x == obj.x && y == obj.y;
    }
}

