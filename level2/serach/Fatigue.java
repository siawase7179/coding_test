package level2.serach;

/**
 * 완전탐색 - 피로도
 */
public class Fatigue {
    boolean[] visited;
    int count =0;
    public void dfs(int depth, int fatigue, int[][]dungeons){
        for (int i=0; i<dungeons.length; i++){
            if (visited[i] || dungeons[i][0] > fatigue){
                continue;
            }
            visited[i] = true;
            dfs(depth+1, fatigue - dungeons[i][1], dungeons);
            visited[i] = false;
        }
        count = Math.max(count, depth);
    }
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return count;
    }
    public static void main(String[] args) {
        System.out.println(new Fatigue().solution(80, new int[][]{{80,20},{50,40},{30,10}}));
        System.out.println(new Fatigue().solution(100, new int[][]{{100,30},{10,10},{90,20}}));
        System.out.println(new Fatigue().solution(100, new int[][]{{1,1},{1,1},{90,20}}));
        System.out.println(new Fatigue().solution(40, new int[][]{{40, 20}, {10, 10}, {10, 10}, {10, 10}, {10, 10}}));
    }
}
