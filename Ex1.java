import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface ICapability {
    void checkPerformance();
}
abstract class Staff implements ICapability {
    protected String id;
    protected String name;
    protected double baseSalary;

    public Staff(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }
    public abstract double calculateTotalSalary();

    public void displayInfo() {
        System.out.printf("ID: %s | Tên: %-15s | Lương thực nhận: %,.0f VNĐ\n",
                id, name, calculateTotalSalary());
    }
}
// 3. Class Lecturer
class Lecturer extends Staff {
    private int teachingHours;

    public Lecturer(String id, String name, double baseSalary, int teachingHours) {
        super(id, name, baseSalary);
        this.teachingHours = teachingHours;
    }

    @Override
    public double calculateTotalSalary() {
        return baseSalary + (teachingHours * 200000);
    }

    @Override
    public void checkPerformance() {
        System.out.println("Giảng viên " + name + " được đánh giá dựa trên số giờ dạy.");
    }

    public void setTeachingHours(int teachingHours) { this.teachingHours = teachingHours; }
}

class AdminStaff extends Staff {
    private double bonus;
    public AdminStaff(String id, String name, double baseSalary, double bonus) {
        super(id, name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateTotalSalary() {
        return baseSalary + bonus;
    }
    @Override
    public void checkPerformance() {
        System.out.println("Nhân viên " + name + " được đánh giá dựa trên KPI hành chính.");
    }

    public void setBonus(double bonus) { this.bonus = bonus; }
}
public class Ex121 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Staff> staffList = new ArrayList<>();

        while (true) {
            System.out.println("\n--- HỆ THỐNG QUẢN LÝ TRUNG TÂM ---");
            System.out.println("1. Thêm mới nhân sự");
            System.out.println("2. Hiển thị danh sách và Lương");
            System.out.println("3. Cập nhật thông tin theo ID");
            System.out.println("4. Xóa nhân sự theo ID");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Chọn loại (1. Giảng viên / 2. Admin): ");
                    int type = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập ID: "); String id = sc.nextLine();
                    System.out.print("Nhập tên: "); String name = sc.nextLine();
                    System.out.print("Nhập lương cơ bản: "); double base = Double.parseDouble(sc.nextLine());

                    if (type == 1) {
                        System.out.print("Nhập số giờ dạy: ");
                        int hours = Integer.parseInt(sc.nextLine());
                        staffList.add(new Lecturer(id, name, base, hours));
                    } else {
                        System.out.print("Nhập tiền thưởng: ");
                        double bonus = Double.parseDouble(sc.nextLine());
                        staffList.add(new AdminStaff(id, name, base, bonus));
                    }
                    break;

                case 2:
                    System.out.println("\n--- DANH SÁCH NHÂN SỰ ---");
                    for (Staff s : staffList) {
                        s.displayInfo();
                        s.checkPerformance();
                    }
                    break;
                case 3:
                    System.out.print("Nhập ID cần sửa: ");
                    String editId = sc.nextLine();
                    for (Staff s : staffList) {
                        if (s.id.equals(editId)) {
                            System.out.print("Nhập tên mới: "); s.name = sc.nextLine();
                            if (s instanceof Lecturer l) {
                                System.out.print("Nhập giờ dạy mới: ");
                                l.setTeachingHours(Integer.parseInt(sc.nextLine()));
                            } else if (s instanceof AdminStaff a) {
                                System.out.print("Nhập thưởng mới: ");
                                a.setBonus(Double.parseDouble(sc.nextLine()));
                            }
                            System.out.println("Cập nhật thành công!");
                        }
                    }
                    break;

                case 4:
                    System.out.print("Nhập ID cần xóa: ");
                    String delId = sc.nextLine();
                    staffList.removeIf(s -> s.id.equals(delId));
                    System.out.println("Đã xóa xong!");
                    break;

                case 5:
                    System.out.println("Tạm biệt!");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn sai!");
            }
        }
    }
}
