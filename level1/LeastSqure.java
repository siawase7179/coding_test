package level1;
/**
 * 완전탐색 - 최소직사각형
 */
public class LeastSqure {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max_width =0, max_height=0;
        for (int i=0; i<sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]){
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
            max_width = Math.max(max_width, sizes[i][0]);
            max_height = Math.max(max_height, sizes[i][1]);
        }
        answer = max_width * max_height;
       
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new LeastSqure().solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
    }
}
