package level2;

/**
 * 행렬의 곱셈
 */
import java.util.*;
public class MatrixMultiplication {
    /*
     * {1, 4}
     * {3, 2}
     * {4, 1}
     * 
     * {3, 3}
     * {3, 3}
     * 
     * 1(0,0)*3(0,0) + 4(0,1)*3(0,0) = 0,0
     * 1(0,0)*3(0,1) + 4(0,1)*3(0,1) = 0,1
     * 3(1,0)*3(0,0) + 2(1,1)*3(0,0) = 1,1
     * 3(1,0)*3(0,1) + 2(1,1)*3(0,1) = 1,1
     */
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for (int r = 0; r < arr1.length; r++) {
            for (int c = 0; c < arr2[0].length; c++) {
                for (int k = 0; k < arr1[0].length; k++) {
                    answer[r][c] += arr1[r][k] * arr2[k][c];
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new MatrixMultiplication().solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}})));
    }
}
