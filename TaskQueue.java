package com.itranswarp.sample;

import java.util.LinkedList;
import java.util.Queue;

public class TaskQueue {
    //模拟多个线程给队列中添加任务
    Queue<String> queue = new LinkedList<>();
    public synchronized void addTask(String s){

        queue.add(s);
        this.notify();
        //唤醒一个正在this锁等待的线程

    }
    public synchronized String getTask(){
        while (queue.isEmpty()){
            this.wait();
            //wait()方法必须在当前获取的锁对象上调用
            //wait()方法调用时，会释放线程获得的锁，wait()方法返回后，线程又会重新试图获得锁。
        }
        return queue.remove();
    }
    //当条件不满足时，线程进入等待状态；当条件满足时，线程被唤醒，继续执行任务。

}
