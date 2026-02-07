import java.util.*;

class Solution {
    static class Song {
        int id;
        int play;
        
        public Song(int id, int play) {
            this.id = id;
            this.play = play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        
        // 장르별 총 재생수
        Map<String, Integer> genreTotalMap = new HashMap<>(); 
        // 장르별 노래 리스트
        Map<String, List<Song>> genreSongMap = new HashMap<>(); 

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            
            genreTotalMap.put(genre, genreTotalMap.getOrDefault(genre, 0) + play);

            if (!genreSongMap.containsKey(genre)) {
                genreSongMap.put(genre, new ArrayList<>());
            }
            genreSongMap.get(genre).add(new Song(i, play));
        }

        List<Map.Entry<String, Integer>> genreList = new ArrayList<>(genreTotalMap.entrySet());
        
        // Value(총 재생수) 기준으로 내림차순 정렬
        Collections.sort(genreList, (o1, o2) -> o2.getValue() - o1.getValue());


        List<Integer> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : genreList) {
            String genre = entry.getKey();
            List<Song> songs = genreSongMap.get(genre);

            // 해당 장르 내 노래 정렬 (문제 조건 적용)
            Collections.sort(songs, (s1, s2) -> {
                if (s1.play == s2.play) {
                    return s1.id - s2.id; 
                }
                return s2.play - s1.play; 
            });

            // 상위 2개 (또는 1개) 뽑기
            int count = 0;
            for (Song s : songs) {
                result.add(s.id);
                count++;
                if (count >= 2) break; 
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}