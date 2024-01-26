package level1;

public class PrimeNumber {
    public boolean isPrime(int n){
        if (n==1) return false;

        int lim = (int) Math.sqrt(n);
        
        for (int i = 2; i <= lim; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n; i++){
            if (isPrime(i)){
                answer++;
            }
        }
        
        return answer;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new PrimeNumber().solution(n));
    }
}
