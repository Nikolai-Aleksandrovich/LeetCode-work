package no988SmallestStringStartingFromLeaf;

import java.util.Map;

/**
 * @author Yuyuan Huang
 * @create 2021-06-11 18:12
 */
public class Solution {
    String ans = "z";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root,new StringBuilder());
        return ans;

    }
    public void dfs(TreeNode node,StringBuilder sb){
        if (node==null){
            return;
        }
        sb.append((char)('a'+node.val));
        if (node.left==null&&node.right==null){
            sb.reverse();
            String s = sb.toString();
            sb.reverse();
            if (s.compareTo(ans)<0){
                ans=s;
            }

        }
        dfs(node.left,sb);
        dfs(node.right,sb);
        sb.deleteCharAt(sb.length()-1);
    }
}
class MySolution{
    String ans = "~";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root,new StringBuilder());
        return ans;
    }
    public void dfs(TreeNode node,StringBuilder sb){
        if (node!=null){
            sb.append((char)('a'+node.val));
            if (node.left==null&&node.right==null){
                sb.reverse();
                String s = sb.toString();
                sb.reverse();
                if (s.compareTo(ans)<0){
                    ans = s;
                }
            }
            dfs(node.left,sb);
            dfs(node.right,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }