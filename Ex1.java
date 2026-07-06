import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
public class Ex61 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String choice;
        ArrayList<Double> bangdiem=new ArrayList<>();
        double max=-1, min=11,sum=0;
        int countPass=0,countFail=0,countExcelent=0,count=0;
        while(true){
            System.out.println("\n********************QUẢN LÝ ĐIỂM SV********************");
            System.out.println("1. Nhập danh sách điểm sinh viên");
            System.out.println("2. In danh sách điểm");
            System.out.println("3. Tính điểm trung bình của các sinh viên");
            System.out.println("4. Tìm điểm cao nhất và thấp nhất");
            System.out.println("5. Đếm số lượng sinh viên đạt và trượt");
            System.out.println("6. Sắp xếp điểm tăng dần");
            System.out.println("7. Thống kê số lượng sinh viên giỏi và xuất sắc");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice=sc.nextLine();
            try{
                int x=Integer.parseInt(choice);
            }catch (NumberFormatException e){
                System.out.print("Nhập lại");
                continue;
            }
            if(choice.equals("8")) break;
            else if(choice.equals("1")){
                while (true) {
                    String input = sc.nextLine();
                    if (input.isEmpty()) {
                        break;
                    }
                    try {
                        double diem = Double.parseDouble(input);
                        bangdiem.add(diem);
                        if(diem>max) max=diem;
                        if(diem<min) min=diem;
                        sum+=diem;
                        count++;
                        if(diem>=8) countExcelent++;
                        if(diem>=5) countPass++;
                        if(diem<5) countFail++;
                    } catch (NumberFormatException e) {
                        System.out.println("Vui lòng nhập số hợp lệ hoặc nhấn enter để dừng!");
                    }
                }
            }else if(choice.equals("2")){
                for(int i=0;i<count;i++){
                    System.out.print(bangdiem.get(i)+" ");
                }
            }else if(choice.equals("3")){
                System.out.printf("Điểm trung bình: %.2f",sum/count);
            }else if(choice.equals("4")){
                System.out.printf("Điểm cao nhất: %.2f \nĐiểm thấp nhất: %.2f",max,min);
            }else if(choice.equals("5")){
                System.out.printf("Số sinh viên đạt: %d\nSố sinh viên trượt: %d",countPass,countFail);
            }else if(choice.equals("6")){
                bangdiem.sort(Comparator.naturalOrder());
                System.out.println("Bảng điểm sau sắp xếp: ");
                for(int i=0;i<count;i++){
                    System.out.print(bangdiem.get(i)+" ");
                }
            }else if(choice.equals("7")){
                System.out.printf("Số sinh viên giỏi và xuất sắc: %d",countExcelent);
            }
        }

    }
}
