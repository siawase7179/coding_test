package level2;

/*
 * 호텔 대실
 */
import java.util.*;

public class RoomReservation {

    class BookTime{
        int startTime;
        int endTime;
        BookTime(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public int toMin(String date){
        String[] split = date.split(":");
        return (Integer.parseInt(split[0]) * 60) + Integer.parseInt(split[1]);
    }
    

    public int solution(String[][] book_time){
        int answer = 0;

        List<BookTime> bookList=new ArrayList<>();

        for(String[] book:book_time){
            int start_time=toMin(book[0]);
            int end_time=toMin(book[1]);

            bookList.add(new BookTime(start_time,end_time));
        }

        Collections.sort(bookList,(o1,o2)->{
            if(o1.startTime==o2.startTime) return o1.endTime-o2.endTime;
            else return o1.startTime-o2.startTime;
        });

        List<Integer> endTimeList = new ArrayList<>();
        for (BookTime booktime : bookList){
            boolean ok = false;
            
            Collections.sort(endTimeList);
            for (int i=0; i<endTimeList.size(); i++){
                int end_time = endTimeList.get(i) + 10;
                if (end_time <= booktime.startTime){
                    endTimeList.set(i, booktime.endTime);
                    ok = true;
                    break;
                }
            }
            if(!ok){
                endTimeList.add(booktime.endTime);
            }
        }
        answer = endTimeList.size();

        return answer;
    }
 
    public static void main(String[] args){
        String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        RoomReservation solution_2 = new RoomReservation();
        System.out.println(solution_2.solution(book_time));
    }
}
