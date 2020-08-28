import java.util.HashMap;
import java.util.List;
import java.util.Map;

//给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，其中 paths[i] = [cityAi, cityBi] 表示该线路将会从 cityAi 直接前往 cityBi 。请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
//
//题目数据保证线路图会形成一条不存在循环的线路，因此只会有一个旅行终点站。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/destination-city

public class Solution1 {
    public String destCity(List<List<String>> paths){
        String start = paths.get(0).get(1);
        Map<String,String> map= buildHashMap(paths);
        while(true){
            if (!map.containsKey(start)){
                return start;
            }
            start = map.get(start);

        }





    }
    private Map<String,String> buildHashMap(List<List<String>> paths){
        Map<String,String> map = new HashMap<>();
        for (List<String> path:paths){
            map.put(path.get(0),path.get(1));
        }
        return map;
    }
}
