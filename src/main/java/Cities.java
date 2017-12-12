import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Cities {
    private int CountriesId;
    private int Id;
    private int Years;
    private String Name;
    private static List<Cities> citiesList = new ArrayList<Cities>();

    public Cities() {
        CountriesId = -1;
        Id = -1;
        Years = -1;
        Name = "Unknown";
    }
    public Cities(int CountriesId,String Name, int Years, int Id ) {
        this.CountriesId = CountriesId;
        this.Id = Id;
        this.Years = Years;
        this.Name = Name;
    }
    private static void addDirectory(Cities d) {
        citiesList.add(d);
    }
    private static void getDirectoriesFromDB() {
        Connection con = Connect.connect();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Cities");
            while(rs.next()) {
                Cities nDir = new Cities();
                nDir.Id = rs.getInt(2);
                nDir.CountriesId =rs.getInt(1);
                nDir.Name =rs.getString(3);
                if(!citiesList.contains(nDir)) {
                    addDirectory(nDir);
                }
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problem with getting directories");
        } finally {
            Connect.closeConnection(con);
        }
    }
    public static Cities getDirectory(int ID) {
        getDirectoriesFromDB();
        for(Cities d: citiesList) {
            if(d.Id == ID) {
                return  d;
            }
        }
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cities city = (Cities) o;

        if (CountriesId != city.CountriesId) return false;
        if (Id != city.Id) return false;
        if (Years != city.Years) return false;
        return Name != null ? Name.equals(city.Name) : city.Name == null;
    }

}
