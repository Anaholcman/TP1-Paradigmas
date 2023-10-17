package nemo;

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

    // es su responsabilidad sumarse.
    // coordenada + diferencial. (de magnitud 1)
    // el punto se suma a otra coordenada y eso genera una nueva
    // Hay cosas que son inmutables. Al hacer 1 + 1 el resultado es un tercer numero que es el 2. No se transforma
    //Los strings son inmutables. el resultado de sumar 2 coordenadsa es una nueva coordenada.
    // coordenar con los puntos cardinales que significa avanzar 1. Sumarle un diferencial a la ubicacion.


}
