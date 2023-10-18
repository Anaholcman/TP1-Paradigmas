package nemo;

public abstract class Depth {
        public static int profundidad;
        public Depth anterior;

        public abstract Depth down();
        public abstract Depth up();
        public abstract void lanzarCapsula();
        public abstract boolean IsSurface();
        public abstract int actualDepth(int diferencial);


}

