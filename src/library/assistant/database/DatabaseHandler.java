package library.assistant.database;

import javafx.scene.layout.Pane;

import java.lang.invoke.SwitchPoint;
import java.sql.*;
import javax.swing.JOptionPane;

public class DatabaseHandler {

    private static DatabaseHandler handler;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/book";
    private static final String DB_USER_NAME = "root";
    private static final String DB_PASSWORD = "";
    private static Connection conn = null;
    private static Statement stmt = null;

    public DatabaseHandler() {
        createConnection();
        setupBookTable();
    }

    // created the database connection
    public void createConnection() {
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // created the Book table
    public void setupBookTable() {
        try {
            stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS book" +
                    "(id varchar(255) PRIMARY key, title varchar (255), " +
                    " author varchar (255), publisher varchar (255), " +
                    "isAvail boolean default true )");

            stmt.execute("SET GLOBAL time_zone = '+6:00'");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // created the execute query function
    public ResultSet execQuery(String query) {
        ResultSet result = null;
        try {
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);

        } catch (SQLException e) {
            System.out.println("Exception at execQuery:dataHandler" + e.getLocalizedMessage());
        }
        return result;
    }

    // created the execAction
    public boolean execAction(String qu) {
        try {
            stmt = conn.createStatement();
            stmt.execute(qu);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage(), "Error Occurred", JOptionPane.ERROR_MESSAGE);
            System.out.println("Exception at execQuery:dataHandler" + e.getLocalizedMessage());
            return false;
        }
    }
}
