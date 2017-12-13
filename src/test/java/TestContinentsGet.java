import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestContinentsGet {
    @Test
    public void testGetCompany() {
        Continents executeCompany = new Continents(1,"epam",1);
        Continents textCompany = Continents.getCompany(1);
        assertTrue(executeCompany.equals(textCompany));
    }
}
