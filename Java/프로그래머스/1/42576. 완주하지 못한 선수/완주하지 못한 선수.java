import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String part : participant){
            map.put(part, map.getOrDefault(part, 0) + 1);
        }
        
        for(String com : completion){
            if(map.get(com) == 1) map.remove(com);
            else map.put(com, map.get(com) -1);
        }
        
        List<String> list = new ArrayList<>(map.keySet());
        return list.get(0);
    }
}