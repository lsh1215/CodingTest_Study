import java.util.*;
// 해시맵(참가자, 숫자) 사용
// 1. 해시맵으로 참가자 집어넣기
// 이때 중복되면 value(카운트) 증가
// 2. 완주한 사람 빼기

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }

        for (String name : map.keySet()) {
            if (map.get(name) != 0) {
                return name;
            }
        }

        return "";
    }
}