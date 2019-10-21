package dao;

import utility.Printer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DBConnection {

    private final static String DATABASE_NAME = "meals";
    private final static String URL = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
    private final static String USERNAME = "root";
    private final static String PASSWORD = "Dubstep_420";
    private static Connection connection;
    private static DBConnection instance;

    private DBConnection(Connection connection) {
        DBConnection.connection = connection;
    }

    static Connection getConnection() {
        if (instance == null) {
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                instance = new DBConnection(connection);
                Printer.printAlert("Connection successful");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

}
