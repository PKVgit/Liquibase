import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestCitiesGet {
    @Test
    public void testGetCity() {

        Cities executeCities = new Cities(1, "Kyiv", 1, 1);
        Cities textCities = Cities.getCity(1);
        assertTrue(executeCities.equals(textCities));
    }
}
