import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 1; i <= 26; i++) {
            char alpha = (char)('A' + i - 1);
            map.put(String.valueOf(alpha), i);
        }
        
        for(int i = 0; i < msg.length(); ) {
            int index = 0; 
            
            while(i + index < msg.length() && map.containsKey(msg.substring(i, i + index + 1))) {
                index++;
            }
            
            String w = msg.substring(i, i + index);
            
            list.add(map.get(w));
            
            if(i + index < msg.length()) {
                String c = String.valueOf(msg.charAt(i + index)); 
                map.put(w + c, map.size() + 1);
            }

            i += index;
        }
        
        return list.stream().mapToInt(k -> k).toArray();
    }
}