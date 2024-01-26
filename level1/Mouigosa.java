package level1;

import java.util.*;
import java.util.stream.*;
public class Mouigosa {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[][] student= {{1, 2, 3, 4, 5},{2, 1, 2, 3, 2, 4, 2, 5},{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        answer= new int[3];
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<3; i++){
            list.add(0);
        }

        for (int i=0; i<answers.length; i++){
            list.set(0, student[0][i%5] == answers[i] ? list.get(0)+1 : list.get(0));
            list.set(1, student[1][i%8] == answers[i] ? list.get(1)+1 : list.get(1));
            list.set(2, student[2][i%10] == answers[i] ? list.get(2)+1 : list.get(2));
        }
        int maxValue = list.stream()
                .max(Integer::compare)
                .orElseThrow();

        answer = IntStream.range(0, list.size())
                .filter(i -> list.get(i) == maxValue)
                .boxed()
                .sorted()
                .mapToInt(i -> i + 1)
                .toArray();
       
        return answer;
    }
    public static void main(String[] args) {
        int[] answer = {1,3,2,4,2};
        System.out.println(Arrays.toString(new Mouigosa().solution(answer)));

    }   
}
