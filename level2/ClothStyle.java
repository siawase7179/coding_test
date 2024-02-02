package level2;

import java.util.*;
public class ClothStyle {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for (String[] cloth: clothes){
            map.put(cloth[1], map.getOrDefault(cloth[1], 0)+1);
        }
        for(String key : map.keySet()){
            answer *=(map.get(key)+1);
        }
        answer--;

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new ClothStyle().solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(new ClothStyle().solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
    }
}
