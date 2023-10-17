package nemo;

public class West extends Direccion {
    public West() {
        super.x = 0;
        super.y = -1;
    }

    public Direccion right() {
        return new North();
    }

    public Direccion left() {
        return new South();
    }

}