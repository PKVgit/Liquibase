import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.Statement;
public class Groups {
    private int CitiesId;
    private int Id;
    private String Name;
    private String Purpose;
    private static List<Groups> groups = new ArrayList<Groups>();

    public Groups() {
        CitiesId = -1;
        Id = -1;
        Name = "Unknown";
        Purpose = "Unknown";
    }
    public Groups(int Id, String Name, String Purpose, int CitiesId) {
        this.Id = Id;
        this.Name = Name;
        this.Purpose = Purpose;
        this.CitiesId = CitiesId;


    }
    private static void addGroup(Groups o) {
        groups.add(o);
    }
    private static void getGroupsFromDB() {
        Connection con = Connect.connect();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Groups");
            while(rs.next()) {
                Groups nGroups = new Groups();
                nGroups.Id = rs.getInt(1);
                nGroups.Purpose = rs.getString(3);
                nGroups.CitiesId=rs.getInt(4);
                nGroups.Name=rs.getString(2);
                if(!groups.contains(nGroups)) {
                    addGroup(nGroups);
                }

            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problem with getting groups");
        } finally {
            Connect.closeConnection(con);
        }
    }
    public static Groups getGroups(int ID) {
        getGroupsFromDB();
        for(Groups o : groups) {
            if(o.Id == ID) {
                return o;
            }
        }
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Groups group = (Groups) o;

        if (CitiesId != group.CitiesId) return false;
        if (Id != group.Id) return false;
        if (Purpose != group.Purpose) return false;
        return Name != null ? Name.equals(group.Name) : group.Name == null;
    }

}
