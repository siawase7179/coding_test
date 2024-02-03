package level2.serach;

/*
 * 완전탐색 - 모음사전
 */
import java.util.*;
public class Dictonary {
    
    static int count=0;
    static List<String> list = new ArrayList<>();
    public void dfs(String[] vowels, String word, int depth){
        list.add(word);
        if (depth == 5) return;
        for (int i=0; i<vowels.length; i++)
            dfs(vowels, word + vowels[i], depth+1);

    }
    public int solution(String word) {
        int answer = 0;
        String[] vowels = new String[]{"A", "E", "I", "O", "U"};
        dfs(vowels, "", 0);
        for (int i=0; i<list.size(); i++){
            if(word.equals(list.get(i))){
                answer += i;
                break;
            }
        }
        
        return answer++;
    }
    public static void main(String[] args) {
        System.out.println(new Dictonary().solution("AAAAE"));
    }
}
