import javax.swing.tree.TreeNode;
import java.util.Arrays;
//给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。


public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
            return null;
        }
        TreeNode root = new TreeNode(nums[nums.length/2]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,nums[nums.length/2]));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums,nums[nums.length/2]+1,nums.length));
        return root;




    }
}
