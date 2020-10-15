package com.itranswarp.sample;
//对共享变量进行读写时，必须保证一组指令以原子方式执行：即某一个线程执行时，其他线程必须等待：缺点是性能下降，因为synchronized代码块无法并发执行。此外，加锁和解锁需要消耗一定的时间
public class TwoThread {
    public static void main(String[] args)throws Exception{
        AddThread addT = new AddThread();
        DecThread decT = new DecThread();
        addT.start();
        decT.start();
        addT.join();
        decT.join();
        System.out.println(Counter.counter);
    }
}
class Counter{
    public static final Object lock = new Object();
    public static int counter = 0;
}
class AddThread extends Thread{
    public void run(){
        for(int i=0;i<1000;i++){
            synchronized(Counter.lock){//synchronized保证了代码块在任意时刻最多只有一个线程能执行
                Counter.counter+=1;
            }

        }
    }
}
class DecThread extends Thread{
    public void run(){
        for (int i=0;i<1000;i++){
            synchronized (Counter.lock){
                Counter.counter-=1;
            }
        }
    }
}