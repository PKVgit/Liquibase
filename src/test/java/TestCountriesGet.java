import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestCountriesGet {
    @Test
    public void testCountriesGet() {
        Countries executeCoun = new Countries(1,"Russia",  3);
        Countries testCoun = Countries.getCountry(1);
        assertTrue(executeCoun.equals(testCoun));
    }
}
