package level2;

import java.util.*;

public class GreateLeastNumber {
    public String solution(String s) {
        String answer = "";
        String[] arrays = s.split(" ");
        String max = Arrays.asList(arrays).stream().max(Comparator.comparingInt(Integer::parseInt)).orElse(null);
        String min = Arrays.asList(arrays).stream().min(Comparator.comparingInt(Integer::parseInt)).orElse(null);
        answer = min +" " + max;
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new GreateLeastNumber().solution("1 2 3 4"));
    }   
}
