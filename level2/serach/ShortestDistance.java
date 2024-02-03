package level2.serach;

/**
 * 깊이/너비 우선 탐색(DFS/BFS) - 게임 맵 최단거리
 */
import java.util.*;
public class ShortestDistance {
    public int bfs(int[][] maps, int[] goal, boolean[][] visited){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]>queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});

        while(!queue.isEmpty()){
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            int count = queue.peek()[2];
            visited[x][y] = true;

            if (x == goal[0] && y == goal[1]){
                return count;
            }

            queue.poll();

            for (int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length  && !visited[nx][ny]){
                    if(maps[nx][ny] == 1){
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, count+1});
                    }
                }
            }
        }

        return -1;
    }
    public int solution(int[][] maps) {
        int answer = 0;
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int[] goal = new int[2];
        
        goal[0] = visited.length-1;
        goal[1] = visited[0].length-1;

        answer = bfs(maps, goal, visited);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new ShortestDistance().solution(new int[][]{
            {1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}
        }));

        System.out.println(new ShortestDistance().solution(new int[][]{
            {1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}
        }));
    }
}
