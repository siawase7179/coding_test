package level2;
/**
 * 전화번호 목록
 */
import java.util.*;
public class PhoneBook {
    
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        
        /* HashSet<String> set = new HashSet<>();

        for (String phoneNumber : phone_book) {
            for (int i = 0; i < phoneNumber.length(); i++) {
                String prefix = phoneNumber.substring(0, i);
                if (set.contains(prefix)) {
                    return false;
                }
            }
            set.add(phoneNumber);
        } */

        for (int i=0; i<phone_book.length-1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new PhoneBook().solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(new PhoneBook().solution(new String[]{"123","456","789"}));
        System.out.println(new PhoneBook().solution(new String[]{"12","123","1235","567","88"}));
        System.out.println(new PhoneBook().solution(new String[]{"12","1"}));
    }
}
