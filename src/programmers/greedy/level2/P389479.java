package programmers.greedy.level2;

import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0; // 총 서버 증설 횟수 누적값

        // 0시부터 23시까지 시간대 순회
        for (int i = 0; i < 24; i++) {
            int player = players[i]; // 현재 시간대의 게임 이용자 수
            int serverCnt = player / m; // 필요한 서버 수 (한 서버당 m명 감당)

            // 서버를 증설해야 하는 경우
            if (serverCnt > 0) {
                answer += serverCnt; // 서버 증설 횟수 누적

                // 증설된 서버는 현재 시간부터 k시간 동안 작동
                // 그 시간 동안, 해당 서버 수만큼 이용자 수를 줄여야 함
                for (int j = i; j < i + k; j++) {
                    if (j < 24) { // 하루는 24시간이므로 24시 넘지 않도록 체크
                        // 해당 시간대의 이용자 수 감소 (감당 가능한 수만큼)
                        players[j] = Math.max(0, players[j] - (m * serverCnt));
                    }
                }
            }
        }

        return answer; // 최소 서버 증설 횟수 반환
    }
}

public class P389479 {
}
