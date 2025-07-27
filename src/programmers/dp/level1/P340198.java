package programmers.dp.level1;

import java.util.*;

class Solution {

    static int N, M;
    static int[][] dp;
    static int hasMaxMat;  // 전체 공원에서 만들 수 있는 가장 큰 정사각형의 한 변 길이
    static int answer = -1;

    public int solution(int[] mats, String[][] park) {

        N = park.length;
        M = park[0].length;

        dp = new int[N][M];

        // DP 테이블 채우기: park[i][j]를 오른쪽 아래 꼭짓점으로 하는 정사각형 크기 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                // 사람이 있는 칸인 경우 (의자가 설치 불가능)
                if (!park[i][j].equals("-1")) {
                    dp[i][j] = 0;
                }
                // 가장자리이거나 첫 행/열이면 길이 1 가능 (주변 참조 불가)
                else if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                }
                // 주변 3칸이 모두 유효해야 정사각형 확장 가능
                else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }

                // 현재까지 만든 정사각형 중 가장 큰 한 변 길이 저장
                hasMaxMat = Math.max(hasMaxMat, dp[i][j]);
            }
        }

        // mats 배열은 만들 수 있는 정사각형 크기 후보들
        Arrays.sort(mats);

        // 만들 수 있는 최대 정사각형 크기 이하 중 가장 큰 mats 원소를 선택
        for (int i = 0; i < mats.length; i++) {
            if (mats[i] <= hasMaxMat) {
                answer = mats[i]; // 조건을 만족하면 계속 갱신
            }
        }

        return answer;
    }
}


public class P340198 {
}
