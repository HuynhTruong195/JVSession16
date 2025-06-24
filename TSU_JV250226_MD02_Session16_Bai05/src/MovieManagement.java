import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieManagement {
    Connection conn = ConnectionDb.getConnection();

    public void addMovie(String title, String director, int year) {
        try {
            conn.setAutoCommit(false);
            CallableStatement call = conn.prepareCall("{call add_movie(?,?,?)}");
            call.setString(1, title);
            call.setString(2, director);
            call.setInt(3, year);
            call.executeUpdate();
            conn.commit();
            System.out.println(" Đã thêm phim.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listMovies() {
        try {

            CallableStatement call = conn.prepareCall("{call list_movies()}");
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                System.out.println("🎬 ID: " + rs.getInt("id") +
                        " | Title: " + rs.getString("title") +
                        " | Director: " + rs.getString("director") +
                        " | Year: " + rs.getInt("year"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateMovie(int id, String title, String director, int year) {
        try {
            conn.setAutoCommit(false);
            CallableStatement call = conn.prepareCall("{call update_movie(?,?,?,?)}");
            call.setInt(1, id);
            call.setString(2, title);
            call.setString(3, director);
            call.setInt(4, year);
            int rows = call.executeUpdate();
            conn.commit();
            System.out.println(rows > 0 ? " Cập nhật thành công." : "Không tìm thấy phim.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteMovie(int id) {
        try {
            conn.setAutoCommit(false);
            CallableStatement call = conn.prepareCall("{call delete_movie(?)}");
            call.setInt(1, id);
            int rows = call.executeUpdate();
            conn.commit();
            System.out.println(rows > 0 ? " Đã xóa phim." : " Không tìm thấy phim.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
