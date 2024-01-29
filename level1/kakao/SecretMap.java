package level1.kakao;
/**
 * 2018 KAKAO BLIND RECRUITMENT - [1차] 비밀지도
 */
import java.util.*;
public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        answer = new String[n];
        for (int i=0; i<n; i++){
            String binary1 = String.format("%" + n + "s", Integer.toBinaryString(arr1[i])).replace(' ', '0');
            String binary2 = String.format("%" + n + "s", Integer.toBinaryString(arr2[i])).replace(' ', '0');
            String tmp="";
            for (int j=0; j<n ;j++){
                if (binary1.charAt(j) == '1' || binary2.charAt(j) == '1'){
                    tmp += "#";
                }else{
                    tmp += ' ';
                }
            }
           
            answer[i] = tmp;
        }
        return answer;
    }
    public static void main(String[] args) {
        // System.out.println(Arrays.toString(new SecretMap().solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})));
        System.out.println(Arrays.toString(new SecretMap().solution(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10})));
    }
}
