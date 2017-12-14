import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestGroupsGet {
    @Test
    public  void TestGetGroups() {
        Groups executeGroups = new Groups(1,"Honests", "true", 1);
        Groups testGroups = Groups.getGroups(1);
        assertTrue(testGroups.equals(executeGroups));
    }
}
