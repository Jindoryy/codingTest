package programmers.binary.level2;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {

        int lp = 1, rp = 100000;
        int answer = 0;

        while (lp <= rp) {

            long timeConsume = times[0]; // 소요시간
            int mid = (lp + rp) / 2; // 숙련도

            for (int i = 1 ; i < diffs.length ; i++) {
                if (diffs[i] <= mid) {
                    timeConsume += times[i];
                }
                else {
                    int failCount = diffs[i] - mid;
                    timeConsume += (times[i-1] + times[i]) * failCount + times[i];
                }
            }

            // 제한 시간 내에 가능하면 더 작은 숙련도 탐색 | 숙련도를 줄이면서 탐색하기 떄문에 이 부분에서 answer 업데이트
            if (timeConsume <= limit) {
                answer = mid;
                rp = mid - 1;
            } else {
                lp = mid + 1;
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