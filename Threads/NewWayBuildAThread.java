package com.itranswarp.sample;

public class NewWayBuildAThread {
    public static void main(String[] args) throws InterruptedException{

        Thread t = new Thread(() -> {
            System.out.println("Second Thread Begin");
        });
        System.out.println("The Main Thread Begin");
        t.start();
        t.join();
        System.out.println("The Main Thread Stop");
    }
    private void anotherThread() throws InterruptedException{
        Thread t = new Thread();
        t.start();
        Thread.sleep(1);
        t.interrupt();
        t.join();
        System.out.println("end");
    }

}
class MyThread extends Thread{
    public void run(){
        int n=0;
        while(!isInterrupted()){
            n++;
            System.out.println(n+"Hello");
        }
    }
}
