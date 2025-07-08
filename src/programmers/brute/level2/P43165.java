package programmers.brute.level2;

class Solution {

    static int answer;

    public int solution(int[] numbers, int target) {

        dfs(0, 0, numbers, target);

        return answer;
    }

    private void dfs(int depth, int sum, int[] numbers, int target) {

        if (depth == numbers.length) {
            if (sum == target) {
                answer += 1;
            }
            return;
        }

        dfs(depth+1, sum+numbers[depth], numbers, target);
        dfs(depth+1, sum-numbers[depth], numbers, target);
    }
}

public class P43165 {
}
