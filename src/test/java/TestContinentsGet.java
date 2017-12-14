import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class TestContinentsGet {
    @Test
    public void testContinentsGet() {
        Continents executeCon = new Continents(1, "America" , 342327);

        Continents testCon = Continents.getContinent(1);
        assertTrue(executeCon.equals(testCon));
    }

}
