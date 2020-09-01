import javax.swing.tree.TreeNode;

import static sun.swing.MenuItemLayoutHelper.max;

public class Solution {
    public int MaxDepth(TreeNode root){
        if(root==null)return 0;

        return max(MaxDepth(root.right),MaxDepth(root.left)+1);
    }
}
