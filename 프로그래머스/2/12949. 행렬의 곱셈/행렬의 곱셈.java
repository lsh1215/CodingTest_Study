class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        System.out.println(arr1.length);
        System.out.println(arr2.length);
        System.out.println(arr1[0].length);
        
        int row = arr1.length;
        int col = arr2[0].length;
        int common = arr2.length;

        int[][] answer = new int[row][col];
        
        // arr1[0][0] * arr2[0][0] + 
        // arr1[0][1] * arr2[1][0] +
        
        // arr1[0][0] * arr2[1][0] + 
        // arr1[0][1] * arr2[1][1] +
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < common; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}