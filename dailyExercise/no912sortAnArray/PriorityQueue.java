package no912sortAnArray;

/**
 * @author Yuyuan Huang
 * @create 2021-05-20 16:24
 */
public class PriorityQueue<Key extends Comparable<Key>> {
    private Key[] nums; //基于堆的完全二叉树
    private int N = 0;     //0没有使用,N表示长度

    public PriorityQueue(int maxN){
        //为0留下位置
        nums =  (Key[]) new Comparable[maxN+1];
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public void insert(Key value){
        nums[++N] = value;
        swim(N);
    }
    public Key poll(){
        Key ans = nums[1];
        swap(1,N--);
        nums[N+1] = null;
        sink(1);
        return ans;

    }


    private void swap(int i,int j){
        Key temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private boolean less(int a,int b){
        return nums[a].compareTo(nums[b])<0;
    }
    private void swim(int index){
        while(index>1&&less(index/2,index)){
            swap(index,index/2);
            index = index/2;
        }

    }
    private void sink(int index){
        while(2*index<=N){
            int j = 2*index;
            if (j<N&&less(j,j+1)){
                j++;
            }
            if (!less(index,j)){
                break;
            }
            swap(index,j);
            index = j;
        }
    }

}
