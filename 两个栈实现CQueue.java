package com.itranswarp.sample;

import java.util.Stack;

class CQueue {
    Stack<Integer> appendStack;//我看答案设置的是两个Dequeue,那是不是犯规了？我用Stack一样可以
    Stack<Integer> deleteStack;//这样设置，而不是写new Stack的原因是可以后边再分配内存

    public CQueue() {
        appendStack = new Stack<>();//这个栈只用来放
        deleteStack = new Stack<>();//这个栈只用来删除头


    }

    public void appendTail(int value) {
        while(!deleteStack.isEmpty()){
            appendStack.push(deleteStack.pop());
        }
        appendStack.push(value);//该放的放进去


    }

    public int deleteHead() {
        while(!appendStack.isEmpty()){//当需要删除的时候，把所有stack1的元素拿到stack2，然后删除屁股，
            deleteStack.push(appendStack.pop());
        }
        if(deleteStack.isEmpty()){//删完了就只能返回-1
            return -1;
        }else {
            return deleteStack.pop();//注意的是，删除队列元素要返回这个被删的元素值
        }

    }
}