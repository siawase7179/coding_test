package level2.serach;

/**
 * 깊이/너비 우선 탐색(DFS/BFS) - 타겟 넘버
 */
public class TargetNumber {
    static int count = 0;
    
    public void dfs(int[] nums, int target, int index, int currentSum) {
        if (index == nums.length) {
            if (currentSum == target) count++;    
        }else{
            dfs(nums, target, index + 1, currentSum + nums[index]);
            dfs(nums, target, index + 1, currentSum - nums[index]);
        }        
    }
    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers, target, 0, 0);
        answer = count;
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new TargetNumber().solution(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(new TargetNumber().solution(new int[]{4, 1, 2, 1}, 4));
    }
}
