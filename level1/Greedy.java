package level1;
import java.util.*;
public class Greedy {
    /* public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        answer = n - lost.length;

        for (int _lost: lost){
            if (map.containsKey(_lost)){
                answer++;
                map.put(_lost,true);
                continue;
            }
        }
        
        for (int _lost: lost){
            if(map.containsKey(_lost-1)){                
                if(!map.get(_lost-1)){
                    map.put(_lost-1,true);
                    answer++;
                    continue;
                }
            }

            if(map.containsKey(_lost+1)){
                if(!map.get(_lost+1)){
                    map.put(_lost+1,true);
                    answer++;
                    continue;
                }
            }
        }
        return answer;
    } */

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Arrays.sort(reserve);
        Arrays.sort(lost);
        answer = n - lost.length;

        for (int i=0; i<lost.length; i++) {
			for (int j=0; j<reserve.length; j++) {
				if (lost[i] == reserve[j]) {
					answer++;
					lost[i] = -1;
					reserve[j] = -1;
                    break;
				}
			}
		}

        for (int i=0; i<lost.length; i++){
            for (int j=0; j<reserve.length; j++){
                if(lost[i] -1 == reserve[j] || lost[i]+1 == reserve[j]){
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        return answer;
    }
    public static void main(String[] argc){
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {3};
        
        System.out.println(new Greedy().solution(n, lost, reserve));
    }
}