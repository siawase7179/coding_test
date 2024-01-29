package level1;

/**
 * [PCCE 기출문제] 10번 / 데이터 분석
 */
import java.util.*;
import java.util.stream.*;
public class DataAnalyze {
    class Data{
        private int code;
        private int date;
        private int maximum;
        private int remain;

        public Data(int code, int date, int maximum, int remain){
            this.code = code;
            this.date = date;
            this.maximum = maximum;
            this.remain = remain;
        }

        @Override
        public String toString(){
            return String.format("%d,%d,%d,%d", code, date, maximum, remain);
        }
    }
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        List<Data> list = IntStream.range(0, data.length)
                            .boxed()
                            .map(i -> new Data(data[i][0], data[i][1], data[i][2], data[i][3]))
                            .collect(Collectors.toList());

        answer = list.stream()
            .filter(obj -> {
                if (ext.equals("code")){
                    return obj.code <= val_ext;
                }else if (ext.equals("date")){
                    return obj.date <= val_ext;
                }else if (ext.equals("maximum")){
                    return obj.maximum <= val_ext;
                }else if (ext.equals("remain")){
                    return obj.remain <= val_ext;
                }
                return true;
            })
            .sorted((obj1, obj2) -> {
                if (sort_by.equals("code")){
                    return Integer.compare(obj1.code, obj2.code);
                }else if (sort_by.equals("date")){
                    return Integer.compare(obj1.date, obj2.date);
                }else if (sort_by.equals("maximum")){
                    return Integer.compare(obj1.maximum, obj2.maximum);
                }else if (sort_by.equals("remain")){
                    return Integer.compare(obj1.remain, obj2.remain);
                }
                return 0;
            })
            .map(obj -> new int[]{obj.code, obj.date, obj.maximum, obj.remain})
            .toArray(int[][]::new);

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new DataAnalyze().solution(
            new int[][]{{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}},
            "date", 20300501, "remain")));
    }  
}
