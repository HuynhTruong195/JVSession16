import java.sql.*;
import java.util.Scanner;

public class TaskManagement {
    private final Scanner scanner = new Scanner(System.in);

    public void addTask(String taskName, String status) {
        try (Connection conn = DBConnection.getConnection();
             CallableStatement stmt = conn.prepareCall("{CALL add_task(?, ?)}")) {
            stmt.setString(1, taskName);
            stmt.setString(2, status);
            stmt.execute();
            System.out.println(" Thêm công việc thành công.");
        } catch (Exception e) {
            System.err.println(" Lỗi khi thêm công việc: " + e.getMessage());
        }
    }

    public void listTasks() {
        try (Connection conn = DBConnection.getConnection();
             CallableStatement stmt = conn.prepareCall("{CALL list_tasks()}")) {
            ResultSet rs = stmt.executeQuery();
            System.out.println(" Danh sách công việc:");
            while (rs.next()) {
                System.out.printf("ID: %d | Tên: %s | Trạng thái: %s%n",
                        rs.getInt("id"), rs.getString("task_name"), rs.getString("status"));
            }
        } catch (Exception e) {
            System.err.println(" Lỗi khi liệt kê: " + e.getMessage());
        }
    }

    public void updateTaskStatus(int taskId, String status) {
        try (Connection conn = DBConnection.getConnection();
             CallableStatement stmt = conn.prepareCall("{CALL update_task_status(?, ?)}")) {
            stmt.setInt(1, taskId);
            stmt.setString(2, status);
           stmt.executeUpdate();
            System.out.println(" Đã cập nhật trạng thái.");
        } catch (Exception e) {
            System.err.println(" Lỗi khi cập nhật: " + e.getMessage());
        }
    }

    public void deleteTask(int taskId) {
        try (Connection conn = DBConnection.getConnection();
             CallableStatement stmt = conn.prepareCall("{CALL delete_task(?)}")) {
            stmt.setInt(1, taskId);
            stmt.execute();
            System.out.println(" Đã xoá công việc.");
        } catch (Exception e) {
            System.err.println(" Lỗi khi xoá: " + e.getMessage());
        }
    }

    public void searchTaskByName(String name) {
        try (Connection conn = DBConnection.getConnection();
             CallableStatement stmt = conn.prepareCall("{CALL search_task_by_name(?)}")) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            System.out.println(" Kết quả tìm kiếm:");
            while (rs.next()) {
                System.out.printf("ID: %d | Tên: %s | Trạng thái: %s%n",
                        rs.getInt("id"), rs.getString("task_name"), rs.getString("status"));
            }
        } catch (Exception e) {
            System.err.println(" Lỗi tìm kiếm: " + e.getMessage());
        }
    }

    public void taskStatistics() {
        try (Connection conn = DBConnection.getConnection();
             CallableStatement stmt = conn.prepareCall("{CALL task_statistics()}")) {
            ResultSet rs = stmt.executeQuery();
            System.out.println(" Thống kê công việc:");
            while (rs.next()) {
                System.out.printf("- %s: %d công việc%n",
                        rs.getString("status"), rs.getInt("total"));
            }
        } catch (Exception e) {
            System.err.println(" Lỗi thống kê: " + e.getMessage());
        }
    }
}
