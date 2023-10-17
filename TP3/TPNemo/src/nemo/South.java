package nemo;

public class South extends Direccion{
    public South() {
        super.x = -1;
        super.y = 0;
    }

    public Direccion right() {
        return new West();
    }

    public Direccion left() {
        return new East();
    }
}
