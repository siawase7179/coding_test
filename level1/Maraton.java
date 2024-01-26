package level1;

import java.util.*;


public class Maraton {

    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        HashMap<String, Integer> playersMap = new HashMap<>();
        HashMap<Integer, String> rankMap = new HashMap<>();

        for (int i=0; i<players.length; i++){
            playersMap.put(players[i], i);
            rankMap.put(i, players[i]);
        }

        for (String calling : callings){
            int rank = playersMap.get(calling);
            String name = rankMap.get(rank);
            
            String frontName = rankMap.get(rank - 1);

            playersMap.put(name, rank -1);
            playersMap.put(frontName, rank);

            rankMap.put(rank -1, name);
            rankMap.put(rank, frontName);

        }

        Set<Map.Entry<Integer, String>> entrySet = rankMap.entrySet();
        answer = entrySet.stream().map(entry -> entry.getValue()).toArray(String[]::new);
        return answer;
    }

    public static void main (String[] args){
        /* int []array = {1, 2, 5, 6, 3, 7, 9, 8};

        
        System.out.println(Arrays.stream(array)
                            .boxed()
                            .sorted()
                            .collect(Collectors.toList()));

        System.out.println(Arrays.stream(array)
                            .boxed()
                            .sorted(Comparator.reverseOrder())
                            .collect(Collectors.toList())); */
        
        String []players = {"mumu", "soe", "poe", "kai", "mine"};
        String []callings = {"kai", "kai", "mine", "mine"};

        Maraton sol = new Maraton();
        System.out.println(Arrays.toString(sol.solution(players, callings)).toString());
        
    }
}
