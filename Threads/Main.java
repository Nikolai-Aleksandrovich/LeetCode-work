/**
 * @author Yuyuan Huang
 * @create 2021-04-20 23:31
 */
public class Main {
    public static void main(String[] args) {
        BuyVeg thread = new BuyVeg();
        java.lang.Thread thread1 = new java.lang.Thread(thread,"name1");
        java.lang.Thread thread2 = new java.lang.Thread(thread,"name2");
        thread1.start();
        thread2.start();
    }
}
