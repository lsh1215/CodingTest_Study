import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        PriorityQueue<Node> heap = new PriorityQueue<>(
            Comparator.comparing((Node n) -> n.head)
            .thenComparingInt(n -> n.num)
            .thenComparingInt(n -> n.index)
        );
   
        for(int i=0; i<files.length; i++){
            String[] str = files[i].toLowerCase().split("");
            StringBuilder hsb = new StringBuilder();
            StringBuilder nsb = new StringBuilder();
            
            int idx = 0;
            while(!isNumber(str[idx])){
                hsb.append(str[idx]);
                idx+=1;
            }
            
            while(idx < str.length && isNumber(str[idx])){
                nsb.append(str[idx]);
                idx+=1;
            }
            String HEAD = hsb.toString();
            Integer NUM = Integer.parseInt(nsb.toString());
            Node node = new Node(HEAD, NUM, i);
            heap.add(node);
        }
        
        int size = heap.size();
        
        for(int j=0; j<size; j++){
            Integer k = heap.poll().index;
            answer[j] = files[k];
        }
        
        return answer;
    }
    
    private boolean isNumber(String str){
        try{
            Integer.parseInt(str);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}

class Node{
    String head;
    Integer num;
    Integer index;

    public Node(String head, Integer num, Integer index){
        this.head = head;
        this.num = num;
        this.index = index;
    }
}