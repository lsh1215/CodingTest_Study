import java.util.*;
// 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
// 
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] counts = new int[N+2];
        
        for(int stage : stages){
            counts[stage]++;
        }
        
        
        int total = stages.length;
        
        List<double[]> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            double rate;
            
            if(total > 0){
                rate = (double)counts[i] / total;
            } else {
                rate = 0;
            }

            list.add(new double[]{i, rate});
            total -= counts[i];
        }

        Collections.sort(list, (a, b) -> {
            if (b[1] == a[1]) {
                return (int) (a[0] - b[0]); 
            }
            return Double.compare(b[1], a[1]); 
        });

        int[] answer = new int[N];
        
        for (int i = 0; i < N; i++) {
            answer[i] = (int) list.get(i)[0];
        }

        return answer;
        
    }
}