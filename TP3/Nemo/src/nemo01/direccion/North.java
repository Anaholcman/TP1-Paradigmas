package nemo01.direccion;

public class North extends Cardinals {
    public North() {
        super.x = 1;
        super.y = 0;
    }
    public Cardinals right() {
        return new East();
    }

    public Cardinals left() {
        return new West();
    }
}
