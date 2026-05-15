import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int length = prices.length;
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<length -1; i++){
            int price = prices[i];
            
            int j=i+1;
            while(true){
                if(prices[j] < price || j>=length-1){
                    list.add(j-i);
                    break;
                }
                j++;
            }
        }
        list.add(0);
        
        return list.stream().mapToInt(i->i).toArray();
    }
}