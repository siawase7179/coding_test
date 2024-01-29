package level1;
/**
 * 카드 뭉치
 */
import java.util.*;

public class CardMungchi {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        List<String> cardList1 = new ArrayList<>(Arrays.asList(cards1));
        List<String> cardList2 = new ArrayList<>(Arrays.asList(cards2));

        for (int i=0; i<goal.length; i++){
            if (cardList1.size() > 0 && goal[i].equals(cardList1.get(0))){
                cardList1.remove(0);
            }else if (cardList2.size() > 0 && goal[i].equals(cardList2.get(0))){
                cardList2.remove(0);
            }else{
                answer = "No";
                break;
            }
        }
        
        return answer;
    }
    public static void main(String[] args) {
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal={"i", "want", "to", "drink", "water"};
        System.out.println(new CardMungchi().solution(cards1, cards2, goal));
    }
}
