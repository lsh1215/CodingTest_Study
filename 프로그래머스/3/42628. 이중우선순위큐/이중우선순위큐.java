import java.util.*;

class Solution {
    public int[] solution(String[] operations) {       
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (String str : operations) {
            String[] strArr = str.split(" ");
            int num = Integer.parseInt(strArr[1]);
            
            if (strArr[0].equals("I")) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else {
                if (map.isEmpty()) {
                    continue;
                }
                
                int keyToRemove = (num > 0) ? map.lastKey() : map.firstKey();
                
                int count = map.get(keyToRemove);
                if (count == 1) {
                    map.remove(keyToRemove);
                } else {
                    map.put(keyToRemove, count - 1);
                }
            }
        }
        
        if (map.isEmpty()) {
            return new int[]{0, 0};
        }
        
        return new int[]{map.lastKey(), map.firstKey()};
    }
}