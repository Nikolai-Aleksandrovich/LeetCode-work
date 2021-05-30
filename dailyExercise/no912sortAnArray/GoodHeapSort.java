package no912sortAnArray;

/**
 * @author Yuyuan Huang
 * @create 2021-05-26 15:59
 */
public class GoodHeapSort {
    int[] heap;
    int N;
    public int[] sortArray(int[] nums){
        heap = new int[nums.length+1];
        for (int i = 1; i < nums.length+1; i++) {
            heap[i] = nums[i-1];
        }
        int N = heap.length;
        for (int i = N/2; i >=1 ; i--) {
            sink(i);
        }
        while (N>1){
            swap(1,N);
            N=N-1;
            sink(1);
        }
        for (int i = 1; i < nums.length+1; i++) {
            nums[i-1] =heap[i] ;
        }
        return nums;

    }
    private void sink(int index){
        while(index*2<=N){
            int j = index*2;
            if (j+1<=N&&less(j,j+1)){
                j=j+1;
            }
            if (!less(index,j)){
                break;
            }
            swap(index,j);
            index = j;
        }
    }
    private void swap(int index1,int index2){
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }
    private boolean less(int index1,int index2){
        return heap[index1]<heap[index2];
    }
}
