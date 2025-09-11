import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int length = arr.length;
        
        List<Integer> list = new ArrayList<>(length -1);
        
        if(length == 1) {
            list.add(-1);
            return list.stream().mapToInt(i->i).toArray();
        }
        
        int min = arr[0];
        int flag = 0;
        
        for(int i=1; i<length; i++){
            if(min > arr[i]){
                min = arr[i];
                flag = i;
            }
        }
        
        for(int i=0; i<length; i++){
            if(i != flag){
                list.add(arr[i]);
            }
        }
        
        
        return list.stream().mapToInt(i->i).toArray();
    }
}