package level2;

import java.util.*;

/**
 * 괄호 회전하기
 */
public class BucketMove {
    public boolean isOK(String[] array){
        Stack<String> stack = new Stack<>();
        for(String bucket : array){            
            if(bucket.equals("{") || bucket.equals("(") || bucket.equals("[")){
                stack.add(bucket);
            }else{
                if (stack.size() == 0) return false;

                String peek = stack.peek();
                if (peek.equals("(") && !bucket.equals(")")) return false;
                else if (peek.equals("{") && !bucket.equals("}")) return false;
                else if (peek.equals("[") && !bucket.equals("]")) return false;
                else stack.pop();
            }
        }
        if(stack.size()!=0) return false;
        return true;
    }
    public int solution(String s) {
        int answer = 0;
        String[] array = s.split("");
        
        for (int i=0; i<array.length; i++){
            
            if(isOK(array)) {
                answer++;
            }

            String first = array[0];
            for (int j=1; j<array.length; j++){
                array[j-1] = array[j];
            }
            array[array.length-1] = first;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new BucketMove().solution("[](){}"));
        System.out.println(new BucketMove().solution("}]()[{"));
        System.out.println(new BucketMove().solution("[)(]"));
        System.out.println(new BucketMove().solution("}}}"));
        System.out.println(new BucketMove().solution("{{}([])"));
    }
}
