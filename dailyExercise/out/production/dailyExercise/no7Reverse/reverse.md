## Algorithm

#### [7. 整数反转](https://leetcode-cn.com/problems/reverse-integer/)

给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。

假设环境不允许存储 64 位整数（有符号或无符号）。



```
输入：x = 123
输出：321
```

### Solution

```java
class Solution {
    public int reverse(int x) {
        int value = 0;
        while(x!=0){
            int pop = x%10;
             x = x/10;
            if(value>Integer.MAX_VALUE/10 ||(value==Integer.MAX_VALUE/10&&pop>7)){return 0;}
            if(value<Integer.MIN_VALUE/10 || (value==Integer.MIN_VALUE/10&&pop<-8)){return 0;}
            value = value*10+pop;

        }
        return value;

    }
}
```

### Discuss

#### 思路：

* 利用pop = x%10,弹出最后面一位数
* 将值加入value之前，需要检查value是否超出Integer.MAX_VALUE  MIN_VALUE
* 将pop加到value中，但每次都要给value*10



## Review

## Tip



## Share