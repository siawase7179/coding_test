package level1.kakao;

public class RecommandId {
    public static String filterCharacters(String new_id) {
        String regex = "[^0-9a-zA-Z\\-\\_\\.]";
        return new_id.replaceAll(regex, "");
    }
    public String solution(String new_id) {
        String answer = "";
        
        answer = filterCharacters(new_id);
        answer = answer.toLowerCase();
        
        while (true){
            if (answer.contains("..")){
                answer = answer.replace("..", ".");
            }else if (answer.length() < 1){
                answer = "a";
            }else if (answer.charAt(0) == '.'){
                answer = answer.substring(1);
            }else if (answer.charAt(answer.length()-1) == '.'){
                answer = answer.substring(0, answer.length()-1);
            }else if (answer.length() > 15){
                answer = answer.substring(0, 15);
            }else if(answer.length() <= 2){
                answer += answer.charAt(answer.length()-1);
            }else{
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new RecommandId().solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(new RecommandId().solution("z-+.^."));
        System.out.println(new RecommandId().solution("=.="));
        System.out.println(new RecommandId().solution("123_.def"));
        System.out.println(new RecommandId().solution("abcdefghijklmn.p"));
        System.out.println(new RecommandId().solution("!!!!!!!"));
    }
}
