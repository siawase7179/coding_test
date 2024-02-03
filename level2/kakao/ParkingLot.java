package level2.kakao;

/**
 * 2022 KAKAO BLIND RECRUITMENT - 주차 요금 계산
 */
import java.util.*;
import java.util.stream.*;
public class ParkingLot {
    
    public int getTimestamp(String time){
        int hour = Integer.parseInt(time.split(":")[0]);
        int min = Integer.parseInt(time.split(":")[1]);
        return (hour * 60) + min;
    }
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> feeMap = new HashMap<>();
        
        for (int i=0; i<records.length; i++){
            String time = records[i].split(" ")[0];
            String number = records[i].split(" ")[1];
            String status = records[i].split(" ")[2];

            if (status.equals("IN")){
                map.put(number, getTimestamp(time));
            }else if (status.equals("OUT")){
                int parkingTime = getTimestamp(time) - map.get(number);
                if(feeMap.containsKey(number)){
                    feeMap.put(number, feeMap.get(number) + parkingTime);
                }else{
                    feeMap.put(number, parkingTime);
                }
                
                map.remove(number);
            }
        }
        
        
        for (String key : map.keySet()){
            int parkingTime = getTimestamp("23:59") - map.get(key);
            if (feeMap.containsKey(key)){
                feeMap.put(key, feeMap.get(key)+ parkingTime);
            }else{
                feeMap.put(key, parkingTime);
            }

        }

        for (String key : feeMap.keySet()){
            int parkingTime = feeMap.get(key);
            int fee = defaultFee;
            if (parkingTime > defaultTime){
                fee = defaultFee + (((parkingTime - defaultTime) / unitTime) * unitFee);
            }
            
            if ((parkingTime - defaultTime) % unitTime < unitTime && (parkingTime - defaultTime) % unitTime >0){
                fee += unitFee;
            }
        
            feeMap.replace(key, fee);
        }

        List<Integer> list = feeMap.entrySet().stream()
        .sorted(Map.Entry.comparingByKey())
        .map(t -> t.getValue())
        .collect(Collectors.toList());

        answer = new int[list.size()];

        for (int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ParkingLot().solution(
        new int[]{180, 5000, 10, 600},
        new String[]{
            "05:34 5961 IN",
            "06:00 0000 IN",
            "06:34 0000 OUT",
            "07:59 5961 OUT",
            "07:59 0148 IN",
            "18:59 0000 IN",
            "19:09 0148 OUT",
            "22:59 5961 IN",
            "23:00 5961 OUT"})));

        System.out.println(Arrays.toString(new ParkingLot().solution(
        new int[]{1, 461, 1, 10},
        new String[]{
            "00:00 1234 IN"})));
    }
}
