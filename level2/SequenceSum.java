package level2;

import java.util.Arrays;

class SequenceSum {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {-1, -1};
        int sum = 0, left=0, right=0;
        for (right=0; right<sequence.length; right++){
            sum += sequence[right];
            while(sum > k){
                sum -= sequence[left++];
            }
            if (sum == k){
                if((answer[0]==-1 && answer[1]==-1) || right-left<answer[1]-answer[0]){
                    answer[0]=left;
                    answer[1]=right;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        SequenceSum solution_1 = new SequenceSum();
        int []n = {2,2,2,2,2,2};
        int k = 6;
        int []array = solution_1.solution(n, k);
        System.out.println(Arrays.toString(array));
    }
}