package level2;

/**
 * 완전탐색 - 카펫
 */
import java.util.*;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int max = brown + yellow;

        for (int i=3; i<=max; i++){
            int height = i;
            int width = max / height;

            if (width < 3) {
                continue;
            }

            if (width >= height) {
                System.out.println(width+","+height);
                if ((width - 2) * (height - 2) == yellow) {
                    answer[0] = width;
                    answer[1] = height;
                    break;
                }
                
            }
            
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Carpet().solution(10, 2)));
    }
}
