import java.util.*;

class Solution {
    static boolean[] visited;
    static int[] count;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        visited = new boolean[n + 1];
        count = new int[n + 1];
        
        int[] degree = new int[n + 1];
        for (int i = 0; i < edge.length; i++) {
            degree[edge[i][0]]++;
            degree[edge[i][1]]++;
        }
        
        int[][] maps = new int[n + 1][];
        for (int i = 1; i <= n; i++) {
            maps[i] = new int[degree[i]];
        }
        
        int[] index = new int[n + 1];
        for (int i = 0; i < edge.length; i++) {
            int u = edge[i][0];
            int v = edge[i][1];
            
            maps[u][index[u]++] = v;
            maps[v][index[v]++] = u;
        }
        
        bfs(n, maps);

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (count[i] > max) {
                max = count[i];
                answer = 1; 
            } 
            else if (count[i] == max) {
                answer++; 
            }
        }
        
        return answer;
    }
    
    
    public void bfs(int n, int[][] maps) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        visited[1] = true;
        count[1] = 0;
        
        while (!queue.isEmpty()) {
            int start = queue.poll();
            
            for (int i = 0; i < maps[start].length; i++) {
                int next = maps[start][i];
                
                if (visited[next] == false) {
                    queue.offer(next);
                    visited[next] = true;
                    count[next] = count[start] + 1;
                }
            }
        }
    }
}