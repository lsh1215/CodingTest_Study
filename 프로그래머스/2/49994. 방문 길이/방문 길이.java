import java.util.*;

class Solution {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public int solution(String dirs) {
        int answer = 0;
        char[] directions = dirs.toCharArray();
        // 
        Set<String> set = new HashSet<>();
        
        int x = 5, y = 5;  
        int count = 0;
        
        for (char d : directions) {
            int dir = 0;
            
            if (d == 'R') dir = 0;
            else if (d == 'U') dir = 1;
            else if (d == 'L') dir = 2;
            else if (d == 'D') dir = 3;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && nx <= 10 && ny >= 0 && ny <= 10) {
                String path1 = x + "," + y + "," + nx + "," + ny;
                String path2 = nx + "," + ny + "," + x + "," + y;

                if (!set.contains(path1) && !set.contains(path2)) {
                    set.add(path1);
                    set.add(path2);
                    count++;
                }
                x = nx;
                y = ny;
            }
        }
        return count;
    }
}