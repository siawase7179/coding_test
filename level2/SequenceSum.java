package level2;

import java.util.Arrays;

class SequenceSum {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {-1, -1};
        int sum = 0, left=0, right=0;
        for (left=0; left<sequence.length; left++){
            sum += sequence[left];
            while(sum > k){
                sum -= sequence[right++];
            }
            if (sum == k){
                if((answer[0]==-1 && answer[1]==-1) || left-right<answer[1]-answer[0]){
                    answer[0]=right;
                    answer[1]=left;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        int []n = {2,2,2,2,2,2};
        int k = 6;
        System.out.println(Arrays.toString(new SequenceSum().solution(n, k)));
    }
}