package level1.kakao;

import java.util.*;
import java.util.stream.*;
public class PrivacyPolicy {
    public int dateToday(String date){
        int year = Integer.parseInt(date.split("\\.")[0]);
        int month = Integer.parseInt(date.split("\\.")[1]);
        int day = Integer.parseInt(date.split("\\.")[2]);

        return (year - 2000) * (12*28) + (month-1) * 28 + (day-1);
    }
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
    
        Map<String, Integer> termsMap = IntStream.range(0, terms.length)
        .boxed()
        .collect(Collectors.toMap(
            i -> terms[i].split(" ")[0],
            i -> Integer.parseInt(terms[i].split(" ")[1]) * 28
        ));

        List<Integer> list = new ArrayList<>();
        for (int i=0; i<privacies.length; i++){
            String date = privacies[i].split(" ")[0];
            String policy = privacies[i].split(" ")[1];

            int privacy = termsMap.get(policy);
            int subDay = dateToday(today) - dateToday(date);
            
            if (subDay >= privacy){
                list.add(i+1);
            }
        }
        answer = list.stream().mapToInt(Integer::intValue).toArray();
    
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PrivacyPolicy().solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"})));
        System.out.println(Arrays.toString(new PrivacyPolicy().solution("2020.01.01", new String[]{"Z 3", "D 5"}, new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"})));
    }
}
