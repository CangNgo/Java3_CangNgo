
package lab5.lab5baithem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connected34 {

    public static Connection Connection34() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;database=QLSP;trustServerCertificate=true;encrypt=true;";
        String username = "sa";
        String password = "123123";
        Connection con = DriverManager.getConnection(connectionUrl, username, password);
        System.out.println("Ket noi thanh cong");

        return con;
    }
}
