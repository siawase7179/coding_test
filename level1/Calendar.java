package level1;
/**
 * 2016년
 */
public class Calendar {
    public String solution(int a, int b) {
        String answer = "";
        String[] dayStrArray = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int[] dayOfMonthAray = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day = 0;
        for (int i=1; i<a; i++)
            day += dayOfMonthAray[i-1];
        day += b-1;
        
        answer = dayStrArray[day % 7];

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new Calendar().solution(11, 30));
        System.out.println(new Calendar().solution(12, 31));
        System.out.println(new Calendar().solution(8, 1));
        System.out.println(new Calendar().solution(7, 31));
    }
}
