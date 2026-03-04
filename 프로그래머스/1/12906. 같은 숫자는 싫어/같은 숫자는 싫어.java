import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        
        stack.add(arr[0]);
        list.add(arr[0]);
        
        for(int a : arr){
            if(stack.pop() != a){
                list.add(a);
            }
            stack.add(a);
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}