package level1;

/**
 * 옹알이 (2)
 */
public class Babbling {

    public int solution(String[] babbling) {
        int answer = 0;

        for (String tmp : babbling){
            if(tmp.contains("ayaaya") || tmp.contains("yeye") || tmp.contains("woowoo") || tmp.contains("mama")){
                continue;
            }

            tmp = tmp.replace("aya", " ");
            tmp = tmp.replace("ye", " ");
            tmp = tmp.replace("woo", " ");
            tmp = tmp.replace("ma", " ");
            tmp = tmp.replace(" ", "");


            if(tmp.length() == 0){
                answer++;
            }
                
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        System.out.println(new Babbling().solution(babbling));
    }
}
