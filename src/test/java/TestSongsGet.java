import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestSongsGet {
    @Test
    public void testCountryGet(){
        Songs executeSongs = new Songs(1, "Numb", "3:07", 3);
        Songs testSongs = Songs.getSong(1);
        assertTrue(executeSongs.equals(testSongs));
    }
}
