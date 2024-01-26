package level1;


public class FreezeIce {
    int[][] visited;
    public int solution(String[] frame){
        int answer = 0;
        visited = new int[frame.length][frame[0].length()];

        for (int x=0; x<frame.length; x++){
            String[] tmp = frame[x].split("");
            for (int y=0; y<tmp.length; y++){
                visited[x][y] = Integer.parseInt(tmp[y]);
            }
        }

        for (int x=0; x<visited.length; x++){
            for (int y=0; y<visited[0].length; y++){
                if(dfs(x, y)){
                    answer++;
                }
            }
        }
        return answer;
    }

    public boolean dfs(int x, int y){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        if(x <= -1 || y <= -1 || x >= visited.length || y >= visited[0].length) return false;

        if (visited[x][y] == 0){
            visited[x][y] = 1;

            for (int i=0; i<4; i++){
                dfs(x+dx[i], y+dy[i]);
            }

            return true;
        }else{
            return false;
        }    
    }
    
    public static void main(String[] args){
        FreezeIce sol = new FreezeIce();
        String []frame = {"00110", "00011", "11111", "00000"};
        System.out.println(sol.solution(frame));
    }
}
