/*
귤을 크기별로 몇개인지
그리고 k는 그래서 몇개 판매할지

그러면 HashMap or 크기가 2인 배열로 각 크기에 맞는 갯수 카운팅
그리고 그 사이즈로 정렬? HashMap이면 Value로 이중배열이면 index 1번째로 
k에서 value값 빼기 -> 0 이하일 때까지
*/
import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int t : tangerine){
            map.put(t,map.getOrDefault(t,0)+1);
        }
        
        List<Integer> counts = new ArrayList<>(map.values());
        
        counts.sort(Comparator.reverseOrder());
        
        for(int c : counts){
            k -= c;
            answer++;
            
            if(k<=0) break;
            
        }
        
        return answer;
    }
}