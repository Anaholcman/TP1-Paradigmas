package nemo01;

public class Coords {
    public int x;
    public int y;
    public Coords(){
        x = 0;
        y = 0;
    }
    public Coords add(Direccion direction) {
        x += direction.getx();
        y += direction.gety();
        return this;
    }
    public boolean equals(Coords obj) {
        return x == obj.x && y == obj.y;
    }
}
