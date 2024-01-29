package level1;
/**
 * 기사단원의 무기
 */
import java.util.*;
public class GisaDan {
    public int yacksu(int number){
        int count=0;
        for (int i = 1; i * i <= number; i++) {
            if (i * i == number) count++;
            else if (number % i == 0) count += 2;
        }
        return count;
    }
    public int solution(int number, int limit, int power) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for (int i=1; i<=number; i++){
            int mugi = yacksu(i);
            
            if (mugi > limit){
                list.add(power);
            }else{
                list.add(mugi);
            }
        }
        answer = list.stream().reduce(0, Integer::sum);
        return answer;
    }
    
    public static void main(String[] args) {
        System.out.println(new GisaDan().solution(10, 3, 2));
    }
}
