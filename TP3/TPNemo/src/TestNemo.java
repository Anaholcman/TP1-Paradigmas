package TPNemo.src;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestNemo {

@Test public void test00() {
    Nemo nemo = new Nemo();
    assertTrue(nemo.profundidad == 0);
    assertArrayEquals(nemo.getLocation(), new int[]{0,0});
    assertEquals(nemo.getDireccionInicial(), "norte");

}
@Test public void test01() {
    Nemo nemo = new Nemo();
    nemo.indication("");
    assertArrayEquals(nemo.getLocation(), new int[]{0,0});
}
@Test public void test02() {
    Nemo nemo = new Nemo();
    nemo.indication("d");

}

@Test public void test03() {
    // pasarle "U"
}

@Test public void test04() {
    // un char
}


}
