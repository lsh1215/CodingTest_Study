import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        int answer = 0;
        Map<String, Integer> cache = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<cities.length; i++){
            String city = cities[i].toLowerCase();
            
            if(cache.get(city) == null){
                if(cache.size() < cacheSize){
                    cache.put(city, i);
                    pq.offer(i);
                    answer+=5;
                }
                else{
                    cache.remove(cities[pq.poll()].toLowerCase());
                    pq.offer(i);
                    cache.put(city, i);
                    answer+=5;
                }
            }
            else{
                pq.remove(cache.get(city));
                pq.offer(i);
                cache.put(city, i);
                answer+=1;
            }
            
        }
        
        
        
        return answer;
    }
}