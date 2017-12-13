import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestClipsGet {
    @Test
    public void testGetCompany() {

        Clips executeClips = new Clips(1, "4:25", 2012);
        Clips textClips = Clips.getClip(1);
        assertTrue(executeClips.equals(textClips));
    }
}
