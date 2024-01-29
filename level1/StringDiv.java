package level1;

/**
 * 문자열 나누기
 */
public class StringDiv {
   
    public int solution(String s) {
        int answer = 0;
        int x = s.charAt(0);
        int same = 0;
        int diff = 0;
        
        for (int i=0; i<s.length(); i++){
            if (same == diff){
                answer++;
                x=s.charAt(i);
            }

            if (x == s.charAt(i)) same++;
            else diff++;
        }
        
        return answer;
    }

    public static void main(String[] argc){
        String s = "abracadabra";
        System.out.println(new StringDiv().solution(s));
    }
}
