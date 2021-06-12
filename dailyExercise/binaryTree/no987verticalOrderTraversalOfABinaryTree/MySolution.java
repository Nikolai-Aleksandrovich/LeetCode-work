package no987verticalOrderTraversalOfABinaryTree;


import java.util.*;

/**
 * @author Yuyuan Huang
 * @create 2021-06-08 11:12
 */
public class MySolution {
    List<List<Integer>> list;
    Map<Integer,List<Integer>> map;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root==null){
            return null;
        }
        list = new ArrayList<>();
        map = new HashMap<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Deque<MyNode> deque = new LinkedList<>();
        deque.offerLast(new MyNode(root,0,0));
        while(!deque.isEmpty()){
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                MyNode node = deque.pollFirst();

                if (map.containsKey(node.value)){
                    map.get(node.value).add(node.node.val);
                }else {
                    List<Integer> list = new ArrayList<>();
                    list.add(node.val);
                    map.put(curValue,list);
                }
                if (node.node.left!=null){
                    deque.offerLast(new MyNode(node.node.left,node.level+1,node.value-1));
                }
                if (node.node.right!=null){
                    deque.offerLast(new MyNode(node.node.right,node.level+1,node.value+1));
                }
            }
        }
        dfs(root,0,0);
        for (Integer key:map.keySet()
             ) {
            priorityQueue.offer(key);
        }
        while(!priorityQueue.isEmpty()){
            List<Integer> ans = map.get(priorityQueue.poll());
            Collections.sort(ans);
            list.add(ans);
        }
        return list;

    }
    public void dfs(TreeNode node,int level,int curValue){
        if (node!=null){

            if (map.containsKey(curValue)){
                map.get(curValue).add(node.val);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(node.val);
                map.put(curValue,list);
            }
            dfs(node.left,level+1,curValue-1);
            dfs(node.right,level+1,curValue+1);
        }
    }
}
class MyNode{
    TreeNode node;
    int level;
    int value;
    public MyNode(TreeNode node,int level,int value){
        this.level = level;
        this.node = node;
        this.value = value;
    }
}
class Solution{
    List<Location> locations;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        locations = new ArrayList();
        dfs(root,0,0);
        Collections.sort(locations);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        int prev = locations.get(0).x;
        for (Location loc :
                locations) {
            if (loc.x!=prev){
                prev = loc.x;
                ans.add(new ArrayList<>());}
            ans.get(ans.size()-1).add(loc.val);
        }
        return ans;

    }
    public void dfs(TreeNode node,int x,int y){
        if (node!=null){
            locations.add(new Location(x,y,node.val));
            dfs(node.left,x-1,y+1);
            dfs(node.right,x+1,y+1);
        }

    }
}
class Location implements Comparable<Location>{
    int x,y,val;
    Location(int x,int y,int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
    @Override
    public int compareTo(Location that)
    {
        if (this.x!=that.x){
            return Integer.compare(this.x,that.x);
        }else if (this.y!=that.y){
            return Integer.compare(this.y,that.y);
        }else {
            return Integer.compare(this.val,that.val);
        }
    }

}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }