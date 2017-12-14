import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.FileSystemResourceAccessor;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Connect.connect();
        try {
            testMigrations();
            System.out.println("All migrations successful...");
        } catch (LiquibaseException ex) {
            ex.printStackTrace();
        }
        Connect.disconnect();
    }

    public static void testMigrations() throws LiquibaseException {

        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(Connect.connection));

        File change_create_tableOne = new File(ClassLoader.getSystemResource("db/changelog/cr/db.changelog-1.0.1.xml").getFile());
        File change_create_tableTwo = new File(ClassLoader.getSystemResource("db/changelog/cr/db.changelog-1.0.2.xml").getFile());
        File change_create_tableThree = new File(ClassLoader.getSystemResource("db/changelog/cr/db.changelog-1.0.3.xml").getFile());
        File change_create_tableFour = new File(ClassLoader.getSystemResource("db/changelog/cr/db.changelog-1.0.4.xml").getFile());
        File change_create_tableFive = new File(ClassLoader.getSystemResource("db/changelog/cr/db.changelog-1.0.5.xml").getFile());
        File change_dadoOne = new File(ClassLoader.getSystemResource("db/changelog/del/db.changelog-1.1.1.xml").getFile());
        File change_dadoTwo = new File(ClassLoader.getSystemResource("db/changelog/del/db.changelog-1.1.2.xml").getFile());
        File change_dadoThree = new File(ClassLoader.getSystemResource("db/changelog/del/db.changelog-1.1.3.xml").getFile());
        File change_dadoFour = new File(ClassLoader.getSystemResource("db/changelog/del/db.changelog-1.1.4.xml").getFile());
        File change_dadoFive = new File(ClassLoader.getSystemResource("db/changelog/del/db.changelog-1.1.5.xml").getFile());
        File change_setRaw = new File(ClassLoader.getSystemResource("db/changelog/SetRaw/db.changelog-0.0.0.xml").getFile());
        File change_updateRaw = new File(ClassLoader.getSystemResource("db/changelog/UpdateRaw/db.changelog-1.2.5.1.xml").getFile());
        File change_updateData = new File(ClassLoader.getSystemResource("db/changelog/UpdateData/db.changelog-1.5.5.xml").getFile());
        File change_renameColumn = new File(ClassLoader.getSystemResource("db/changelog/renameColumn/db.changelog-1.3.5.xml").getFile());
        File change_newColumn = new File(ClassLoader.getSystemResource("db/changelog/NewColumn/db.changelog-1.6.5.xml").getFile());
        File change_newTable = new File(ClassLoader.getSystemResource("db/changelog/NewTable/db.changelog-1.4.5.1.xml").getFile());
        File change_dropAllTables = new File(ClassLoader.getSystemResource("db/changelog/DropAllTable/db.changelog-1.6.6.xml").getFile());


        Liquibase create_tableOne = new liquibase.Liquibase(change_create_tableOne.toString(), new FileSystemResourceAccessor(), database);
        Liquibase create_tableTwo = new liquibase.Liquibase(change_create_tableTwo.toString(), new FileSystemResourceAccessor(), database);
        Liquibase create_tableThree = new liquibase.Liquibase(change_create_tableThree.toString(), new FileSystemResourceAccessor(), database);
        Liquibase create_tableFour = new liquibase.Liquibase(change_create_tableFour.toString(), new FileSystemResourceAccessor(), database);
        Liquibase create_tableFive = new liquibase.Liquibase(change_create_tableFive.toString(), new FileSystemResourceAccessor(), database);
        Liquibase dadoOne = new liquibase.Liquibase(change_dadoOne.toString(), new FileSystemResourceAccessor(), database);
        Liquibase dadoTwo = new liquibase.Liquibase(change_dadoTwo.toString(), new FileSystemResourceAccessor(), database);
        Liquibase dadoThree = new liquibase.Liquibase(change_dadoThree.toString(), new FileSystemResourceAccessor(), database);
        Liquibase dadoFour = new liquibase.Liquibase(change_dadoFour.toString(), new FileSystemResourceAccessor(), database);
        Liquibase dadoFive = new liquibase.Liquibase(change_dadoFive.toString(), new FileSystemResourceAccessor(), database);
        Liquibase setRaw = new liquibase.Liquibase(change_setRaw.toString(), new FileSystemResourceAccessor(), database);
        Liquibase updateRaw = new liquibase.Liquibase(change_updateRaw.toString(), new FileSystemResourceAccessor(), database);
        Liquibase updateData = new liquibase.Liquibase(change_updateData.toString(), new FileSystemResourceAccessor(), database);
        Liquibase renameColumn = new liquibase.Liquibase(change_renameColumn.toString(), new FileSystemResourceAccessor(), database);
        Liquibase newColumn = new liquibase.Liquibase(change_newColumn.toString(), new FileSystemResourceAccessor(), database);
        Liquibase newTable = new liquibase.Liquibase(change_newTable.toString(), new FileSystemResourceAccessor(), database);
        Liquibase dropAllTables = new liquibase.Liquibase(change_dropAllTables.toString(), new FileSystemResourceAccessor(), database);


        create_tableOne.update(new Contexts(), new LabelExpression());
        create_tableTwo.update(new Contexts(), new LabelExpression());
        create_tableThree.update(new Contexts(), new LabelExpression());
        create_tableFour.update(new Contexts(), new LabelExpression());
        create_tableFive.update(new Contexts(), new LabelExpression());
        dadoOne.update(new Contexts(), new LabelExpression());
        dadoTwo.update(new Contexts(), new LabelExpression());
        dadoThree.update(new Contexts(), new LabelExpression());
        dadoFour.update(new Contexts(), new LabelExpression());
        dadoFive.update(new Contexts(), new LabelExpression());
        setRaw.update(new Contexts(), new LabelExpression());
        updateRaw.update(new Contexts(), new LabelExpression());
        updateData.update(new Contexts(), new LabelExpression());
        renameColumn.update(new Contexts(), new LabelExpression());
        newColumn.update(new Contexts(), new LabelExpression());
        newTable.update(new Contexts(), new LabelExpression());
        dropAllTables.update(new Contexts(), new LabelExpression());
    }
}
