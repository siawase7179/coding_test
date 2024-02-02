package level2;

/**
 * 귤 고르기
 */
import java.util.*;

public class Tangerine {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> tangerineMap = new HashMap<>();
        for (int i : tangerine){
            tangerineMap.put(i, tangerineMap.getOrDefault(i, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(tangerineMap.values());
        Collections.sort(list, Collections.reverseOrder());

        int sum =0;
        for(int v : list){
            if (sum + v >= k){
                answer++;
                break;
            }else{
                sum += v;
                answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new Tangerine().solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(new Tangerine().solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(new Tangerine().solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
    }
}
