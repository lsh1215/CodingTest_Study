import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> cMap = new HashMap<>();
        Set<String> nSet = new HashSet<>();
        
        for(int i=0; i<clothes.length; i++){
            String x = clothes[i][1];
            cMap.put(x, cMap.getOrDefault(x, 0) + 1);
            nSet.add(x);
        }
        List<String> myList = new ArrayList<>(nSet);
        
        for(int i=0; i<myList.size(); i++){
            answer *= cMap.get(myList.get(i)) + 1;
        }
        
        return --answer;
    }
}