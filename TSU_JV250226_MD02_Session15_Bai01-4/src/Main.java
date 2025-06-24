import business.dao.IStudentDao;
import business.dao.StudentDaoImpl;
import business.model.Students;

import java.util.Scanner;

public class Main {
    static IStudentDao iStudentDao = new StudentDaoImpl();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n========= MENU QUẢN LÝ SINH VIÊN =========");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Hiển thị tất cả sinh viên");
            System.out.println("3. Tìm sinh viên theo ID");
            System.out.println("4. Xóa sinh viên theo ID");
            System.out.println("5. Cập nhật thông tin sinh viên");
            System.out.println("6. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    showAllStudents();
                    break;
                case 3:
                    findStudentById();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    updateStudent();
                    break;
                case 6:
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                default:
                    System.out.println(" Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 0);
    }

    private static void addStudent() {
        System.out.print("Nhập tên sinh viên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập ngày sinh (yyyy-MM-dd): ");
        String dob = scanner.nextLine();
        System.out.print("Nhập email: ");
        String email = scanner.nextLine();

        Students s = new Students(0, name, dob, email);
        iStudentDao.addStudent(s);
    }

    private static void showAllStudents() {
        System.out.println(" Danh sách sinh viên:");
        iStudentDao.getAllStudents().forEach(System.out::println);
    }

    private static void findStudentById() {
        System.out.print("Nhập ID sinh viên: ");
        int id = Integer.parseInt(scanner.nextLine());
        Students s = iStudentDao.findStudentById(id);
        if (s != null) {
            System.out.println(" Kết quả: " + s);
        } else {
            System.out.println(" Không tìm thấy sinh viên với ID: " + id);
        }
    }

    private static void deleteStudent() {
        System.out.print("Nhập ID sinh viên cần xoá: ");
        int id = Integer.parseInt(scanner.nextLine());
        iStudentDao.deleteStudent(id);
        System.out.println("Đã xoá nếu ID tồn tại.");
    }

    private static void updateStudent() {
        System.out.print("Nhập ID sinh viên cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());
        Students old = iStudentDao.findStudentById(id);
        if (old == null) {
            System.out.println("Không tìm thấy sinh viên với ID: " + id);
            return;
        }

        System.out.print("Nhập tên mới : ");
        String name = scanner.nextLine();
        System.out.print("Nhập ngày sinh mới (yyyy-MM-dd) : ");
        String dob = scanner.nextLine();
        System.out.print("Nhập email mới : ");
        String email = scanner.nextLine();
    //nếu k nhập gì thì giữ tên cũ
        Students updated = new Students(id,
                name.isEmpty() ? old.getFull_name() : name,
                dob.isEmpty() ? old.getDate_of_birth() : dob,
                email.isEmpty() ? old.getEmail() : email);

        iStudentDao.updateStudent(updated);
        System.out.println(" Đã cập nhật sinh viên.");
    }
}
