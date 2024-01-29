package level1;

/**
 * 숫자 짝꿍
 */
import java.util.*;
import java.util.stream.*;
public class NumberCouple {
    public String solution(String X, String Y) {
        String answer = "";
        Map<String, Integer> xMap = new HashMap<>();
        Map<String, Integer> yMap = new HashMap<>();

        List<String> list = new ArrayList<>();

        for (String _X : X.split("")){
            xMap.put(_X, xMap.getOrDefault(_X, 0)+1);
        }
       
        for (String _Y : Y.split("")){
            yMap.put(_Y, yMap.getOrDefault(_Y, 0)+1);
        }
        
        for (String key : xMap.keySet()){
            if (!yMap.containsKey(key)) continue;

            int length = Math.min(xMap.get(key), yMap.get(key));
            for(int i = 0; i < length; i++) {
                list.add(key);
            }
        }
        
        answer = list.stream()
            .sorted(Collections.reverseOrder())
            .collect(Collectors.joining());
        
        if(answer.isEmpty()) return "-1";
        if(answer.replaceAll("0", "").isEmpty()) return "0";
        return answer;
    }

    public static void main(String[] argc){
        String X = "100";
        String Y = "1234500";
        System.out.println(new NumberCouple().solution(X, Y));
    }
}
