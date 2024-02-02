package level2;
/**
 * 할인 행사
 */

import java.util.*;
import java.util.stream.*;
public class BargainSale {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for (int i=0; i<discount.length; i++){
            Map<String, Integer> wantMap = IntStream.range(0, want.length)
            .boxed()
            .collect(Collectors.toMap(
                k -> want[k],
                k -> number[k]
            ));

            int wantNumber = Arrays.stream(number).sum();

            for (int j=i; j<10+i; j++){
                if (j > discount.length-1) break;
                String _discount = discount[j];
                if (wantMap.containsKey(_discount) && wantMap.get(_discount) != 0){
                    wantMap.put(_discount, wantMap.get(_discount)-1);
                    wantNumber--;
                }

                if (wantNumber == 0){
                    answer++;
                    break;
                }
            }
        }
    
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new BargainSale().solution(new String[]{"banana", "apple", "rice", "pork", "pot"},
        new int[]{3, 2, 2, 2, 1},
        new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));

        System.out.println(new BargainSale().solution(new String[]{"apple"},
        new int[]{10},
        new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}));
    }
}
