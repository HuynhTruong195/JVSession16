import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MovieManagement manager = new MovieManagement();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== QUẢN LÝ PHIM ===");
            System.out.println("1. Thêm phim");
            System.out.println("2. Danh sách phim");
            System.out.println("3. Sửa phim");
            System.out.println("4. Xóa phim");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Tiêu đề: ");
                    String title = scanner.nextLine();
                    System.out.print("Đạo diễn: ");
                    String director = scanner.nextLine();
                    System.out.print("Năm: ");
                    int year = Integer.parseInt(scanner.nextLine());
                    manager.addMovie(title, director, year);
                    break;

                case 2:
                    manager.listMovies();
                    break;

                case 3:
                    System.out.print("ID phim cần sửa: ");
                    int idUpdate = Integer.parseInt(scanner.nextLine());
                    System.out.print("Tiêu đề mới: ");
                    String titleUp = scanner.nextLine();
                    System.out.print("Đạo diễn mới: ");
                    String dirUp = scanner.nextLine();
                    System.out.print("Năm mới: ");
                    int yearUp = Integer.parseInt(scanner.nextLine());
                    manager.updateMovie(idUpdate, titleUp, dirUp, yearUp);
                    break;

                case 4:
                    System.out.print("ID phim cần xóa: ");
                    int idDel = Integer.parseInt(scanner.nextLine());
                    manager.deleteMovie(idDel);
                    break;

                case 5:
                    System.out.println("Thoát");
                    System.exit(0);
                    break;

                default:
                    System.out.println(" Lựa chọn không hợp lệ.");
            }

        } while (choice != 5);
    }
}
