import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListBenchmark {
    public static void performRandomInsert(List<Integer> list) {
        Random random = new Random();
        for (int i = 0; i < insert; i++) {
            int randomIndex = random.nextInt(list.size() + 2);
            try {
                list.add(randomIndex, -1);
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Lỗi bẫy dữ liệu: Index " + randomIndex + " vượt quá phạm vi, chèn vào cuối thay thế");
                list.add(list.size(), -1);
            }
        }
    }
    static final int size = 100000;
    static final int insert = 10000;
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
        System.out.println("Chèn 10,000 phần tử vào vị trí ngẫu nhiên");

        long startTime = System.currentTimeMillis();
        performRandomInsert(arrayList);
        long endTime = System.currentTimeMillis();
        System.out.println("ArrayList time: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        performRandomInsert(linkedList);
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList time: " + (endTime - startTime) + " ms");
    }

}
