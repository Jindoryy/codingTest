package programmers.greedy.level3;

import java.util.*;

// answer가 int면 효율성에서 점수를 못 얻고, long이면 통과 됨
class Solution {
    public long solution(int n, int[] works) {

        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            pq.add(work);
        }

        for (int i = 0; i < n; i++) {
            if (!pq.isEmpty()) {
                int work = pq.poll();

                if (work > 1) {
                    pq.add(work-1);
                }
            }
        }

        while (!pq.isEmpty()) {
            int work = pq.poll();
            answer += (work * work);
        }

        return answer;
    }
}

public class P12927 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}
