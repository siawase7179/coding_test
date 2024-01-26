package level1.kakao;

import java.util.*;
public class CraneDollMachine {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Queue<Integer>> boardList = new ArrayList<>();
        
        for (int i=0; i<board.length; i++){
            boardList.add(new LinkedList<>());
            for (int j=0; j<board.length; j++){
                if (board[j][i] != 0){
                    boardList.get(i).offer(board[j][i]);
                }
            }
        }
        
        
        Stack<Integer> stack = new Stack<>();
        for (int tmp : moves){
            int move = tmp -1;

            if (boardList.get(move).isEmpty()){
                continue;
            }

            int doll = boardList.get(move).poll();
            
            if (!stack.isEmpty() && stack.peek() == doll){
                stack.pop();
                answer+=2;
            }else{
                stack.add(doll);    
            }
        }
        
        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},
                         {0,0,1,0,3},
                         {0,2,5,0,1},
                         {4,2,4,4,2},
                         {3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(new CraneDollMachine().solution(board, moves));
    }   
}
