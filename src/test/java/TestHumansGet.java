import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestHumansGet {
    @Test
    public void testHumansGet(){
        Humans executeHumans = new Humans(1, "Max", 19, 1);
        Humans testHumans = Humans.getHuman(1);
        assertTrue(executeHumans.equals(testHumans));
    }
}
