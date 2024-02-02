package level2;
/**
 * 프로세스
 */

import java.util.*;
import java.util.stream.*;
public class PriorityProcess {
    class Process{
        int idx;
        int process;
        public Process(int idx, int process){
            this.idx = idx;
            this.process = process;
        }
        @Override
        public String toString(){
            return "num:" + process + " <" + idx + ">";
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Process> queue = IntStream.range(0, priorities.length)
        .boxed()
        .map(i -> new Process(i, priorities[i]))
        .collect(Collectors.toCollection(LinkedList::new));
        
        while(true){
            Process maxProcess = queue.stream().max((o1, o2) -> o1.process > o2.process ? 1 : -1).get();            
            Process now = queue.poll();
            if (now.process != maxProcess.process){
                queue.add(now);
            }else{  
                answer++;
                if (now.idx == location) break;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new PriorityProcess().solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(new PriorityProcess().solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
        System.out.println(new PriorityProcess().solution(new int[]{1, 1, 1, 1, 1, 1}, 0));
    }
   
}
