package level1.kakao;

import java.util.*;
import java.util.Map.*;
public class PersonalityTypeTest {
    static class JiPyo{
        Map<String, Integer> map = new HashMap<>();
        public JiPyo(String survey1, String survey2){
            map.put(survey1, 0);
            map.put(survey2, 0);
        }

        public void cal(String survey, int choice){
            String _survey1 = survey.split("")[0];
            String _survey2 = survey.split("")[1];

            switch (choice) {
                case 1:
                    map.put(_survey1, map.get(_survey1) + 3);
                    break;
                case 2:
                    map.put(_survey1, map.get(_survey1) + 2);
                    break;
                case 3:
                    map.put(_survey1, map.get(_survey1) + 1);
                    break;
                case 5:
                    map.put(_survey2, map.get(_survey2) + 1);
                    break;
                case 6:
                    map.put(_survey2, map.get(_survey2) + 2);
                    break;
                case 7:
                    map.put(_survey2, map.get(_survey2) + 3);
                default:
                    break;
            }
        }
        public String getJipyo() {
            Entry<String, Integer> maxEntry = map.entrySet()
                    .stream()
                    .max(Comparator.<Entry<String, Integer>, Integer>comparing(Entry::getValue)
                            .thenComparing(Entry::getKey, Comparator.reverseOrder()))
                    .orElse(null);
    
            return (maxEntry != null) ? maxEntry.getKey() : null;
        }
        public void string(){
            for (String key : map.keySet()){
                System.out.println(key+":"+map.get(key));

            }
            
        }
    }
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        List<JiPyo> list = new ArrayList<>();
        list.add(new JiPyo("R", "T"));
        list.add(new JiPyo("C", "F"));
        list.add(new JiPyo("J", "M"));
        list.add(new JiPyo("A", "N"));

        for (int i=0; i<survey.length; i++){
            JiPyo jipyo;
            if (survey[i].equals("RT") || survey[i].equals("TR")){
                jipyo = list.get(0);
            }else if (survey[i].equals("FC") || survey[i].equals("CF")){
                jipyo = list.get(1);
            }else if (survey[i].equals("MJ") || survey[i].equals("JM")){
                jipyo = list.get(2);
            }else if (survey[i].equals("AN") || survey[i].equals("NA")){
                jipyo = list.get(3);
            }else{
                continue;
            }
            jipyo.cal(survey[i], choices[i]);
        }
        for(JiPyo l : list){
            answer+=l.getJipyo();
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new PersonalityTypeTest().solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
        System.out.println(new PersonalityTypeTest().solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3}));
    }
}
