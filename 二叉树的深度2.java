import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        LinkedList<TreeNode> queue =new LinkedList<>(){{add(root);}},tmp;
        int count = 0;
        while(!queue.isEmpty()){
            tmp=new LinkedList<>();
            for(TreeNode node:queue){
                if(node.left!=null)tmp.add(node.left);
                if(node.right!=null)tmp.add(node.right);


            }
            queue=tmp;
            count++;

        }
        return count;
    }
}
