package level2;

/**
 * 올바른 괄호
 */
public class Braces {
    boolean solution(String s) {
        boolean answer = true;
        int count=0;
        for (char brace : s.toCharArray()){
            if (brace == '('){
                count++;
            }else{
                if (count ==0) return false;
                count--;
            }
        }
        if (count != 0) answer =false;

        /* Stack<String> stack = new Stack<>();
        for (String brace : s.split("")){
            if (brace.equals("(")){
                stack.add(brace);
            }else{
                if (stack.size() ==0) return false;
                stack.pop();
            }
        }
        if (stack.size()>0){
            answer =false;
        } */

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new Braces().solution("()()"));
        System.out.println(new Braces().solution("(())()"));
        System.out.println(new Braces().solution(")()("));
        System.out.println(new Braces().solution("(()("));

    }
}
