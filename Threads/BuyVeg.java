/**
 * @author Yuyuan Huang
 * @create 2021-04-20 23:24
 */
public class BuyVeg implements Runnable {
    private volatile static int count = 0;


    @Override
    public void run(){
        synchronized (this){
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(java.lang.Thread.currentThread().getName()+":"+count++);
                    java.lang.Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    //DENG JIA YU
    public synchronized  void run1(){

    }
    public void method(Object obj){
        synchronized (obj){
            System.out.println(obj.toString());
        }
    }

}
