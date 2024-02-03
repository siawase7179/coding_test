package level2;
/**
 * 힙(Heap -> PriorityQueue) - 더 맵게
 */
import java.util.*;
import java.util.stream.*;
public class Scoville {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = IntStream.range(0, scoville.length)
        .boxed()
        .map(i->scoville[i])
        .collect(Collectors.toCollection(PriorityQueue::new));

        while(true){
            if (queue.peek() >= K || queue.size() < 2) break;
            
            int a = queue.poll();
            int b = queue.poll();
        
            queue.offer(a + (b*2));
            answer++;
            System.out.println(queue);
        }
        if (queue.peek() < K) return -1;
        return answer;
    }
    public static void main(String[] args) {
        // System.out.println(new Scoville().solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
        System.out.println(new Scoville().solution(new int[]{1, 1, 1}, 9));
    }
}
