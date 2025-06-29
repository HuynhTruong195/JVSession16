import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws SQLException, SQLException {
        String url = "jdbc:mysql://localhost:3306/todo_app";
        String user = "root";
        String password = "Weak";
        return DriverManager.getConnection(url, user, password);
    }
}
