package no912sortAnArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yuyuan Huang
 * @create 2021-05-25 22:14
 */
public class HeapSort {
    int N = 0;
    List<Integer> heap = new ArrayList<>();
    public int[] sortArray(int[] nums){
        heap.add(0);
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
        }

        N = nums.length;
        for (int i = N/2; i >=1; i--) {
            sink(i);
        }
        while(N>1){
            swap(N--,1);
            sink(1);
        }
        System.out.println(heap);
        for (int i = nums.length; i > 0 ; i--) {
            nums[nums.length-i] = heap.get(i);
        }
        return nums;


    }
    private int delMax(){
        int ans = heap.get(1);
        heap.set(1, heap.get(N));
        N=N-1;
        heap.set(N + 1, null);
        sink(1);

        return ans;
    }
    private void sink(int index){
        while(index*2<= N){

            int j = index*2;

            if (j+1<=N&&less(j+1,j)){

                j++;
            }
            if (less(index,j)){

                break;
            }
            swap(index,j);

            index = j;
        }

    }
    private void swap(int index1,int index2){
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
    private boolean less(int index1,int index2){
        return heap.get(index1) < heap.get(index2);
    }

}
class PriorityQueue1<key extends Comparable<key>>{

    private int N = 0;//堆元素[1,2,,,,N]
    private key[] priorityQueue; //基于堆的完全二叉树

    public PriorityQueue1(int maxLength){
        priorityQueue = (key[]) new Comparable[maxLength+1];
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    public void insert(key value){
        N++;
        priorityQueue[N]= value;
        swim(N);
    }
    public key delMax(){
        key ans = priorityQueue[1];//得到最大元素
        priorityQueue[1] = priorityQueue[N];//将最末尾的换到根节点
        priorityQueue[N]=null;//设置最后一个元素为null
        N=N-1;
        sink(1);
        return ans;
    }

    private void sink(int index){
        //再判断index是否符合条件，再判断是否应该右移指针，再判断是否应该交换，否的话break
        while(index*2<=N){
            int j = index*2;
            if (j+1<=N&&less(j,j+1)){
                j = j+1;
            }
            if (!less(index,j)){
                break;
            }
            swap(j,index);
            index = j;
        }
    }

    private void swim(int index){
        while (index>1&&less(index/2,index)){//当index大于1，而且应该上浮
            swap(index/2,index);
            index = index/2;
        }
    }
    private boolean less(int index1,int index2){
        return priorityQueue[index1].compareTo(priorityQueue[index2]) < 0;
    }
    private void swap(int index1,int index2){
        key temp = priorityQueue[index1];
        priorityQueue[index1] = priorityQueue[index2];
        priorityQueue[index2] = temp;
    }

}
