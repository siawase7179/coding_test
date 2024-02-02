package level2;

import java.util.*;
/**
 * 최솟값 만들기
 */
public class MakeMinimumNumber {
    
    public int solution(int []A, int []B){
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        for (int i=0; i<A.length; i++){
            answer += A[i] * B[(B.length-1)-i];
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new MakeMinimumNumber().solution(new int[]{1, 4, 2}, new int[]{5, 4, 4}));
    }
}
