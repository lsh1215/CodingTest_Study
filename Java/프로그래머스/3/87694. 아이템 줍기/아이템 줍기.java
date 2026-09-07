import java.util.*;

class Solution {

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static boolean[][] boxed;
    public static boolean[][] line;
    public static boolean[][] outline;
    public static boolean[][] visited;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        boxed = new boolean[102][102];
        line = new boolean[102][102];
        outline = new boolean[102][102];
        visited = new boolean[102][102];

        int maxX = 0;
        int maxY = 0;

        for (int i = 0; i < rectangle.length; i++) {

            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;

            maxX = Math.max(maxX, x2);
            maxY = Math.max(maxY, y2);

            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {

                    if (x == x1 || x == x2 || y == y1 || y == y2) {
                        line[x][y] = true;
                        continue;
                    }

                    boxed[x][y] = true;
                }
            }
        }

        for (int x = 0; x <= maxX; x++) {
            for (int y = 0; y <= maxY; y++) {

                if (line[x][y] && !boxed[x][y]) {
                    outline[x][y] = true;
                }
            }
        }

        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;

        return bfs(characterX, characterY, itemX, itemY) / 2;
    }

    public int bfs(int charX, int charY, int itemX, int itemY) {

        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{charX, charY, 0});
        visited[charX][charY] = true;

        while (!queue.isEmpty()) {

            int[] cur = queue.poll();

            int x = cur[0];
            int y = cur[1];
            int distance = cur[2];

            if (x == itemX && y == itemY) {
                return distance;
            }

            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= 102 || ny < 0 || ny >= 102) {
                    continue;
                }

                if (!outline[nx][ny] || visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, distance + 1});
            }
        }

        return -1;
    }
}