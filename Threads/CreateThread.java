/**
 * @author Yuyuan Huang
 * @create 2021-04-21 10:50
 */
public class CreateThread extends Thread {
    //    private static volatile int count;
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(this.getName());
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void createThread() {
        CreateThread thread = new CreateThread();
        CreateThread thread1 = new CreateThread();
        thread.setName("me");
        thread1.setName("you");
        thread.start();
        thread1.start();
    }
}
