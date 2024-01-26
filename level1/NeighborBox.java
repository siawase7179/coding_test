package level1;

public class NeighborBox {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        String color = board[h][w];
        
        for(int i=0; i<4;i ++){
            if (h+dy[i] <0 || w+dx[i] <0 || h+dy[i]>board.length-1  || w+dx[i]>board[0].length-1){
                continue;
            }
            String match = board[h+dy[i]][w+dx[i]];
            if (color.equals(match)){
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[][] board = {{"yellow", "green", "blue"}, {"yellow", "green", "green"}, {"yellow", "blue", "blue"}};
        int h = 2;
        int w = 2;
        System.out.println(new NeighborBox().solution(board, h, w));
    }
}
