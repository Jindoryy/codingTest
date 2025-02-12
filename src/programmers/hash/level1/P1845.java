package programmers.hash.level1;

import java.util.*;

class Solution {
    public int solution(int[] nums) {

        Set<Integer> pickList = new HashSet<>();
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!pickList.contains(nums[i])) {
                pickList.add(nums[i]);
            }
        }

        if (pickList.size() > nums.length / 2) {
            answer = nums.length / 2;
        } else {
            answer = pickList.size();
        }

        return answer;
    }
}

public class P1845 {
    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.solution(new int[] { 3,3,3,2,2,2}));
    }
}
