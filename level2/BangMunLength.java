package level2;
/*
 * Summer/Winter Coding(~2018) - 방문 길이
 */

import java.util.*;
public class BangMunLength {
    class Move{
        int nowX; int nowY;
        int nextX; int nextY;
        public Move(int nowX, int nowY, int nextX, int nextY){
            this.nowX = nowX;
            this.nowY = nowY;
            this.nextX = nextX;
            this.nextY = nextY;
        }

        @Override
        public String toString(){
            return nowX+","+nowY+":"+nextX+","+nextY;
        }
    }
    List<Move> list = new ArrayList<>();
    public boolean check(int nowX, int nowY, int nextX, int nextY){
        for (Move move : list){
            if (move.nextX == nowX && move.nextY == nowY && move.nowX == nextX  && move.nowY == nextY){
                return false;
            }
            if (move.nowX == nowX && move.nowY == nowY && move.nextX == nextX  && move.nextY == nextY){
                return false;
            }
        }
        return true;
    }
    public int solution(String dirs) {
        int answer = 0;
        

        Map<String, int[]> move = new HashMap<>();
        move.put("U", new int[]{0, -1});
        move.put("D", new int[]{0, 1});
        move.put("R", new int[]{1, 0});
        move.put("L", new int[]{-1, 0});

        int nowX=0, nowY=0;
        int nextX=0, nextY=0;

        for (String command : dirs.split("")){
            int moveX = move.get(command)[0];
            int moveY = move.get(command)[1];

            nextX = nowX + moveX;
            nextY = nowY + moveY;

            if (nextX <= 5 && nextX >= -5 && nextY <= 5 && nextY >= -5){
                if (!check(nowX, nowY, nextX, nextY)){
                    nowX = nextX;
                    nowY = nextY;
                    continue;
                }
                list.add(new Move(nowX, nowY, nextX, nextY));

                nowX = nextX;
                nowY = nextY;
            }
        }
        answer=list.size();
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new BangMunLength().solution("ULURRDLLU"));
        System.out.println(new BangMunLength().solution("LULLLLLLU"));
    }
}
