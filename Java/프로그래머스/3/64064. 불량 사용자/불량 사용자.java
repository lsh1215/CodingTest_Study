import java.util.*;

class Solution {
    static String[] users;
    static String[] banneds;
    static boolean[] visited;
    static Set<Set<String>> result = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        users = user_id;
        banneds = banned_id;
        visited = new boolean[user_id.length];

        dfs(0, new HashSet<>());

        return result.size();
    }

    private void dfs(int index, Set<String> current) {
        if (index == banneds.length) {
            result.add(new HashSet<>(current));
            return;
        }

        String regex = banneds[index].replace('*', '.');

        for (int i = 0; i < users.length; i++) {
            if (visited[i]) 
                continue;
            if (!users[i].matches(regex)) 
                continue;

            visited[i] = true;
            current.add(users[i]);

            dfs(index + 1, current);

            visited[i] = false;
            current.remove(users[i]);
        }
    }
}