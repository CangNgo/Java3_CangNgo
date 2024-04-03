package asm.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author acer
 */
public class Connected {

    public static Connection openConnectionASM() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;database=QLSV;trustServerCertificate=true;encrypt=true;";
        String username = "sa";
        String password = "123123";
        java.sql.Connection con = DriverManager.getConnection(connectionUrl, username, password);
        return con;
    }
}
