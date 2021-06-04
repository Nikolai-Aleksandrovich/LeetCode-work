package no684redundantConnection;

import java.util.Arrays;

/**
 * @author Yuyuan Huang
 * @create 2021-06-02 16:22
 * 在本问题中, 树指的是一个连通且无环的无向图。
 *
 * 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 *
 * 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
 *
 * 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
在一棵树中，边的数量比节点的数量少 11。如果一棵树有 N 个节点，则这棵树有 N-1 条边。
 */
public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int nodeCount = edges.length;
        int[] parent = new int[nodeCount+1];
        for (int i=1;i<=nodeCount;i++){
            parent[i] =i;
        }
        System.out.println(Arrays.toString(parent));
        for (int i = 0; i < nodeCount; i++) {
            int[] edge = edges[i];
            int node1 = edge[0];
            int node2 = edge[1];

            if (find(parent,node1)!=find(parent,node2)){
                union(parent,node1,node2);
            }else {
                return edge;
            }
        }
        return new int[0];

    }
    public void union(int[] parent,int index1,int index2){
        parent[find(parent,index1)] = find(parent,index2);
    }
    public int find(int[] parent,int index){
        if (parent[index]!=index){
            parent[index] = find(parent,parent[index]);
        }
        return parent[index];

    }
    int[] rank;
    int[] parent;
    public int[] findRedundantConnection1(int[][] edges) {
        int nodeConnectCount = edges.length;
        parent = new int[nodeConnectCount+1];
        rank = new int[nodeConnectCount+1];
        rank[0] = 1;
        for (int i = 1; i <= nodeConnectCount; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        System.out.println(Arrays.toString(parent));
        for (int i = 0; i < nodeConnectCount; i++) {

            int[] element = edges[i];
            System.out.println(Arrays.toString(element));
            int start = element[0];
            int end = element[1];
            if (find1(start)!=find1(end)){
                System.out.println(find1(start));
                System.out.println(find1(end));
                merge1(start,end);
                System.out.println(Arrays.toString(parent));
            }else {
                return element;
            }
        }
        return new int[0];
    }
    public int find1(int index){
        System.out.println(index);
        System.out.println(parent[index]);
        if (parent[index] == index){
            return index;
        }else {
            return find1(parent[index]);
        }

    }
    public void merge1(int i,int j){
        parent[find1(i)] = find1(j);
//        int x = rank[i];
//        int y = rank[j];
//        if (x<y){
//            parent[x] = find1(y);
//        }else {
//            parent[y] = find1(x);
//        }
//        if (x==y&&find1(x)!=find1(y)){
//            rank[y]++;
//        }

    }
}
