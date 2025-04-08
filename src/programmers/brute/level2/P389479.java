package programmers.brute.level2;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;

        for (int i = 0; i < 24; i++) {
            int player = players[i];
            int serverCnt = player / m;

            if (serverCnt > 0) {
                answer += serverCnt;
                for (int j = i; j < i+k; j++) {
                    if (j < 24) {
                        players[j] = players[j] - (m * serverCnt) < 0 ? 0 : players[j] - (m * serverCnt);
                    }
                }
            }
        }

        return answer;
    }
}

public class P389479 {
    public static void main(String[] args) {

    }
}
