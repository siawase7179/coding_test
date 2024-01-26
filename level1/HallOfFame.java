package level1;

import java.util.*;
public class HallOfFame {
    public int[] solution(int k, int[] score) {
        int[] answer = {};
        answer = new int[score.length];
        
        List<Integer> list = new ArrayList<>();
        for (int i =0; i<score.length; i++){
            if (list.size() >= k){
                if (score[i] > list.get(list.size()-1)){
                    list.remove(k-1);
                    list.add(score[i]);
                }
            }else{
                list.add(score[i]);
            }
            list.sort(Comparator.reverseOrder());
            answer[i] = list.get(list.size() - 1);
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new HallOfFame().solution(3, new int[]{10, 100, 20, 150, 1, 100, 200})));
    }   
}
