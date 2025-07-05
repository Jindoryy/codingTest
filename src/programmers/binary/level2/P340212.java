package programmers.binary.level2;

import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {

        int answer = 0;
        int lp = 1, rp = 100000;

        while (lp <= rp) {

            long consume = times[0]; // 소요되는 시간 (첫번째 퍼즐은 time_cur만큼의 시간만큼 사용해서 푼다고 가정)
            int level = (lp + rp) / 2; // 숙련도

            for (int i = 1; i < diffs.length; i++) {

                int diff = diffs[i]; // 난이도
                if (diff <= level) { // 난이도 <= 숙련도
                    consume += times[i];
                }
                else {
                    consume += (diff-level) * (times[i] + times[i-1]) + times[i];
                }
            }

            if (consume <= limit) {
                answer = level;
                rp = level - 1;
            }
            else {
                lp = level + 1;
            }
        }

        return answer;
    }
}

public class P340212 {
    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.solution(new int[] { 31, 5, 3}, new int[] {2, 4, 7}, 30));
    }
}