package programmers.heap.level3;

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {

        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            String[] ope = operation.split(" ");
            String mark = ope[0];
            int number = Integer.parseInt(ope[1]);

            if ("I".equals(mark)) {
                minPq.add(number);
                maxPq.add(number);
            }
            else if ("D".equals(mark)) {
                if (number == -1) { // 최솟값 삭제
                    maxPq.remove(minPq.poll());
                }
                else if (number == 1) { // 최댓값 삭제
                    minPq.remove(maxPq.poll());
                }
            }
        }

        if (minPq.isEmpty()) {
            return new int[] {0, 0};
        }
        return new int[] {maxPq.poll(), minPq.poll()};
    }
}

public class P42628 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.solution(new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
    }
}
