package nemo;

 public class East extends Direccion {
        public East() {
            super.x = 0;
            super.y = 1;
        }

        public Direccion right() {
            return new South();
        }

        public Direccion left() {
            return new North();
        }
}
