package level2;

/**
 * 2017 팁스타운(짝지어 제거하기)
 */
import java.util.*;
public class MachedRemove {
    public int solution(String s){
        int answer = -1;
 
        Stack<String> stack = new Stack<>();
        for (String tmp : s.split("")){
            if (stack.size() > 0){
                String peek = stack.peek();
                if (peek.equals(tmp)){
                    stack.pop();
                    continue;
                }
            }
            stack.push(tmp);
            
        }
        if (stack.size() == 0) answer = 1;
        else answer =0;
        
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new MachedRemove().solution("baabaa"));
        System.out.println(new MachedRemove().solution("cdcd"));
        System.out.println(new MachedRemove().solution("aab"));
    }
}
