import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {
    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/movie_db",
                    "root",
                    "Weak"

            );
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(" Lỗi kết nối DB: " + e.getMessage(), e);
        }
    }
}
