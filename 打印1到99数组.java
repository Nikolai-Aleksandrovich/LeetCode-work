import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] printNumbers(int n) {

        int length = (int)Math.pow(10,n)-1;
        int[] list = new int[length];
        for(int i = 0; i<length;i++){
            list[i]=i+1;
        }


        return list;

    }
}
