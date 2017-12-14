import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestCountriesGet {
    @Test
    public void testCountriesGet() {
        Countries executeCount = new Countries(1,"Russia",  1);
        Countries testCount = Countries.getCountry(1);
        assertTrue(executeCount.equals(testCount));
    }
}
