package programmers.level1.stack;

import java.util.*;

class Solution {
    public Stack solution(int[] nums) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {

            if (stack.isEmpty()) {
                stack.push(nums[i]);
            }
            else if (stack.peek() != nums[i]) {
                stack.push(nums[i]);
            }
        }

        return stack;
    }
}

public class P12906 {
    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.solution(new int[] { 1,1,3,3,0,1,1}));
    }
}