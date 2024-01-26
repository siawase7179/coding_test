package level1;

import java.util.*;
import java.util.stream.*;

public class Lottos {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        answer = new int[2];
        Set<Integer> win = IntStream.range(0, win_nums.length)
                                    .boxed()
                                    .map(i -> win_nums[i])
                                    .collect(Collectors.toSet());
        int[] matched = new int[2];
        for (int num :lottos){
            if (win.contains(num)){
                matched[0]++;
                matched[1]++;
            }else{
                if (num == 0){
                    matched[0]++;
                }
            }
        }
        answer[0] = matched[0] < 2 ? 6 : (6 - matched[0])+1;
        answer[1] = matched[1] < 2 ? 6 : (6 - matched[1])+1;
       
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Lottos().solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})));
        System.out.println(Arrays.toString(new Lottos().solution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35})));
    }
}
