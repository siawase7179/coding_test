package level2;
/**
 * Summer/Winter Coding(~2018) - 스킬트리
 */
public class SkillTree {
    public String removeString(String skill, String target){
        String result="";
        for (int i=0; i< target.length(); i++){
            if(skill.indexOf(target.charAt(i)) != -1){
                result += target.charAt(i);
            }
        }

        return result;

    }
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String tmp : skill_trees){
            String remove = removeString(skill, tmp);
            boolean isOk = true;
            for (int i=0; i<skill.length(); i++){
                if (i > remove.length()-1) break;
                if (remove.charAt(i) != skill.charAt(i)){
                    isOk =false;
                    break;
                }
            }
            if(isOk) answer++;
        }
        
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new SkillTree().solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}
