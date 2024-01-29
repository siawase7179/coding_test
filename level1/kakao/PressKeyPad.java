package level1.kakao;

/**
 * 2020 카카오 인턴십 - 키패드 누르기
 */
import java.util.*;
public class PressKeyPad {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        boolean isRight = hand.equals("right") ? true : false;

        Map<String, List<Integer>> map = new HashMap<>();
        map.put("1", List.of(0, 0));
        map.put("4", List.of(1, 0));
        map.put("7", List.of(2, 0));
        map.put("*", List.of(3, 0));

        map.put("3", List.of(0, 2));
        map.put("6", List.of(1, 2));
        map.put("9", List.of(2, 2));
        map.put("#", List.of(3, 2));

        map.put("2", List.of(0, 1));
        map.put("5", List.of(1, 1));
        map.put("8", List.of(2, 1));
        map.put("0", List.of(3, 1));

        List<Integer> left = map.get("*");
        List<Integer> right = map.get("#");
        List<String> answerList = new ArrayList<>();
        for (int number : numbers){
            if (number == 1 || number == 4 || number == 7){
                answerList.add("L");
            }else if (number == 3 || number == 6 || number == 9){
                answerList.add("R");
            }else{
                List<Integer> where = map.get(String.valueOf(number));
                int dLeft = Math.abs((where.get(0) - left.get(0))) + Math.abs((where.get(1) - left.get(1)));
                int dRight =  Math.abs((where.get(0) - right.get(0))) + Math.abs((where.get(1) - right.get(1)));

                if (dLeft > dRight){
                    answerList.add("R");
                }else if (dLeft < dRight){
                    answerList.add("L");
                }else{
                    answerList.add(isRight ? "R":"L");
                }
            }
            if (answerList.get(answerList.size()-1) == "R"){
                right = map.get(String.valueOf(number));
            }else{
                left = map.get(String.valueOf(number));
            }
        }
        for (String tmp : answerList){
            answer+=tmp;
        }
        
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new PressKeyPad().solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }
}
