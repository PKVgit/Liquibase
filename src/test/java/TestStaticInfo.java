import org.junit.Test;

public class TestStaticInfo {
    @Test
    public void testStInfo() {
        String realUrl= Connect.db_url;
        String realUserName=Connect.user;
        String realPass=Connect.password;

        assert("jdbc:postgresql://127.0.0.1:5432/Earth".equals(realUrl)&&"postgres".equals(realUserName)&&"0987".equals(realPass));

    }
}
