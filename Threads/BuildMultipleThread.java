package com.itranswarp.sample;

public class BuildMultipleThread {
    public static void main(String[] args){
        System.out.println("The Main Thread");
        Thread t = new Thread(){
            @Override
            public void run() {
                super.run();
                System.out.println("The Second Thread");
                try{
                    Thread.sleep(10);
                }catch (InterruptedException ignored){

                }
                System.out.println("The Second Thread End Here");
            }
        };
        t.start();
        try{
            Thread.sleep(20);
        }catch (InterruptedException e){

        }
        System.out.println("Main Thread End Here");

    }
}
