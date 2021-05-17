import java.util.Scanner;

/**
 * @author Yuyuan Huang
 * @create 2021-05-13 19:43
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int orderNumber = scanner.nextInt();
        int[] startTime = new int[orderNumber];
        int[] endTime = new int[orderNumber];
        int[] price = new int[orderNumber];
        for (int i = 0; i < orderNumber; i++) {
            startTime[i] = scanner.nextInt();
        }
        for (int i = 0; i < orderNumber; i++) {
            endTime[i] = scanner.nextInt();
        }
        for (int i = 0; i < orderNumber; i++) {
            price[i] = scanner.nextInt();
        }


    }
}
