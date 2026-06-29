import java.util.Scanner;
public class Ex31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("========= NHẬP THÔNG TIN HÓA ĐƠN =========\n");
        System.out.print("Nhập tên khách hàng: ");
        String tenKH = sc.nextLine();
        System.out.print("");
        System.out.print("Nhập tên sản phẩm: ");
        String tenSp = sc.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double Gia = sc.nextFloat();
        System.out.print("Nhập số lượng mua: ");
        int soluong = sc.nextInt();
        System.out.print("Khách có thẻ thành viên? (true/false): ");
        boolean thetv = sc.nextBoolean();
        System.out.print("========= HÓA ĐƠN =========\n");
        System.out.println("Khách hàng: "+tenKH);
        System.out.println("Sản phầm: "+tenSp);
        System.out.printf("Giá: %,.2f\n",Gia);
        System.out.println("Số lượng: "+soluong);
        System.out.printf("Thành tiền: %,.2f\n",Gia*soluong);
        double discount=Gia*soluong*0.1;
        if(thetv){
            System.out.printf("Giảm giá: %,.2f\n",Gia*soluong*0.1);
        }else{System.out.println("Giảm giá: 0"); discount=0;}
        System.out.printf("Tiền VAT: %,.2f\n",Gia*soluong*0.08);
        System.out.printf("Tiền VAT: %,.2f\n",Gia*soluong+Gia*soluong*0.08-discount);
    }
}
