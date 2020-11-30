package com.itranswarp.sample;
//线程调用add()、dec()方法时，它不必关心同步逻辑，因为synchronized代码块在add()、dec()方法内部。对多个count实例可以并发执行

public class SynchronizedMethod {
    private int count = 0;
    //这两个add一样
    public void add(){
        synchronized (this){
            count+=1;
        }
    }
    public synchronized void add1(){
        count+=1;
    }
    public void dec(){
        synchronized (this){
            count-=1;
        }
    }
    public int getCount(){
        return count;
    }
}

