import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<Integer> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<chars.length; i++){
            if(map.get(chars[i]) == null){
                list.add(-1);
                map.put(chars[i], i);
            }
            else{
                list.add(i - map.get(chars[i]));
                map.put(chars[i], i);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}