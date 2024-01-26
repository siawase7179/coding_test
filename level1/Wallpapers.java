package level1;
import java.util.*;

public class Wallpapers {
    class Point{
        public int x;
        public int y;
        public Point(int _x, int _y){
            x=_x; y=_y;
        }
    }

    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        answer = new int[4];
        List<Point> list = new ArrayList<>();
        for (int i=0; i<wallpaper.length; i++){
            for (int j=0; j<wallpaper[0].length(); j++){
                if (wallpaper[i].charAt(j) == '#'){
                    list.add(new Point(i, j));
                }
                
            }
        }

        for(Point point : list){
            System.out.println(point.x+","+point.y);
        }
        Point minXPoint = list.stream()
                .min(Comparator.comparingInt(p -> p.x))
                .orElse(null);
        answer[0] = minXPoint.x;
        Point maxXPoint = list.stream()
                .max(Comparator.comparingInt(p -> p.x))
                .orElse(null);

        answer[2] = maxXPoint.x+1;

        Point minYPoint = list.stream()
                .min(Comparator.comparingInt(p -> p.y))
                .orElse(null);
        answer[1] = minYPoint.y;

        Point maxYPoint = list.stream()
                .max(Comparator.comparingInt(p -> p.y))
                .orElse(null);
        answer[3] = maxYPoint.y+1;
    
        return answer;
    }

    public static void main(String[] args){
        String[] wallpaper = {".#...", "..#..", "...#."};
        // String[] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
        System.out.println(Arrays.toString(new Wallpapers().solution(wallpaper)));
    }
}
