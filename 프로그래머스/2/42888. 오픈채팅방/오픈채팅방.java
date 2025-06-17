import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> userMap = new HashMap<>();
        List<String> answer = new ArrayList<>();
        
        for (String r : record) {
            StringTokenizer st = new StringTokenizer(r);
            String command = st.nextToken();
            String uid = st.nextToken();

            if (command.equals("Enter") || command.equals("Change")) {
                userMap.put(uid, st.nextToken());
            }
        }
        
        for (String r : record) {
            StringTokenizer st = new StringTokenizer(r);
            String command = st.nextToken();
            String uid = st.nextToken();

            if (command.equals("Enter")) {
                answer.add(userMap.get(uid) + "님이 들어왔습니다.");
            } else if (command.equals("Leave")) {
                answer.add(userMap.get(uid) + "님이 나갔습니다.");
            }
        }

        
        return answer.toArray(new String[0]);
    }
}