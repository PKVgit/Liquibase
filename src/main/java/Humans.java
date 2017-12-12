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

    public Humans(int Id, int Age, int GroupId,  String FirstName) {
        this.Id = Id;
        this.Age = Age;
        this.GroupId = GroupId;
        this.FirstName = FirstName;
    }

    private static void getWorkersFromDB() {
        Connection con = Connect.connect();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM humans ");
            while (rs.next()) {
                Humans nWorker = new Humans();
                nWorker.GroupId = rs.getInt(1);
                nWorker.Age =rs.getInt(2);
                nWorker.Id =rs.getInt(3);
                nWorker.FirstName =rs.getString(5);
                if(!humans.contains(nWorker)) {
                    workerAddToList(nWorker);
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

    private static void workerAddToList(Humans w) {
        humans.add(w);
    }

    public static Humans getWorker(int ID) {
        getWorkersFromDB();
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
