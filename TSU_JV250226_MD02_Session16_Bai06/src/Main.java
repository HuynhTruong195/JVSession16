import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManagement taskManager = new TaskManagement();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n************ TO-DO LIST MENU ************");
            System.out.println("1. Thêm công việc");
            System.out.println("2. Liệt kê công việc");
            System.out.println("3. Cập nhật trạng thái công việc");
            System.out.println("4. Xóa công việc");
            System.out.println("5. Tìm kiếm công việc theo tên");
            System.out.println("6. Thống kê công việc");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Nhập tên công việc: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập trạng thái (chưa hoàn thành/đã hoàn thành): ");
                    String status = scanner.nextLine();
                    taskManager.addTask(name, status);
                }
                case 2 -> taskManager.listTasks();
                case 3 -> {
                    System.out.print("Nhập ID công việc: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Trạng thái mới: ");
                    String newStatus = scanner.nextLine();
                    taskManager.updateTaskStatus(id, newStatus);
                }
                case 4 -> {
                    System.out.print("Nhập ID cần xoá: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    taskManager.deleteTask(id);
                }
                case 5 -> {
                    System.out.print("Nhập từ khoá tìm kiếm: ");
                    String keyword = scanner.nextLine();
                    taskManager.searchTaskByName(keyword);
                }
                case 6 -> taskManager.taskStatistics();
                case 0 -> System.out.println(" Thoát chương trình.");
                default -> System.out.println(" Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }
}
