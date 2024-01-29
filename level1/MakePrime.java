package level1;
/**
 * Summer/Winter Coding(~2018) - 소수 만들기
 */
public class MakePrime {
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
    public int solution(int[] nums) {
        int answer = 0;

        for (int i=0; i<nums.length; i++){
            int left = i+1;
            int right = nums.length-1;
            
            while(right > left){
                if (right < 0 || left >= nums.length){
                    break;
                }
                while(left < nums.length){
                    if (nums[left] != nums[right]){
                        while(right > left){
                            int sum = nums[i] + nums[left] + nums[right];
                            System.out.println(nums[i]+","+nums[left]+","+nums[right]+"="+sum);
                            if (isPrime(sum)){
                                answer++;
                            }
                            right--;
                        }
                    } 
                    right = nums.length-1;
                    left++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(new MakePrime().solution(nums));
    }
}
