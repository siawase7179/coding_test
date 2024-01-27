package level1.kakao;

import java.util.*;
import java.util.stream.*;

public class DeclarationReport {
   
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        answer = new int[id_list.length];
        List<String> reportList = Arrays.stream(report).distinct().collect(Collectors.toList());

        Map<String, Integer> declarUserMap = IntStream.range(0, id_list.length)
            .boxed()
            .collect(Collectors.toMap(
                i -> id_list[i],
                i -> 0
            ));
        
        Map<String, List<String>> userInfo = new LinkedHashMap<>();
        for(String id: id_list){
            userInfo.put(id, new ArrayList<>());
        }

        for (String reportInfo : reportList){
            String user = reportInfo.split(" ")[0];
            String declarUser = reportInfo.split(" ")[1];
            
            userInfo.get(user).add(declarUser);
            declarUserMap.compute(declarUser, (key, value) -> value + 1);
        }
        
        
        Set<String> stopUser = new HashSet<>();
        for (String name : userInfo.keySet()){
            if (declarUserMap.get(name) >=k){
                stopUser.add(name);
            }
        }
        int idx=0;
        for (String user : userInfo.keySet()){
            for (String declarUserName : userInfo.get(user)){
                if(stopUser.contains(declarUserName)){
                    answer[idx]++;
                }
            }
            idx++;
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DeclarationReport().solution(
            new String[]{"muzi", "frodo", "apeach", "neo"},
            new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},
            2)));
        System.out.println(Arrays.toString(new DeclarationReport().solution(
            new String[]{"con", "ryan"},
            new String[]{"ryan con", "ryan con", "ryan con", "ryan con"},
            3)));
            
    }
}
