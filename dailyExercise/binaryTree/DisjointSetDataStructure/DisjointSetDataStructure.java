package DisjointSetDataStructure;

/**
 * @author Yuyuan Huang
 * @create 2021-06-02 17:18
 */
public class DisjointSetDataStructure<Key> {
    int[] nums;
    int[] rank;
    public DisjointSetDataStructure(int n){
        nums = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
            rank[i] = 1;
        }
    }
    //一层一层访问父节点，直至根节点（根节点的标志就是父节点是本身）。要判断两个元素是否属于同一个集合，只需要看它们的根节点是否相同即可。
    public int find(int x){
        if (nums[x]==x){
            return x;
        }else {
            nums[x] = find(nums[x]);//父节点设为根节点
            return nums[x];//返回父节点
        }
    }
    public void merge(int i,int j){
        int x = find(i);
        int y = find(j);
        if (rank[x]<rank[y]){
            nums[x] = y;
        }else {
            nums[y] = x;
        }
        if (rank[x]==rank[y]&&x!=y){
            rank[y]++;
        }
    }
}
