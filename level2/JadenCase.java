package level2;
public class JadenCase {
    public String solution(String s) {
        String answer = "";
        String[] arrays = s.split(" ");
        for (String words : arrays){
            if(words.length() == 0) {
    			answer += " ";
    		}else{
                answer += words.substring(0, 1).toUpperCase() + words.substring(1, words.length()).toLowerCase();
                answer+=" ";
            }
        }
        if(s.substring(s.length()-1, s.length()).equals(" ")){
    		return answer;
    	}

        return answer.substring(0, answer.length()-1);
    }
    public static void main(String[] args) {
        System.out.println(new JadenCase().solution("3people    unFollowed me"));
    }
}
