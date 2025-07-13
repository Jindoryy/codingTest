package programmers.dp.level2;

class Solution {

    static int answer = 121;              // A 도둑이 남긴 흔적의 최소값 (초기값은 충분히 큰 값으로 설정)
    static boolean[][][] visited;         // 방문 체크: [현재 깊이][A의 누적 흔적][B의 누적 흔적]

    public int solution(int[][] info, int n, int m) {

        // info.length + 1: 깊이(=물건 개수)
        // n: A 도둑 흔적 제한
        // m: B 도둑 흔적 제한
        visited = new boolean[info.length + 1][n][m];

        // DFS 탐색 시작 (0번째 물건부터, 흔적 0, 0)
        dfs(0, info, 0, 0, n, m);

        // 모든 경우의 수를 탐색했는데 조건을 만족한 경우가 없다면 -1 반환
        if (answer == 121) answer = -1;

        return answer;
    }

    /**
     * DFS 탐색 함수
     *
     * @param depth 현재 몇 번째 물건까지 고려했는지
     * @param info 각 물건을 누가 훔칠 경우 남기는 흔적 (info[i][0] = A 도둑, info[i][1] = B 도둑)
     * @param A     지금까지 A 도둑이 남긴 흔적의 총합
     * @param B     지금까지 B 도둑이 남긴 흔적의 총합
     * @param n     A 도둑이 잡히는 최소 흔적 개수
     * @param m     B 도둑이 잡히는 최소 흔적 개수
     */
    private void dfs(int depth, int[][] info, int A, int B, int n, int m) {

        // A 또는 B 도둑이 잡히는 조건을 넘으면 이 경로는 무효 → 탐색 종료
        if (A >= n || B >= m) return;

        // 이미 이 상태로 탐색한 적 있다면 중복이므로 스킵
        if (visited[depth][A][B]) return;
        visited[depth][A][B] = true;

        // 모든 물건을 다 훔친 경우 (종료 조건)
        if (depth == info.length) {
            // 이 경로는 유효하므로 A 도둑의 흔적 최소값을 갱신
            answer = Math.min(answer, A);
            return;
        }

        // 다음 물건을 A 도둑이 훔치는 경우
        dfs(depth + 1, info, A + info[depth][0], B, n, m);

        // 다음 물건을 B 도둑이 훔치는 경우
        dfs(depth + 1, info, A, B + info[depth][1], n, m);
    }
}

public class P389480 {
}
