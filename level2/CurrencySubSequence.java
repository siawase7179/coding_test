package level2;

/**
 * 연속 부분 수열 합의 개수
 */
import java.util.*;

public class CurrencySubSequence {
    public int solution(int[] elements) {
        int answer = 0;        

        int start = 1;
        Set<Integer> set = new HashSet<>();
        while(start <= elements.length){
            for (int i=0; i<elements.length; i++){
                int sum =0;
                for (int j=i; j<i+start; j++){
                    sum += elements[j % elements.length];
                }
                set.add(sum);
                // System.out.println(set);
            }
            start++;
        }
        answer = set.size();
        
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new CurrencySubSequence().solution(new int[]{7,9,1,1,4}));
    }
}
