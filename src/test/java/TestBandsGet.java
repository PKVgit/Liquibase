import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestBandsGet {
    @Test
    public void testOfficeGet() {
        Bands executeBands = new Bands(1,"Linkin Park", 1996, 7, "USA", 3);
        Bands testBands = Bands.getBand(1);
        assertTrue(executeBands.equals(testBands));
    }
}
