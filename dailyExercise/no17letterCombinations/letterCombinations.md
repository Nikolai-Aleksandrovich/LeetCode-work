## Algorithm

#### [17. 电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)

### Description

给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

```
输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
```

### Solution

```java
public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(2,"abc");
        hashMap.put(3,"def");
        hashMap.put(4,"ghi");
        hashMap.put(5,"jkl");
        hashMap.put(6,"mno");
        hashMap.put(7,"pqrs");
        hashMap.put(8,"tuv");
        hashMap.put(9,"wxyz");
        backTracer(ans,digits,0,new StringBuilder(),hashMap);
        return ans;

    }
    private void backTracer(List<String> list,String digits,int index,StringBuilder stringBuilder,HashMap<Integer,String> hashMap){
        if(index == digits.length()){
            list.add(stringBuilder.toString());
        }else {
            String currentString = hashMap.get((int)digits.charAt(index));
            int length = currentString.length();
            for (int i = 0; i < length; i++) {
                stringBuilder.append(currentString.charAt(i));
                backTracer(list,digits,index+1,stringBuilder,hashMap);
                stringBuilder.deleteCharAt(index);
            }

        }

    }
```

### Discuss

#### 思路：

回溯过程中维护一个字符串，表示已有的字母排列（如果未遍历完电话号码的所有数字，则已有的字母排列是不完整的）。该字符串初始为空。每次取电话号码的一位数字，从哈希表中获得该数字对应的所有可能的字母，并将其中的一个字母插入到已有的字母排列后面，然后继续处理电话号码的后一位数字，直到处理完电话号码中的所有数字，即得到一个完整的字母排列。然后进行回退操作，遍历其余的字母排列。

先把每种映射放入hashmap中，然后递归。

递归终止条件：构建的字符串长度等于输入字符长度

未终止则执行：从哈希表中取出String，for循环将字符一一放入，进行下一层递归，当返回本层再删除重放，放完再到上一层。

## Review

## Tip

## Share