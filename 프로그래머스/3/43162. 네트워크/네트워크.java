import java.util.*;

class Solution {
    public static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int count = 0;
        
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(visited[i] == false){
                bfs(i, computers);
                count++;
            }
        }
        
        return count;
    }
    
    public void bfs(int x, int[][] computers){
        Queue<Integer> queue = new ArrayDeque<>();
        visited[x] = true;
        queue.offer(x);
        
        while(!queue.isEmpty()){
            int start = queue.poll();
            
            for(int j=0; j<computers.length; j++){
                if(computers[start][j] == 1 && visited[j] == false){
                    queue.offer(j);
                    visited[j] = true;
                }
            }
        }
    }
}