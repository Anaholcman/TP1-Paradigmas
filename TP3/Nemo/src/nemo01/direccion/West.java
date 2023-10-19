package nemo01.direccion;

public class West extends Cardinals {
    public West() {
        super.x = 0;
        super.y = -1;
    }
    public Cardinals right() {
        return new North();
    }
    public Cardinals left() {
        return new South();
    }
}
