package nemo01.direccion;

public class South extends Cardinals {
    public South() {
        super.x = -1;
        super.y = 0;
    }

    public Cardinals right() {
        return new West();
    }

    public Cardinals left() {
        return new East();
    }
}
