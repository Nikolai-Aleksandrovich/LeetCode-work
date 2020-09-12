package com.itranswarp.sample;

public class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int lo = arr[0];
        int hi = arr[arr.length - 1];
        while (lo < hi) {
            int mid = (hi - lo) / 2 + lo;
            if (arr[mid] < arr[mid + 1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }

        }
        return lo;
    }
       /**
        int i = 0;
        while(arr[i]<arr[i+1]){
            i++;
        }
        return i;
    }
        */
        /**for (int i=0;i<arr.length;i++){
            if(arr[i]>=arr[i+1]&&arr[i-1]<=arr[i]){
                return i;
            }

        }
    return 0;
    }*/

}
