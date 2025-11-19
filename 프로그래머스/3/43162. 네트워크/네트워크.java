import java.util.*;

class Solution {
    static boolean[] visited;
    
    public static void bfs(int x, int[][] computers) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[x] = true;
        queue.offer(x);
        
        while(!queue.isEmpty()){
            int start = queue.poll();
            
            for(int i=0; i<computers.length; i++){
                if(computers[start][i] == 1 && visited[i] == false){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        // boolean[] visited = new boolean[n];
        visited = new boolean[n];
        
        int count = 0;
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                bfs(i, computers);
                count++;
            }
        }
        
        
        return count;
    }
}