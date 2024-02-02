package level2;
/*
 * 스택/큐 - 주식가격
 */
import java.util.*;
public class Stock {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();
        
        for (int i=0; i<prices.length; i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
            System.out.println(stack);
        }
        
        while (!stack.isEmpty()) {
			answer[stack.peek()] = prices.length - stack.peek() - 1;
			stack.pop();
		}
        
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Stock().solution(new int[]{1, 2, 3, 2, 3})));
    }
}
