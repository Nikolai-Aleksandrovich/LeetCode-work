package com.itranswarp.sample;
//可以在add方法中调用dec方法，这样dec方法也要获取锁，每获取一次锁，记录+1，每退出synchronized块，记录-1，减到0的时候，才会真正释放锁。
public class ReEnterableLock {
    private int count = 0;
    private synchronized void add(int n){
        if(n<0){
            dec(-n);
        }else {
            count+=n;
        }
    }
    private synchronized void dec(int n){
        count+=n;
    }
}
class MaybeDeadLock{
    //这样两个线程各自持有不同的锁，然后各自试图获取对方手里的锁，造成了双方无限等待下去
    public void add(int m){
        synchronized (lockA){
            this.value1 += m;
            synchronized (lockB){
                this.value2 += m;
            }
        }
    }
    public void dec(int m){
        synchronized (lockB){
            this.value1 -= m;
            synchronized (lockA){
                this.value -= m;
            }
        }
    }
    //如何避免死锁？线程获取锁的顺序要一致。即严格按照先获取lockA，再获取lockB的顺序

//    public void dec(int m){
//        synchronized (lockA){
//            this.value1 -= m;
//            synchronized (lockB){
//                this.value -= m;
//            }
//        }
//    }
}
