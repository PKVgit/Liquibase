import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.SQLException;

public class Countries {
    private int Id;
    private String Name;
    private int ContinentsId;
    private static List<Countries> countriesList = new ArrayList<Countries>();

    public Countries() {
        Id = -1;
        Name = "Unknown";
        ContinentsId = -1;
    }
    public Countries(int ContinentsId, int Id, String Name) {
        this.ContinentsId =ContinentsId;
        this.Id = Id;
        this.Name = Name;
    }
    private static void countriesAdd(Countries c) {
        countriesList.add(c);
    }
    private static void getCountiesFromDB() {
        Connection con = Connect.connect();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Countries");
            while(rs.next()) {
                Countries nCountry = new Countries();
                nCountry.Id  = rs.getInt(2);
                nCountry.Name = rs.getString(3);
                nCountry.ContinentsId = rs.getInt(1);
                if(!countriesList.contains(nCountry)) {
                    countriesAdd(nCountry);
                }
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problem with getting countries");
        } finally {
            Connect.closeConnection(con);
        }

    }
    public static Countries getCountry(int ID) {
        getCountiesFromDB();
        for(Countries c : countriesList) {
            if(c.Id == ID) {
                return c;
            }
            return null;
        }
        return null;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Countries country = (Countries) o;
        if (ContinentsId != country.ContinentsId) return false;
        if (Id != country.Id) return false;
        return Name != null ? Name.equals(country.Name) : country.Name == null;
    }

}
