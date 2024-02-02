package level2;
/**
 * N개의 최소공배수
 */
public class LeastCommonMultiple {
    public int gcd(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return gcd(num2, num1%num2);
    }
    public int solution(int[] arr) {
        int answer = 0;
        if (arr.length == 1) {
            return arr[0];
        }

        int gcd = gcd(arr[0], arr[1]);
        int lcm = (arr[0] * arr[1]) / gcd;

        for (int i = 2; i < arr.length; i++) {
            gcd = gcd(lcm, arr[i]);
            lcm = (lcm * arr[i]) / gcd;
        }
        answer = lcm;
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new LeastCommonMultiple().solution(new int[]{2,6,8,14}));
    }
}
