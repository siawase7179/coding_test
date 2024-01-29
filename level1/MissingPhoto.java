package level1;
/**
 * 추억 점수
 */
import java.util.*;

public class MissingPhoto {

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = {};
        answer = new int[photo.length];

        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<name.length;i++){
            map.put(name[i], yearning[i]);
        }

        for (int i=0; i<photo.length; i++){
            int score=0;
            for (String _name : photo[i]){
                if (map.containsKey(_name)){
                    score += map.get(_name);
                }
            }
            answer[i] = score;
        }
        
        return answer;
    }
    public static void main (String[] args){
        String[] name= {"may", "kein", "kain", "radi"};
        int[] yearning={5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        MissingPhoto sol = new MissingPhoto();
        System.out.println(Arrays.toString(sol.solution(name, yearning, photo)));
    }
}
