package level2;
/**
 * 탐욕법(Greedy)-구명보트
 */
import java.util.*;
public class LIftBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);

        int idx=0;
        for(int i=people.length-1; i >=idx; i--){
            if(people[i]+people[idx] <= limit){
                idx++;
            }
            answer++;
        }
        return answer;

    }
    public static void main(String[] args) {
        System.out.println(new LIftBoat().solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(new LIftBoat().solution(new int[]{20, 20, 20, 20}, 150));
    }
    
}
