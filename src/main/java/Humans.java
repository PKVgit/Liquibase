import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Humans {
    private int Id;
    private int Age;
    private int GroupId;
    private String FirstName;
    public static List<Humans> humans = new ArrayList<Humans>();

    public Humans() {
        Id = -1;
        Age = -1;
        GroupId = -1;
        FirstName = "NoName";


    }

    public Humans(int Id,String FirstName, int Age, int GroupId ) {
        this.Id = Id;
        this.FirstName = FirstName;
        this.Age = Age;
        this.GroupId = GroupId;

    }

    private static void getHumansFromDB() {
        Connection con = Connect.connect();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM humans ");
            while (rs.next()) {
                Humans nWorker = new Humans();
                nWorker.GroupId = rs.getInt(4);
                nWorker.Age =rs.getInt(3);
                nWorker.Id =rs.getInt(1);
                nWorker.FirstName =rs.getString(2);
                if(!humans.contains(nWorker)) {
                    HumanAddToList(nWorker);
                }
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Problem with getting");
            e.printStackTrace();
        } finally {
            Connect.closeConnection(con);
        }
    }

    private static void HumanAddToList(Humans w) {
        humans.add(w);
    }

    public static Humans getHuman(int ID) {
        getHumansFromDB();
        for (Humans w : humans) {
            if (w.Id == ID) {
                return w;
            } else {
                return null;
            }

        }
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Humans worker = (Humans) o;

        if (Id != worker.Id) return false;
        if (Age != worker.Age) return false;
        if (GroupId != worker.GroupId) return false;
        return FirstName != null ? !FirstName.equals(worker.FirstName) : worker.FirstName != null ;
    }
    
}
