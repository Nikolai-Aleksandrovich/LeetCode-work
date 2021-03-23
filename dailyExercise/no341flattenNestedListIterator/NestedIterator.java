package no341flattenNestedListIterator;

import java.util.*;

/**
 * @author Yuyuan Huang
 * @create 2021-03-23 10:40
 */
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private Deque<Iterator<NestedInteger>> stack;
    //初始化双端队列，内部存储迭代器，迭代器内部是NI
    public NestedIterator(List<NestedInteger> nestedList){
        stack = new LinkedList<Iterator<NestedInteger>>();
        stack.push(nestedList.iterator());

    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()){
            Iterator<NestedInteger> it = stack.peek();
            if(!it.hasNext()){// 遍历到当前列表末尾，出栈
                stack.pop();
                continue;
            }
            NestedInteger nest = it.next;
            if(nest.isInteger()){
                List<NestedInteger> list = new ArrayList<NestedInteger>();
                list.add(nest);
                stack.push(list.iterator());
                return true;
            }
            stack.push(nest.getList().iterator());
        }
        return false;
    }

    @Override
    public Integer next() {
        return stack.peek().next().getInteger();
    }
}
//    private List<Integer> vals;
//    private Iterator<Integer> cur;
//    public NestedIterator(List<NestedInteger> nestedList){
//        vals = new ArrayList<Integer>();
//        dfs(nestedList);
//        cur = vals.iterator();
//
//    }
//    @Override
//    public boolean hasNext() {
//        return cur.hasNext();
//    }
//
//    @Override
//    public Integer next() {
//        return cur.next();
//    }
//    private void dfs(List<NestedInteger> nestedList){
//        for (NestedInteger nest:nestedList){
//            if(nest.isInteger()){
//                vals.add(nest.getInteger());
//            }else {
//                dfs(nest.getList());
//            }
//        }
//    }
//}
