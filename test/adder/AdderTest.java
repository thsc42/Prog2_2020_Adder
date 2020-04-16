package adder;

import org.junit.Assert;
import org.junit.Test;

public class AdderTest {
    @Test
    public void gutTest1() throws Exception {
        Adder adder = new AdderImpl();
        int summe = adder.add(1, 1);
        Assert.assertEquals(2, summe);
    }

    @Test
    public void gutTest2() throws Exception {
        Adder adder = new AdderImpl();
        int summe = adder.add(40, 2);
        Assert.assertEquals(42, summe);
    }

    @Test
    public void randTest1() throws Exception {
        Adder adder = new AdderImpl();
        int summe = adder.add(Integer.MAX_VALUE, 0);
        Assert.assertEquals(Integer.MAX_VALUE, summe);
    }

    @Test
    public void randTest2() throws Exception {
        Adder adder = new AdderImpl();
        int summe = adder.add(Integer.MIN_VALUE, 0);
        Assert.assertEquals(Integer.MIN_VALUE, summe);
    }

    @Test
    public void schlechtTest1() {
        Adder adder = new AdderImpl();
        try {
            int summe = adder.add(Integer.MAX_VALUE, 1);
            // falsch
            Assert.fail();
        } catch (Exception e) {
            // hier bin ich richtig
        }
    }

    @Test(expected=Exception.class)
    public void schlechtTest2() throws Exception {
        Adder adder = new AdderImpl();
            adder.add(Integer.MIN_VALUE, -1);
    }
}
