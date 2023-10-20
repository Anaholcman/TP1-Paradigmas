package nemo;

public abstract class Cardinals {
    public int x;
    public int y;
    public abstract Cardinals right();
    public abstract Cardinals left();
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}

