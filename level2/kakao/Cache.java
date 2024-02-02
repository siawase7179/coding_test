package level2.kakao;

/*
 * 2018 KAKAO BLIND RECRUITMENT - [1차] 캐시
 */
import java.util.*;
import java.util.stream.*;
public class Cache {
    class LRUCache{
        String data;
        int chached;
    }
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        if (cacheSize == 0) return cities.length*5;
        for (String city : cities){
            if (queue.size() > cacheSize){
                queue.poll();
            }
            Set<String> set = queue.stream().collect(Collectors.toSet());
            if (set.contains(city.toLowerCase())){
                answer += 1;
                queue.remove(city.toLowerCase());
            }else{
                answer += 5;
            }
            queue.add(city.toLowerCase());
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new Cache().solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        System.out.println(new Cache().solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
        System.out.println(new Cache().solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(new Cache().solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(new Cache().solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
        System.out.println(new Cache().solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        System.out.println(new Cache().solution(0, new String[]{"Jeju", "jeju", "jeju", "jeju"}));
        System.out.println(new Cache().solution(3, new String[]{"Jeju", "a", "a", "jeju", "jeju"}));
    }
}
