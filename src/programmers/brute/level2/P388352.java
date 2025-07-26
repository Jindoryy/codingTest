package programmers.brute.level2;

import java.util.*;

class Solution {

    static int[] secret;           // 현재 조합된 비밀 코드 (길이 5)
    static int[][] inspect;        // 사용자의 m번 시도 코드
    static int[] ansInfo;          // 각 시도별 정답 개수
    static int answer;             // 조건을 만족하는 비밀코드 개수

    public int solution(int n, int[][] q, int[] ans) {
        inspect = q;
        ansInfo = ans;

        secret = new int[5];
        combination(0, 1, n); // depth=0부터 시작, index=1부터 n까지 조합

        return answer;
    }

    // 조합 생성 (오름차순으로 5개 선택)
    private void combination(int depth, int idx, int n) {
        if (depth == 5) {
            if (isValid()) answer += 1; // 조건 만족 시 정답 개수 증가
            return;
        }

        for (int i = idx; i <= n; i++) {
            secret[depth] = i;
            combination(depth + 1, i + 1, n);
        }
    }

    // 현재 조합이 모든 시도에 대해 일치 개수를 만족하는지 확인
    private boolean isValid() {
        Set<Integer> secretSet = new HashSet<>();
        for (int val : secret) {
            secretSet.add(val);
        }

        for (int i = 0; i < inspect.length; i++) {
            int count = 0;
            for (int val : inspect[i]) {
                if (secretSet.contains(val)) {
                    count++;
                }
            }

            if (count != ansInfo[i]) {
                return false; // 하나라도 불일치하면 실패
            }
        }

        return true;
    }
}


public class P388352 {
}
