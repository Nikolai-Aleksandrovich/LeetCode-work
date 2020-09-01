import java.util.ArrayList;
import java.util.List;
//两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
//
//给出两个整数 x 和 y，计算它们之间的汉明距离。

public class Solution {
    public int hammingDistance(int x, int y) {
        //使用布莱恩科尼根算法，n与n-1AND运算，会移除最右边的1
        int XOR = x^y;
        int count = 0;
        while(XOR!=0){
            XOR=XOR&XOR-1;
            count++;
        }
        return count;
//        //位移之后不断count+1
//        int count = 0;
//        int XOR = x^y;
//        while(XOR!=0){
//            if(XOR%2==1){
//                count++;
//            }
//            XOR=XOR>>1;
//        }
//        return count;
    }


}
