package slide5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/qlsv";
    private static final String USER = "root";
    private static final String PASSWORD = "123123";

    public static void main(String[] args) {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
                System.out.println("Connected to the database successfully!");
            }
        } catch (ClassNotFoundException e) {
            // Handle errors related to loading the JDBC driver
            System.err.println("Failed to load MySQL JDBC driver: " + e.getMessage());
        } catch (SQLException e) {
            // Handle database connection errors
            System.err.println("Failed to connect to the database: " + e.getMessage());
        }
    }
}
