package no968BinaryTreeCameras;

/**
 * @author Yuyuan Huang
 * @create 2021-06-07 15:11
 */
public class Solution {
    public int minCameraCover(TreeNode root) {
        int[] array = dfs(root);
        return Math.min(array[0],array[1]);

    }

    public int[] dfs(TreeNode root){
        if (root==null){
            return new int[]{Integer.MAX_VALUE/2,0,0};
        }
        int[] leftArray = dfs(root.left);
        int[] rightArray = dfs(root.right);
        int[] array = new int[3];
        array[0] = leftArray[2] + rightArray[2] + 1;
        array[1] = Math.min(array[0], Math.min(leftArray[0] + rightArray[1],
                rightArray[0] + leftArray[1]));
        array[2] = Math.min(array[0], leftArray[1] + rightArray[1]);
        return array;
    }
    public int[] dfs1(TreeNode root){
        if (root==null){
            return new int[]{Integer.MAX_VALUE/2,0,0};
        }
        int[] array = new int[3];
        int[] left = dfs1(root.left);
        int[] right = dfs1(root.right);
        array[0] = left[2]+right[2]+1;
        array[1] = Math.min(array[0],Math.min(left[0]+right[1],
                left[1]+right[0]));
        array[2] = Math.min(left[1]+right[1],array[0]);
        return array;
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