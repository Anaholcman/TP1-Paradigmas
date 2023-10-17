package nemo01;

public class North extends Direccion {
    public North() {
        super.x = 1;
        super.y = 0;
    }

    public Direccion right() {
        return new East();
    }

    public Direccion left() {
        return new West();
    }
}
