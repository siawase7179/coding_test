package level1;
/**
 * 콜라 문제
 */
public class CokeBottle {
    
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while (n >= a) {
            answer += n / a * b;
            n = (n / a * b) + (n % a);
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new CokeBottle().solution(2, 1, 20));
    }
}
