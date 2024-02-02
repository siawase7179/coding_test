package level2;
/**
 * Summer/Winter Coding(~2018) - 점프와 순간 이동
 */
public class IronSuit {
  
    public int solution(int n) {
        int ans = 0;

        while(n != 0){
            if (n % 2 == 0){
                n /= 2;
            }else{
                n--;
                ans++;
            }
        }
        
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(new IronSuit().solution(5));
        System.out.println(new IronSuit().solution(6));
        System.out.println(new IronSuit().solution(5000));
    }
}
