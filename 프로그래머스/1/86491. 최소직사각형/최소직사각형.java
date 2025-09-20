class Solution {
    public int solution(int[][] sizes) {
        int wMax = 0;
        int hMax = 0;

        for (int i = 0; i < sizes.length; i++) {
            int w = sizes[i][0];
            int h = sizes[i][1];

            sizes[i][0] = Math.max(w, h);
            sizes[i][1] = Math.min(w, h);

            if (sizes[i][0] > wMax) wMax = sizes[i][0];
            if (sizes[i][1] > hMax) hMax = sizes[i][1];
        }

        return wMax * hMax;
    }
}