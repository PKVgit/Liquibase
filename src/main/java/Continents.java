import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Continents {
    private int Id;
    private String Name;
    private int Teritory;
    private static List<Continents> companyList = new ArrayList<Continents>();

    public Continents() {
        Id = -1;
        Name = "Unknown";
        Teritory = -1;
    }

    public Continents(int Id, String Name, int Num) {
        this.Id = Id;
        this.Name = Name;
        this.Teritory = Num;
    }

    private static void getContinentsFromDB() {
        Connection con = Connect.connect();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Continents");
            while(rs.next()) {
                Continents nContinents = new Continents();
                nContinents.Id=rs.getInt(1);
                nContinents.Name=rs.getString(2);
                nContinents.Teritory=rs.getInt(3);
                if(!companyList.contains(nContinents)){
                    addCompany(nContinents);
                }
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problem with company getting");
        } finally {
            Connect.closeConnection(con);
        }
    }
    private static void addCompany(Continents c) {
        companyList.add(c);
    }

    public static Continents getCompany(int ID) {
        getContinentsFromDB();
        for(Continents c : companyList) {
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

        Continents continents = (Continents) o;

        if (Id != continents.Id) return false;
        if (Teritory != continents.Teritory) return false;
        return Name != null ? Name.equals(continents.Name) : continents.Name == null;
    }


}
