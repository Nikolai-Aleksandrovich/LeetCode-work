package no685RedunantConnnetcionII;

import java.util.Arrays;

/**
 * @author Yuyuan Huang
 * @create 2021-06-03 11:05
 */
public class Solution {
    int[] parent;
    int[] rank;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int edgesCount = edges.length;
        parent = new int[edgesCount+1];
        rank = new int[edgesCount+1];
        for (int i = 0; i <= edgesCount; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for (int i = 0; i < edgesCount; i++) {
            System.out.println(Arrays.toString(parent));

            int[] element = edges[i];
            int start = element[0];
            int end = element[1];
            System.out.println(find(start));
            System.out.println(find(end));
            if (parent[end]!=end){

            }
            if (find(start)!=find(end)){
                merge(start,end);
            }else {
                return element;
            }

        }
        return new int[0];

    }
    public int find(int index){
        if (parent[index] == index){
            return index;
        }else {
            return find(parent[index]);
        }
    }
    public void merge(int i,int j){

//        int x = rank[find(i)];
//        int y = rank[find(j)];
//        if (x<y){
//            parent[find(i)] = find(j);
//        }else {
//            parent[find(j)]=find(i);
//        }
//        if (x==y&&find(i)!=find(j)){
//            rank[y]++;
//        }
        parent[j]=parent[i];
    }
    public boolean judge(int i,int j,int[][] edges){
        int[] temp = edges[i];

    }
}
