package level1;

import java.util.*;
public class DulPassword {
    Map<Character, Integer> skipMap = new HashMap<>();

    public boolean check(char ch){
        return skipMap.containsKey(ch);
    }
    public String solution(String s, String skip, int index) {
        String answer = "";

        for (int i=0; i<skip.length(); i++){
            skipMap.put(skip.charAt(i), i);
        }
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            char next='a';
            int j=0;
            int ascii = ((int)ch);
            while(j < index){
                next = (char)(++ascii);
                if (ascii > (int)'z'){
                    ascii = ((int)'a')-1;
                    continue;
                }

                if(!check(next)){
                    j++;
                }
            }
            answer += next;
            
        }
        
        return answer;
    }

    public static void main(String[] args){
        String s="aukksz";
        String skip="wbqd";
        int index = 5;

        System.out.println(new DulPassword().solution(s, skip, index));
    }
}
