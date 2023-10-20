package nemo;

public class East extends Cardinals {
    public East() {
        super.x = 0;
        super.y = 1;
    }

    public Cardinals right() {
        return new South();
    }
    public Cardinals left() {
        return new North();
    }
}
