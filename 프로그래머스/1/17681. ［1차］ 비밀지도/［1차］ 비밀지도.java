class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String binaryString = Integer.toBinaryString(arr1[i] | arr2[i]);

            String mapRow = binaryString.replace('1', '#').replace('0', ' ');

            while (mapRow.length() < n) {
                mapRow = " " + mapRow;
            }
            
            answer[i] = mapRow;
        }
        return answer;
    }
}