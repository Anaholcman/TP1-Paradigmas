package nemo01;

public class Coords {
    public int x = 0;
    public int y = 0;
    public void sum(Direccion direction) {
        x += direction.getx();
        y += direction.gety();
    }
    public boolean equals(Coords obj) {
        return x == obj.x && y == obj.y;
    }
}
