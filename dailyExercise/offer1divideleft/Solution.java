package offer1divideleft;

/**
 * @author Yuyuan Huang
 * @create 2021-08-18 0:05
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        //-2^31/ -1 = 2^31 溢出
        if (dividend == 0x80000000 && divisor == -1) {
            return 0x7FFFFFFF;
        }

        int negative = 2;//用于记录正数个数
        //由于负数转为正数 -2^31 -> 2^31 越界，所以采用正数转为负数
        if (dividend > 0) {
            negative--;
            dividend = -dividend;
        }

        if (divisor > 0) {
            negative--;
            divisor = -divisor;
        }

        //计算两个负数相除
        int result = 0;
        while (dividend <= divisor) {
            int value = divisor;//统计减数
            int quotient = 1;//统计商
            while (value > 0xc0000000 && value + value >= dividend) {//value > 0xc0000000 防止value*2溢出
                quotient += quotient;//如果可以用乘法 quotient*=2
                value += value;//如果可以用乘法 value*=2
            }

            result += quotient;
            dividend -= value;
        }
    }


}
