import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestSitesGet {
    @Test
    public  void TestGetWorkers() {
        Sites executeSites = new Sites(1,"LinkinPark.com", 1, 3, 1, 2);
        Sites testSites = Sites.getSite(1);
        assertTrue(testSites.equals(executeSites));
    }
}
