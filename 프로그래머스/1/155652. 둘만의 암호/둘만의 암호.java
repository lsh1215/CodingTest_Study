import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        System.out.println((int) 'a');
        System.out.println((int) 'z');
        
        List<Character> list = new ArrayList<>();
        
        for(int i=97; i<=122; i++){
            list.add((char) i);
        }
        
        char[] skArr = skip.toCharArray();
        Arrays.sort(skArr);
        
        for(int i=0; i<skArr.length; i++){
            list.remove((int) skArr[i] - 97 - i);
        }
        
        char[] sArr = s.toCharArray();
        int listSize = list.size();
        
        for(char c : sArr){
            int currentIdx = list.indexOf(c);
            int newIdx = currentIdx + index;
            
            answer += list.get(newIdx % listSize);
        }
        
        return answer;
    }
}