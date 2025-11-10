import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0,0};
        
        Set<String> wset = new HashSet<>();
        
        wset.add(words[0]);
        
        for(int i=1; i<words.length; i++){
            int size = wset.size();
            wset.add(words[i]);
            if(!words[i].startsWith(words[i-1].substring(words[i-1].length() - 1)) | 
              wset.size() == size){
                answer[0] = i%n+1;
                answer[1] = i/n+1;
                break;
            }
        }
        return answer;
    }
}
