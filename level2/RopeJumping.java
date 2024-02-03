package level2;

/**
 * 땅따먹기
 */
public class RopeJumping {
    int solution(int[][] land) {
        int answer = 0;
        
        for (int i=1; i<land.length; i++){
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
        }
        for (int i=0; i<4; i++){
            answer = Math.max(answer, land[land.length-1][i]);
        }
        

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new RopeJumping().solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}}));
        System.out.println(new RopeJumping().solution(new int[][]{{6,7,1,2},{2,3,10,8},{1,3,9,4},{7,11,4,9}}));
        System.out.println(new RopeJumping().solution(new int[][]{{1,2,3,5},{5,6,7,8},{5,6,7,8}}));
        System.out.println(new RopeJumping().solution(new int[][]{{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}}));
    }
}
