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
    public Cities(int Id,String Name, int Years, int CountriesId ) {

        this.Id = Id;
        this.Name = Name;
        this.Years = Years;
        this.CountriesId = CountriesId;
    }
    private static void addCities(Cities d) {
        citiesList.add(d);
    }
    private static void getCitiesFromDB() {
        Connection con = Connect.connect();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Cities");
            while(rs.next()) {
                Cities nCit = new Cities();
                nCit.Id = rs.getInt(1);
                nCit.Years = rs.getInt(3);
                nCit.CountriesId =rs.getInt(4);
                nCit.Name =rs.getString(2);
                if(!citiesList.contains(nCit)) {
                    addCities(nCit);
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
    public static Cities getCity(int ID) {
        getCitiesFromDB();
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
