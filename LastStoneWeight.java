package com.itranswarp.sample;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        int len = stones.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(len,(o1, o2) -> -o1+o2);
        for (int element:stones){
            maxHeap.add(element);
        }
        while (maxHeap.size()>=2){
            Integer firstStone = maxHeap.poll();
            Integer secondStone = maxHeap.poll();
            if(firstStone.equals(secondStone)){
                continue;
            }
            maxHeap.add(firstStone-secondStone);

        }
        if(maxHeap.size()==0){
            return 0;
        }else {
            return maxHeap.poll();
        }
    }
}
