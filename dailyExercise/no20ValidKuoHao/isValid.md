## Algorithm

#### [20. 有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)

### Description

给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。左括号必须以正确的顺序闭合。

```
输入：s = "()"
输出：true
```

### Solution

```java
public boolean isValid(String s) {
        if(s.length()%2!=0){
            return false;
        }
        HashMap<Character,Character> hashmap = new HashMap<>();
        hashmap.put(')','(');
        hashmap.put('}','{');
        hashmap.put(']','[');
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(hashmap.containsKey(c)){
                if(stack.isEmpty()||stack.peek()!=hashmap.get(c)){
                    return false;
                }
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
```

### Discuss

#### 思路：

* 括号字符分为两类：打开括号和闭合括号。设置hashmap<闭合括号，打开括号>，每当一个新字符来，判断他是打开括号还是闭合括号

* 如果是打开括号，则放进stack

* 如果是闭合括号，则检查是否为空，是否可合并为整括号并消掉

* 最后有两种情况：全部销完，剩下（（（，不会剩下）））因为）））会直接返回false

* 在最后返回，判断stack为空？

  



## Review

## Tip



## Share