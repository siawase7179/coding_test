package level1;

import java.util.*;
public class Fruitjangsu {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        List<Integer> list = Arrays.asList(Arrays.stream(score).boxed().sorted((i, j) -> Integer.compare(j, i)).toArray(Integer[]::new));
        System.out.println(list.toString());
        List<Integer> box = new ArrayList<>(4);

        for (int i=0; i<list.size();i++){
            box.add(list.get(i));
            if (box.size() == m){
                answer += box.get(box.size()-1) * m;
                box.clear();
            }
        }
        
        return answer;
    }
    public static void main(String[] args) {
        int k = 4;
        int m = 3;
        // int[] score={1, 2, 3, 1, 2, 3, 1};
        int[] score={4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};

        System.out.println(new Fruitjangsu().solution(k, m, score));
    }
}
