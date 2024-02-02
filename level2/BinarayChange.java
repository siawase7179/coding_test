package level2;

/**
 * 월간 코드 챌린지 시즌1(이진 변환 반복하기)
 */
import java.util.*;
public class BinarayChange {
    int removeCount= 0;
    public int remove(String s){
        
        String result="";
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == '0'){
                removeCount++;
            }else{
                result += s.charAt(i);
            }
        }
        
        return result.length();
    }
    public int[] solution(String s) {
        int[] answer = new int[2];      
        int tmp =0 ;
        int count=1;
        tmp = remove(s);
        
        while(true){
            if (tmp==1) break;
            tmp = remove(Integer.toBinaryString(tmp));
            count ++;
        }
        answer[0] = count;
        answer[1] = removeCount;
        
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new BinarayChange().solution("110010101001")));
    }
}
