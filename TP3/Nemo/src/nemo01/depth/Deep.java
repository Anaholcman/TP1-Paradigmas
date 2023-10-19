package nemo01.depth;
public class Deep extends DepthNavigator {
    public static  String NoSePuedeLiberarLaCapsula = "No se puede liberar la capsula";

    public Deep(int profundidad, DepthNavigator anterior){
        this.profundidad = profundidad;
        this.anterior = anterior;
    }
    public DepthNavigator down() {
        return new Deep( profundidad + 1 , this);
    }
    public DepthNavigator up() {
        return anterior;
    }
    public void capsula() {
        throw new RuntimeException(NoSePuedeLiberarLaCapsula);
    }
    public boolean canLaunchCapsule() {
        return false;
    }
}
