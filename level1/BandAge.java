package level1;

import java.util.*;
import java.util.stream.*;;

public class BandAge {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int curHealth = health;

        Map<Integer, Integer> attackMap = IntStream.range(0, attacks.length)
        .boxed()
        .collect(Collectors.toMap(
            i -> attacks[i][0],
            i -> attacks[i][1]
        ));

        int maxTime = attacks[attacks.length-1][0];
        
        for (int i=1,time=0; i<=maxTime;i++){
            if (curHealth <= 0) break;
            if (!attackMap.containsKey(i)){
                curHealth += bandage[1];
                time++;
                if (time == bandage[0]){
                    curHealth += bandage[2];
                    time=0;
                }
                if (curHealth > health) curHealth = health;
            }else{
                curHealth -= attackMap.get(i);
                time=0;
            }
        }
        
        if (curHealth<=0) answer = -1;
        else answer = curHealth;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new BandAge().solution(new int[]{5, 1, 5}, 30, new int[][]{{2, 10}, {9, 15}, {10, 5}, {11, 5}}));
        System.out.println(new BandAge().solution(new int[]{3, 2, 7}, 20, new int[][]{{1, 15}, {5, 16}, {8, 6}}));
    }
}
