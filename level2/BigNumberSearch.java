package level2;
/*
 * 뒤에 있는 큰 수 찾기
 */
import java.util.*;
public class BigNumberSearch {
   
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        /* for (int i=0; i<numbers.length; i++){
            int now = numbers[i];
            for (int j=i; j<numbers.length; j++){
                if (numbers[j] > now){
                    answer[i] = numbers[j];
                    break;
                }else if (now == numbers[j]){
                    answer[i] = -1;
                }
                
            }
        } */
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<numbers.length; i++){
            while(!stack.isEmpty()){
                if (numbers[stack.peek()] < numbers[i]){
                    answer[stack.pop()] = numbers[i];
                }else{
                    break;
                }
            }
            stack.add(i);
        }
        while(!stack.isEmpty()) answer[stack.pop()] = -1;
        
        
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new BigNumberSearch().solution(new int[]{2, 3, 3, 5})));
        System.out.println(Arrays.toString(new BigNumberSearch().solution(new int[]{9, 1, 5, 3, 6, 2})));
    }
}
