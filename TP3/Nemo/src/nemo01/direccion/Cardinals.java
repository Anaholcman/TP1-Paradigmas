package nemo01.direccion;

public abstract class Cardinals {
    public int x;
    public int y;
    public int getx() {
        return x;
    }
    public int gety() {
        return y;
    }
    public abstract Cardinals right();
    public abstract Cardinals left();
    public String toString() {
        return "(" + x + "," + y + ")";
    }
    public boolean equals(Cardinals obj) {
        return x == obj.x && y == obj.y;
    }
}

