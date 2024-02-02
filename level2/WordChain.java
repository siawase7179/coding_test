package level2;

/**
 * Summer/Winter Coding(~2018) - 영어 끝말잇기
 */
import java.util.*;

public class WordChain {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> last = new LinkedHashSet<>();

        int count=0;
        boolean endGame = false;
        for (int i=0; i<words.length; i++){
            if (i % n ==0) count++;
            if (last.size() > 0){
                String preWord = last.stream().reduce((first, second) -> second).orElse(null);
                if (preWord.charAt(preWord.length()-1) != words[i].charAt(0) || last.contains(words[i])){
                    answer[0] = (i%n)+1;
                    endGame = true;
                    break;
                }
            }
            last.add(words[i]);
        } 
        if(endGame){
            answer[1]=count;
        }else{
            answer[0]=0;
            answer[1]=0;
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new WordChain().solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
        System.out.println(Arrays.toString(new WordChain().solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
        System.out.println(Arrays.toString(new WordChain().solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));
        
    }
}
