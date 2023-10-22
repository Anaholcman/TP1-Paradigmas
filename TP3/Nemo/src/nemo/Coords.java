package nemo;

public class Coords {
    public int x;
    public int y;
    public Coords(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Coords add11(Cardinals direction) {
        x += direction.getX();
        y += direction.getY();
        return this;
    }
    public Coords add(Cardinals direccionAditiva) {
        return new Coords(this.x + direccionAditiva.x, this.y + direccionAditiva.y);
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
