package com.itranswarp.sample;

import java.util.concurrent.ForkJoinWorkerThread;

public class ThreadInThread {
    public static void main(String[] args) throws InterruptedException{
        Thread t =new MyThread();
        t.start();
        Thread.sleep(1000);
        t.interrupt();
        t.join();
        System.out.println("end");

    }
}
class MyThread extends Thread{
    public void run(){
        Thread hello = new HelloThread();
        hello.start();
        try{
            hello.join();
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }
        hello.interrupt();
    }

}
class HelloThread extends MyThread{
    public void run(){
        int n=0;
        while(!isInterrupted()){
            n++;
            System.out.println(n+"hello");
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                break;
            }
        }
    }
}
