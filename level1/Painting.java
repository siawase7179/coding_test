package level1;


public class Painting {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int[] wall = new int[n];
        for (int i : section){
            wall[i-1] = 1;
        }

        for (int _section : section){      
            _section -=1;      
            if (wall[_section] == 1){
                int _m=0;
                while (_m < m && _section+_m <n){
                    wall[_section+_m] = 0;
                    _m++;
                }
                ++answer;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        int n = 8;
        int m = 4;
        int[] section = {2, 3, 6};

        Painting sol = new Painting();
        System.out.println(sol.solution(n, m, section));

    }
}
