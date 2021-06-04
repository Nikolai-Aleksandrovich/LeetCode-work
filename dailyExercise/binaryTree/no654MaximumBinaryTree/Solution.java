package no654MaximumBinaryTree;

/**
 * @author Yuyuan Huang
 * @create 2021-06-02 11:43
 */
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums,0, nums.length);
    }
    public TreeNode construct(int[] nums,int l,int r){
        if (l==r){
            return null;
        }
        int maxIndex = findMax(nums,l,r);
        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = construct(nums,l,maxIndex);
        node.right = construct(nums,maxIndex+1,r);
        return node;
    }
    private int findMax(int[] nums,int l,int r){
        int tempMaxIndex = l;
        for (int i = l; i < r; i++) {
            if (nums[i]>nums[tempMaxIndex]){
                tempMaxIndex=i;
            }
        }
        return tempMaxIndex;
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