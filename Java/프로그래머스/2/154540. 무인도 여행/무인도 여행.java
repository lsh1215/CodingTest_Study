import java.util.*;

class Solution {
    public static boolean[][] visited;
    public static int[] dx = {1,0,-1,0};
    public static int[] dy = {0,1,0,-1};
    public static int[][] dist;
    
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        int n = maps.length;
        int m = maps[0].length();
        
        dist = new int[n][m];
        visited = new boolean[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(maps[i].charAt(j) == 'X'){
                    dist[i][j] = 0;
                    visited[i][j] = true;
                    continue;
                }
                dist[i][j] = maps[i].charAt(j)-'0';
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j] == true)
                    continue;
                visited[i][j] = true;
                answer.add(bfs(i,j,n,m));       
            }
        }
        if(answer.size() == 0) return new int[]{-1};
        
        Collections.sort(answer);
        
        return answer.stream().mapToInt(i->i).toArray();
    }
    
    public int bfs(int i, int j, int n, int m){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i,j});
        int answer = 0;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int nx = current[1];
            int ny = current[0];
            
            answer += dist[ny][nx];
                
            for(int k=0; k<4; k++){
                int x = nx + dx[k];
                int y = ny + dy[k];
                
                if(x<0 || y<0 || x>=m || y>=n) continue;
                if(visited[y][x] == true) continue;
                
                visited[y][x] = true;
                queue.add(new int[]{y,x});
            }
        }
        return answer;
    }
}