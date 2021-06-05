package no894AllPossibleFummBinaryTrees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Yuyuan Huang
 * @create 2021-06-05 11:23
 */
public class Solution {
    //缓存函数FBT之前的结果，
    Map<Integer,List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        //若不包含
        if (!memo.containsKey(n)){
            List<TreeNode> ans = new LinkedList<>();
            if (n==1){
                ans.add(new TreeNode(0));
            }else if (n%2==1){
                for (int i = 0; i < n; i++) {
                    int y = n-1-i;
                    for (TreeNode left:allPossibleFBT(i)){
                        for (TreeNode right:allPossibleFBT(y)){
                            TreeNode bns = new TreeNode(0);
                            bns.left=left;
                            bns.right=right;
                            ans.add(bns);
                        }

                    }
                }
            }
            memo.put(n,ans);
        }
        return memo.get(n);

    }
}
class MySolution{
    HashMap<Integer,List<TreeNode>> memo = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> list = new LinkedList<>();
        if (!memo.containsKey(n)){
            if (n==1){
                list.add(new TreeNode(0));
            }else if (n%2==1){
                for (int i = 0; i < n; i++) {
                    int j = n-i-1;
                    for (TreeNode left:allPossibleFBT(i)){
                        for (TreeNode right:allPossibleFBT(j)){
                            TreeNode node = new TreeNode(0);
                            node.left=left;
                            node.right = right;
                            list.add(node);
                        }
                    }

                }
            }
            memo.put(n,list);
        }
        return memo.get(n);
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