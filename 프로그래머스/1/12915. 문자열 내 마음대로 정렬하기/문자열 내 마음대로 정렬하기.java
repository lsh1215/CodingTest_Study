import java.util.*;

class Solution {
    
    public String[] solution(String[] strings, int n) {
        // Arrays.sort(strings);
        
        List<Info> infos = new ArrayList<>();
        
        for(String str : strings){
            infos.add(new Info(n, str));
        }

        Collections.sort(infos); 

        String[] answer = new String[infos.size()];
        for (int i = 0; i < infos.size(); i++) {
            answer[i] = infos.get(i).toString();  
        }
        
        return answer;
    }
    
    class Info implements Comparable<Info> {
        int n;
        char[] values;
        
        public Info(int n, String value){
            this.n = n;
            this.values = value.toCharArray();
        }
        
        @Override
        public int compareTo(Info i){
            if (this.values[n] < i.values[n]) return -1;
            if (this.values[n] > i.values[n]) return 1;
            return String.valueOf(this.values).compareTo(String.valueOf(i.values));
        }

        @Override
        public String toString() {
            return String.valueOf(values);
        }
    }
}
