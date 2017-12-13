import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class TestAlbumsGet {
    @Test
    public void testDirectoryGet() {
        Albums executeAlb = new Albums(1,"Nimrod", 1997, 22, 3);

        Albums testDir = Albums.getAlbum(1);
        assertTrue(executeAlb.equals(testDir));
    }

}
