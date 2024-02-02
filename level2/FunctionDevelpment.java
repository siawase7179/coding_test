package level2;
/**
 * 기능개발
 */
import java.util.*;
import java.util.stream.*;
public class FunctionDevelpment {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> queue = IntStream.range(0, progresses.length)
        .boxed()
        .map(i->{
            int day = 0;
            int process = progresses[i];
            while(process < 100){
                process += speeds[i];
                day++;
            }
            return day;
        })
        .collect(Collectors.toCollection(LinkedList::new));
        
        int maxDay = 0, deploy=0;
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while(!queue.isEmpty()){
            int day = queue.poll();
            if(stack.size() == 0 ){
                maxDay = day;
                stack.add(day);
            }else{
                if(maxDay < day){
                    while(!stack.isEmpty()){
                        stack.pop();
                        deploy++;
                    }
                    maxDay = Math.max(maxDay, day);
                    list.add(deploy);
                    deploy=0;
                }
                maxDay = Math.max(maxDay, day);
                stack.add(day);
            }
        }
        if (queue.isEmpty()){
            while(!stack.isEmpty()){
                stack.pop();
                deploy++;
            }
            list.add(deploy);
        }

        answer = list.stream().mapToInt(Integer::intValue).toArray();

        /* int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray(); */

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FunctionDevelpment().solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
        System.out.println(Arrays.toString(new FunctionDevelpment().solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));

        System.out.println(Arrays.toString(new FunctionDevelpment().solution(new int[]{99, 98, 98}, new int[]{1,1,2})));
    }
}
