package nemo;

public abstract class Depth {
        public static int profundidad;
        public abstract Depth down();
        public abstract Depth up();
        public abstract void lanzarCapsula();
        public abstract boolean IsSurface();

        public int value() {
                return profundidad;
        }


}

