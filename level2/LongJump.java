package level2;

/**
 * 멀리 뛰기
 */

public class LongJump {
    public long solution(int n) {
        long answer = 0;
        long[] array = new long [n+2];
        array[0] = 0;
        array[1] = 1;
        array[2] = 2;
        for (int i=3; i<=n; i++){
            array[i] = (array[i-1] % 1234567) + (array[i-2] % 1234567) % 1234567;
        }
        answer = array[n] % 1234567;
        
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new LongJump().solution(3));
        System.out.println(new LongJump().solution(123));
    }
}
