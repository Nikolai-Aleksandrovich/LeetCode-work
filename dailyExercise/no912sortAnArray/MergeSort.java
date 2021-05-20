package no912sortAnArray;

/**
 * @author Yuyuan Huang
 * @create 2021-05-20 15:11
 */
public class MergeSort {
    private static int[] aux;
    public int[] sort(int[] nums){
        aux = new int[nums.length];
        sortAndDivide(nums,0, nums.length-1);
        return nums;

    }
    public void sortAndDivide(int[] nums, int left, int right){
        if (right<=left){
            return;
        }
        int mid = (right+left)/2;
        sortAndDivide(nums,left,mid);
        sortAndDivide(nums,mid+1,right);
        merge3(nums,left,mid,right);
    }
    public void merge3(int[] nums, int left, int mid, int right){
        int i = left;
        int j = mid+1;

        for (int k = left; k <= right; k++) {
            aux[k] = nums[k];
        }
        for (int k = left; k <= right; k++) {
            if (i>mid){
                nums[k]= aux[j++];
            }else if(j>right){
                nums[k] = aux[i++];
            }else if (aux[i]<aux[j]){
                nums[k] = aux[i++];
            }else {
                nums[k] = aux[j++];
            }
        }


    }
}
class MyMergeSort{
    private static int[] aux;
    public int[] sortArray(int[] nums){

        int length =  nums.length;
        aux = new int[length];
        sort(nums,0,length-1);
        return nums;

    }
    public void sort(int[] nums,int left,int right){
        if (right<=left){
            return;
        }
        int length = nums.length;
        int mid = (right+left)/2;
        sort(nums,left,mid);
        sort(nums,mid+1,right);
        mergeAndSort(nums,left,mid,right);

    }
    public void mergeAndSort(int[] nums,int left,int mid,int right){
        int i = left;
        int j = mid+1;
        for (int k = left; k < right+1; k++) {
            aux[k] = nums[k];
        }
        for (int k = left; k < right+1; k++) {
            if (i>mid){
                nums[k] = aux[j++];
            }else if (j>right){
                nums[k] = aux[i++];
            }else if (aux[i]<aux[j]){
                nums[k] = aux[i];
            }else {
                nums[k] = aux[j];
            }
        }

    }


}
class MergeAndSort{
    private static int[] aux;
    public int[] sortArray(int[] nums){
        int n = nums.length;
        aux = new int[n];
        for (int sz = 1; sz < n; sz=sz+sz) {
            for (int left = 0; left < n-sz; left=sz+sz+left) {
                merge4(nums,left,left+sz-1,Math.min(left+sz+sz-1,n-1));
            }
        }
    }
    public void merge4(int[] nums,int left,int mid,int right){
        int i = left;
        int j = mid+1;
        for (int k = left; k < right+1; k++) {
            aux[k] = nums[k];
        }
        for (int k = left; k < right+1; k++) {
            if (i>mid){
                nums[k] = aux[j++];
            }else if (j>right){
                nums[k] = aux[i++];
            }else if (aux[i]<aux[j]){
                nums[k] = aux[i];
            }else {
                nums[k] = aux[j];
            }
        }

    }
}
