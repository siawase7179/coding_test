package level2;

import java.util.*;
public class MachedRemove {
    /* public int remove(String s){
        if (s.length() == 0) return 1;

        for (int i=0; i<s.length()-1; i++){
            if (s.charAt(i) == s.charAt(i+1)){
                String old = String.format("%c%c", s.charAt(i), s.charAt(i+1));
                s = s.replace(old, "");
                return remove(s);
            }   
        }
        
        return 0;
    } */
    public int solution(String s){
        int answer = -1;
        /* if (s.length() <= 0) return 0;
        answer = remove(s);     */

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
