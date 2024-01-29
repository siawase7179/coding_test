package level1.kakao;

/**
 * 2018 KAKAO BLIND RECRUITMENT - [1차] 다트 게임
 */
public class DartGame {
    
    public int solution(String dartResult) {
        int answer = 0;
        int[] dart = new int[3];
        int idx=-1;
        for (int i=0; i<dartResult.length(); i++){
            char c = dartResult.charAt(i);
            if (c >= '0' && c<= '9'){
                int num = c-'0';
                if (dartResult.charAt(i+1) >= '0' && dartResult.charAt(i+1) <= '9'){
                    num = (num * 10) + (dartResult.charAt(++i) -'0');
                }
                dart[++idx] = num;
            }

            char c2 = dartResult.charAt(++i);
            if (c2 == 'S'){
                dart[idx] = (int)Math.pow(dart[idx], 1);
            }else if (c2 == 'D'){
                dart[idx] = (int)Math.pow(dart[idx], 2);
            }else if (c2 == 'T'){
                dart[idx] = (int)Math.pow(dart[idx], 3);
            }
            
            if (i+1 < dartResult.length()){
                char option = dartResult.charAt(i+1);
                if (option =='*'){
                    i++;
                    dart[idx] = dart[idx] * 2;
                    if (idx > 0)
                        dart[idx-1] = dart[idx-1] * 2;
                }else if (option =='#'){
                    i++;
                    dart[idx] = dart[idx] * -1;
                }
            }            
        }
        
        answer = dart[0] + dart[1] + dart[2];
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new DartGame().solution("1S2D*3T"));
        System.out.println(new DartGame().solution("1D2S#10S"));
        System.out.println(new DartGame().solution("1D2S0T"));
        System.out.println(new DartGame().solution("1S*2T*3S"));
        System.out.println(new DartGame().solution("1D#2S*3S"));
        System.out.println(new DartGame().solution("1T2D3D#"));
        System.out.println(new DartGame().solution("1D2S3T*"));
    }
}
