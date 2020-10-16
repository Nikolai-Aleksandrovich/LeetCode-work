package com.itranswarp.sample;

public class ThreadWithDaemonThread {
    public static void main(String[] args) throws InterruptedException{
        Thread t = new HelloThread();
        t.setDaemon(true);
        t.start();
        Thread.sleep(1000);
        t.interrupt();
        t.join();



    }
}
class HelloThread extends Thread{
    public void run(){
        System.out.println("Start");
        ThirdPartyThread t3 = new ThirdPartyThread();
        t3.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t3.interrupt();
        try {
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
class ThirdPartyThread extends HelloThread{
    public void run(){
        System.out.println("ThirdPartyThread Start");

    }
}
class
