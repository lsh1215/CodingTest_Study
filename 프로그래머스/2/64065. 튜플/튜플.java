import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        String prg = s.substring(2, s.length() - 2);
        String[] parts = prg.split("\\},\\{");
        
        Set<String> nSet = new HashSet<>();
        List<String> list = new ArrayList<>();
        
        Arrays.sort(parts, (s1, s2) -> s1.length() - s2.length());
        
        for(int i=0; i<parts.length; i++){
            String[] strArr = parts[i].split(",");
            for(int j=0; j<i+1; j++){
                int size = nSet.size();
                nSet.add(strArr[j]);
                if(nSet.size() != size){
                    list.add(strArr[j]);
                }
            }
        }
        
        return list.stream().mapToInt(i->Integer.parseInt(i)).toArray();
    }
}