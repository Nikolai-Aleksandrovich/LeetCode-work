## Algorithm

#### [22. 括号生成](https://leetcode-cn.com/problems/generate-parentheses/)

数字 `n` 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 **有效的** 括号组合。

```
输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
```

### Solution1

```java
public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backTrace(list,new StringBuilder(),0,0,n);
        return list;

    }
    private void  backTrace(List<String> list,StringBuilder sb,int open,int close,int max){
        if(sb.length()==max*2){
            list.add(sb.toString());
        }
        if(open<max){
            sb.append("(");
            backTrace(list,sb,open+1,close,max);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            sb.append(")");
            backTrace(list,sb,open,close+1,max);
            sb.deleteCharAt(sb.length()-1);
        }
    }
```

### solution2

```
 public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        anyCombination(new char[2*n],0,list);
        return list;

    }
    private void anyCombination(char[] current,int index,List<String> list){
        if(current.length==index){
            if(isValid(current)){
                list.add(new String(current));
            }
        }else {
            current[index] = '(';
            anyCombination(current,index+1,list);
            current[index]=')';
            anyCombination(current,index+1,list);
        }
    }
    private boolean isValid(char[] current){
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance==0;
    }
```



### Discuss

#### 思路：

* 方法一：递归，递归出所有可能的括号的组合，当括号长度满足条件，判断当前是否合规？并加入list
* 方法而：回溯，递归时，以开括号数量作为限制，闭括号的数量也作为限制，这样，可以剪枝一大部分不必要的不合理的组合



## Review

## Tip



## Share