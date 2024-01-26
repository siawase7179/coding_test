package level1;

import java.util.*;
public class MiroSearch {
    String [][]MIRO;
    
    public int solution(String[] maps) {
        int answer = 0;
        int[] start = new int[2];
        int[] labor = new int[2];
        MIRO = new String[maps.length][maps[0].length()];
        for (int i=0; i<maps.length; i++){
            String[] tmp = maps[i].split("");
            for (int j=0; j<tmp.length; j++){
                MIRO[i][j] = tmp[j];

                if (MIRO[i][j] == "S"){
                    start = new int[]{i, j};
                }

                if (MIRO[i][j] == "L"){
                    labor = new int[]{i, j};
                }
            }
        }
        int result1 = bfs(start, "L");
        if (result1 == -1){
            return -1;
        }
        int result2 = bfs(labor, "E");
        if (result2 == -1){
            return -1;
        }
       
        answer = result2;

        
        return answer;
    }

    public int bfs(int[] start, String target){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]>queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], 0});

        boolean[][] visited = new boolean[MIRO.length][MIRO[0].length];

        while(!queue.isEmpty()){
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            int count = queue.peek()[2];
            visited[x][y] = true;

            if (MIRO[x][y].equals(target)){
                return count;
            }

            queue.poll();

            for (int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if (nx >= 0 && nx < MIRO.length && ny>=0 && ny<MIRO[0].length && !visited[nx][ny]){
                    if(!MIRO[nx][ny].equals("X")){
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, count+1});
                    }
                }
            }
        }
        
        return -1;
    }

    public static void main(String[] args){
        MiroSearch sol = new MiroSearch();
        String[] map = {"SOOOL",
                        "XXXXO",
                        "OOOOO",
                        "OXXXX",
                        "OOOOE"};
        System.out.println(sol.solution(map));
    }
}
