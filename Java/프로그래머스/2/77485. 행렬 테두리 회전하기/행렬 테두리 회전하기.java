import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        List<Integer> answer = new ArrayList<>();
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                matrix[i][j] = j + 1 + i * columns;

        for (int[] query : queries) {
            int y1 = query[0] - 1;  // 행
            int x1 = query[1] - 1;  // 열
            int y2 = query[2] - 1;
            int x2 = query[3] - 1;

            int current, min = Integer.MAX_VALUE;
            int tmp = matrix[y1 + 1][x1];   // 왼쪽 위로 올라올 값

            for (int i = x1; i <= x2; i++) {        // 상: 좌 -> 우
                current = matrix[y1][i];
                matrix[y1][i] = tmp;
                tmp = current;
                min = Math.min(min, current);
            }
            for (int i = y1+1; i <= y2; i++) {    // 우: 상 -> 하
                current = matrix[i][x2];
                matrix[i][x2] = tmp;
                tmp = current;
                min = Math.min(min, current);
            }
            for (int i = x2-1; i >= x1; i--) {    // 하: 우 -> 좌
                current = matrix[y2][i];
                matrix[y2][i] = tmp;
                tmp = current;
                min = Math.min(min, current);
            }
            for (int i = y2-1; i > y1; i--) {     // 좌: 하 -> 상
                current = matrix[i][x1];
                matrix[i][x1] = tmp;
                tmp = current;
                min = Math.min(min, current);
            }

            answer.add(min);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}