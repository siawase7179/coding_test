package level2;

/**
 * 2017 팁스타운 - 예상 대진표
 */
import java.util.stream.*;

public class GameTable {
    int round = 1;
    public void makeTable (int[] array, int n, int a, int b){
        if (n ==1) return;
        int[] new_array = new int[array.length/2];
        int idx =0;
        for (int i=0; i< array.length-1; i+=2){
            if (array[i] == a && array[i+1] ==b || array[i+1] ==a && array[i] ==b) return;

            if (array[i] == a || array[i+1] == a) new_array[idx] = a;
            else if (array[i] == b || array[i+1] == b) new_array[idx] = b;
            else new_array[idx] = array[i];

            idx++;
        }

        round++;
        
        makeTable(new_array, n/2, a, b);
    }
    public int solution(int n, int a, int b){
        int answer = 0;
        int[] array = IntStream.range(1, n + 1).toArray();
        makeTable(array, n, a, b);
        answer = round;
     
        /* while(a!=b){
            a = a%2 == 0 ? a/2 : a/2 +1;
            b = b%2 == 0 ? b/2 : b/2 +1;
            answer++;
        } */

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new GameTable().solution(8, 4, 7));
    }
}
