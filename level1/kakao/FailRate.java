package level1.kakao;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
public class FailRate {

    static class StageInfo{
        public double participant;
        public double failure;
        public double failRate;

        public StageInfo(){
            participant = 0;
            failure = 0;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        answer = new int[N];
        Map<Integer, StageInfo> stageMap = IntStream.rangeClosed(1, N)
        .boxed()
        .collect(Collectors.toMap(
            Function.identity(),
            value -> new StageInfo()
        ));
        

        for (int i=0; i<stages.length; i++){
            int player = stages[i];
            for (int j=1; j<player; j++){
                if(j>=N) break;
                stageMap.get(j).participant++;
            }
            if (player <= N){
                stageMap.get(player).participant++;
                stageMap.get(player).failure++;
            }
        }


        answer = stageMap.entrySet().stream()
                .sorted(Comparator.comparingDouble((Map.Entry<Integer, StageInfo> entry) -> {
                    double failRate =0;
                    if (entry.getValue().participant > 0){
                        failRate = entry.getValue().failure / entry.getValue().participant;
                    }
                    return failRate;
                }).reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList()).stream().mapToInt(Integer::intValue).toArray();


        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FailRate().solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(new FailRate().solution(4, new int[]{4,4,4,4,4})));
    }
}
