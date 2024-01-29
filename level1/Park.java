package level1;

/**
 * 공원 산책
 */
import java.util.*;

public class Park {    


    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        answer = new int[2];

        Map<String, List<Integer>> map = new HashMap<>();
        map.put("E", List.of(0, 1));
        map.put("W", List.of(0, -1));
        map.put("N", List.of(-1, 0));
        map.put("S", List.of(1, 0));

        int maxWidth = park[0].length();
        int maxHeight = park.length;

        for (int i=0; i<park.length; i++){
            for (int j=0; j<park[i].length(); j++){
                if (park[i].charAt(j) == 'S'){
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }

        for (String route : routes){
            String d = route.split(" ")[0];
            int pos = Integer.parseInt(route.split(" ")[1]);
            Integer mx=0, my=0;
            boolean fail = false;
            
            for (int i=0; i<pos; i++){
                mx += map.get(d).get(1);
                my += map.get(d).get(0);

                if (answer[1] + mx >= maxWidth || answer[0] +my >= maxHeight){
                    fail = true;
                    break;
                }
                if (answer[1] + mx < 0 || answer[0] + my < 0){
                    fail = true;
                    break;
                }

                if (park[answer[0] + my].charAt(answer[1] + mx) == 'X'){
                    fail = true;
                    break;
                }
            }
            if(!fail){
                answer[0] = answer[0] + my;
                answer[1] = answer[1] + mx;
            }
            
        }
        return answer;
    }

    public static void main(String[] args){
        Park sol = new Park();
        String[] park = {"OSO","OOO","OXO","OOO"};
        String[] routes = {"E 2","S 3","W 1"};
        
        System.out.println(Arrays.toString(sol.solution(park, routes)));
    }
}
