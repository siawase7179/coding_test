package level2;
/*
 * 월간 코드 챌린지 시즌3 - n^2 배열 자르기
 */
import java.util.*;
public class ArraySplit {
    /*
     * 1 2 3
     * 2 2 3
     * 3 3 3
     * -> 1 2 3  2 2 3  3 3 3
     * 
     * 1 2 3 4
     * 2 2 3 4
     * 3 3 3 4
     * 4 4 4 4
     * -> 1 2 3 4  2 2 3 4  3 3 3 4  4 4 4 4
     * 1 2 3 4 5
     * 2 2 3 4 5
     * 3 3 3 4 5
     * 4 4 4 4 5
     * 5 5 5 5 5
     * -> 1 2 3 4 5  2 2 3 4 5  3 3 3 4 5  4 4 4 4 5  5 5 5 5 5
     */
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left) +1];
        int idx = 0;
        for (long i = left; i<=right; i++) {
            long row = i / n + 1;
            long col = i % n + 1;
            answer[idx++] = (int)Math.max(row, col);
        }
        /* for (int i = 0; i < n*n; i++) {
            int row = (i/n)+1;
            int col = (i%n)+1;
            System.out.print(Math.max(row,col)+" ");
        }
        System.out.println(); */
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ArraySplit().solution(3, 2, 5)));
        System.out.println(Arrays.toString(new ArraySplit().solution(4, 7, 14)));
        System.out.println(Arrays.toString(new ArraySplit().solution(5, 2, 5)));
    }
}
