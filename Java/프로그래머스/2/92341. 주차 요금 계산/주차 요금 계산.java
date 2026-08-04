import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {        
        // 차량번호, <In 시간, 누적값>
        Map<String, Integer> timeMap = new HashMap<>();   // 차량번호 -> 입차 시
        Map<String, Integer> totalMap  = new TreeMap<>();   // 차량번호 -> 누적 시간
        
        for(int i=0;  i<records.length; i++){
            String[] str = records[i].split(" ");
            int time = toMinute(str[0]); // 분으로 바꿔서 저장
            String car = str[1];

            if (str[2].equals("IN")) {
                timeMap.put(car, time);
            } 
            else { // out 일때 
                int in = timeMap.remove(car);              // 꺼내면서 제거
                int gap = time - in; // 출차 - 입차
                totalMap.put(car, totalMap.getOrDefault(car, 0) + gap); // gap 더하기
            }
        }
        
        // 남아있는 = 미출차 -> 23:59 출차 처리
        // timeMap 돌면서 해당 키의 time(Value) 뽑고 (23 * 60 + 59) - time 해서
        // totalMap.put 해야 함
        for (Map.Entry<String, Integer> e : timeMap.entrySet()) {
            String car = e.getKey();
            int gap = (23 * 60 + 59) - e.getValue();
            totalMap.put(car, totalMap.getOrDefault(car, 0) + gap);
        }
        
        // 요금 계산 (TreeMap이라 차량번호 오름차순 보장)
        List<Integer> answer = new ArrayList<>();
        for (int total : totalMap.values()) {
            answer.add(calcFee(total, fees));
        }

        return answer.stream().mapToInt(i->i).toArray();
    }
    
    // 분으로 바꿔서 계산
    // 시 : 분 -> 시간 떼어내서 시 * 60 + 분
    public int toMinute(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
    
    // 요금정산 로직
    public int calcFee(int total, int[] fees) {
        int baseTime = fees[0], baseFee = fees[1];
        int unitTime = fees[2], unitFee = fees[3];

        if (total <= baseTime) return baseFee;

        int over = total - baseTime;
        int units = (over + unitTime - 1) / unitTime;  // 올림
        return baseFee + units * unitFee;
    }
}