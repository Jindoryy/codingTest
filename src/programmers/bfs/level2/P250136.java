package programmers.bfs.level2;

import java.util.*;

class Solution {

    static int[][] land;                  // 입력된 땅 정보 (0: 빈 땅, 1: 석유)
    static int n, m;                      // 땅의 세로 길이(n), 가로 길이(m)
    static boolean[][] visited;           // 방문 여부 체크
    static int[] dx = {0, 0, -1, 1},      // 4방향 탐색 (상, 하, 좌, 우)
            dy = {-1, 1, 0, 0};
    static int oilNum = 2;                // 석유 덩어리에 부여할 고유 번호 (2부터 시작, 0/1과 구분하기 위함)
    static Map<Integer, Integer> oilMap = new HashMap<>(); // <덩어리 번호, 덩어리 크기>
    static Set<Integer> passNum = new HashSet<>();         // 한 열에서 중복 카운트 방지용 (이미 포함된 덩어리 번호 저장)
    static int answer;                    // 최종 결과 (가장 많은 석유량)

    public int solution(int[][] lan) {

        land = lan;
        n = land.length;
        m = land[0].length;

        visited = new boolean[n][m];

        // Step 1. BFS를 이용하여 석유 덩어리에 고유 번호 부여 & 크기 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // 아직 방문하지 않은 석유 땅(1)이면 새로운 덩어리로 BFS 수행
                if (land[i][j] == 1 && !visited[i][j]) {
                    assignOilNum(i, j);
                }
            }
        }

        // Step 2. 각 열(column)에 대해 시추관을 세웠을 때의 석유량 계산
        for (int i = 0; i < m; i++) {

            passNum.clear();   // 현재 열에서 이미 카운트한 덩어리 번호 기록 (중복 방지)
            int passCnt = 0;   // 현재 열에서 얻을 수 있는 석유량

            for (int j = 0; j < n; j++) {
                int landNum = land[j][i]; // 현재 열 i, 행 j의 땅 번호

                // 석유 덩어리에 속하는 칸이고 아직 추가하지 않은 덩어리라면
                if (landNum > 1 && !passNum.contains(landNum)) {
                    passCnt += oilMap.get(landNum); // 덩어리 크기 더하기
                    passNum.add(landNum);          // 덩어리 번호 기록
                }
            }

            // 가장 많은 석유량 갱신
            answer = Math.max(answer, passCnt);
        }

        return answer;
    }

    // BFS로 하나의 석유 덩어리에 고유 번호를 부여하고 크기를 구하는 메서드
    private void assignOilNum(int x, int y) {

        Queue<int[]> q = new LinkedList<>();

        land[x][y] = oilNum;      // 현재 위치를 덩어리 번호로 갱신
        visited[x][y] = true;     // 방문 처리
        q.add(new int[]{x, y});

        int oilCnt = 1;           // 현재 덩어리의 크기 (시작 칸 포함)

        while (!q.isEmpty()) {
            int[] qPoll = q.poll();
            int px = qPoll[0];
            int py = qPoll[1];

            // 4방향 탐색
            for (int k = 0; k < 4; k++) {
                int mx = px + dx[k];
                int my = py + dy[k];

                if (!isRange(mx, my)) continue;   // 범위를 벗어나면 무시
                if (visited[mx][my]) continue;   // 이미 방문한 칸이면 무시

                if (land[mx][my] == 1) {         // 석유가 있는 땅이면
                    land[mx][my] = oilNum;       // 현재 덩어리 번호로 갱신
                    visited[mx][my] = true;      // 방문 처리
                    q.add(new int[]{mx, my});    // 큐에 추가
                    oilCnt += 1;                 // 덩어리 크기 증가
                }
            }
        }

        // 덩어리 번호 → 덩어리 크기 저장
        oilMap.put(oilNum, oilCnt);
        oilNum += 1; // 다음 덩어리를 위해 번호 증가
    }

    // 좌표가 보드 범위 내인지 확인하는 메서드
    private boolean isRange(int mx, int my) {
        return 0 <= mx && mx < n && 0 <= my && my < m;
    }
}


public class P250136 {
}
