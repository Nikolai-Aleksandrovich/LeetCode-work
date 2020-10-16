package com.itranswarp.sample;
//四组线程分别设置两个锁
//单条原子操作的语句不需要同步。
// 多行赋值语句，就必须保证是同步操作
public class TSTowLockThread {
    public static void main(String[] args)throws InterruptedException{
        var ts = new Thread[]{new AddStudentThread(),new DecStudentThread(),new AddTeacherThread(),new DecTeacherThread()};
        for (var t:ts){
            t.start();
        }
        for (var t:ts){
            t.join();
        }
        System.out.println(Counter.studentCounter);
        System.out.println(Counter.teacherCounter);
    }
}
class Counter{
    public static final Object lockStudent = new Object();
    public static final Object lockTeacher = new Object();
    public static int studentCounter = 0;
    public static int teacherCounter = 0;
}
class AddStudentThread extends Thread{
    public void run(){
        for (int i=0;i<1000;i++){
            synchronized (Counter.lockStudent){
                Counter.studentCounter++;
            }
        }
    }
}
class DecStudentThread extends Thread{
    public void run(){
        for(int i=0;i<1000;i++){
            synchronized (Counter.lockStudent){
                Counter.studentCounter--;
            }
        }
    }
}
class AddTeacherThread extends Thread{
    public void run(){
        for(int i=0;i<1000;i++){
            synchronized (Counter.lockTeacher){
                Counter.teacherCounter++;
            }
        }
    }
}
class DecTeacherThread extends Thread{
    public void run(){
        for(int i=0;i<1000;i++){
            synchronized (Counter.lockTeacher){
                Counter.teacherCounter--;
            }
        }
    }
}
