package level1;
/**
 * 폰켓몬
 */
import java.util.*;
import java.util.stream.*;;
public class Phonekemons {
    public int solution(int[] nums) {
        int answer = 0;
        /* int count = nums.length/2;
        Map<Integer, Object> map = new HashMap<>();

        for (int num : nums){
            if (map.size() < count){
                map.put(num, null);
            }
            
        }
        answer = map.size(); */
        answer = Arrays.stream(nums)
                    .boxed()
                    .collect(Collectors.collectingAndThen(Collectors.toSet(),
                            phonekemons -> Integer.min(phonekemons.size(), nums.length / 2)));

        return answer;
    }
    public static void main(String[] args) {
        int[] nums={3,3,3,2,2,4};
        System.out.println(new Phonekemons().solution(nums));
    }
}
