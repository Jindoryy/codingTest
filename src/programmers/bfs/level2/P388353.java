package programmers.bfs.level2;

import java.util.*;

class Solution {

    static int N, M; // 창고의 세로(N), 가로(M)
    static char[][] board; // 창고 상태 ('.'은 비어있음을 의미)
    static boolean[][] visited; // BFS 방문 체크용
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0}; // 좌우상하 방향
    static int answer; // 남은 컨테이너 개수

    public int solution(String[] storage, String[] requests) {

        N = storage.length;
        M = storage[0].length();
        board = new char[N+2][M+2]; // 바깥쪽에 여유 공간 1줄 추가 (외부를 표현하기 위함)

        // 바깥 테두리 초기화
        for (int i = 0; i < N+2; i++) {
            Arrays.fill(board[i], '.'); // '.'은 비어있는 칸
        }

        // 입력받은 storage를 board에 옮김 (1-indexed로)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i+1][j+1] = storage[i].charAt(j);
            }
        }

        // 출고 요청 처리
        for (String request : requests) {
            int howPick = request.length(); // 요청 길이 (1이면 지게차, 2면 크레인)
            char whatPick = request.charAt(0); // 출고할 알파벳 종류

            // 지게차 출고: 외부와 닿은 동일 알파벳 제거
            if (howPick == 1) {
                visited = new boolean[N+2][M+2]; // 방문 배열 초기화
                bfs(whatPick); // 외부에서 접근 가능한 알파벳 제거
            }
            // 크레인 출고: 전체에서 해당 알파벳 전부 제거
            else if (howPick == 2) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (board[i+1][j+1] == whatPick) {
                            board[i+1][j+1] = '.'; // 컨테이너 제거
                        }
                    }
                }
            }
        }

        // 남은 컨테이너 개수 세기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i+1][j+1] != '.') {
                    answer += 1;
                }
            }
        }
        return answer;
    }

    // 외부에서 접근 가능한 동일 알파벳 제거 (지게차)
    private void bfs(char whatPick) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0}); // 외부(0,0)에서 시작
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] qPoll = q.poll();
            int px = qPoll[0];
            int py = qPoll[1];

            // 4방향 탐색
            for (int k = 0; k < 4; k++) {
                int mx = px + dx[k];
                int my = py + dy[k];

                if (!isRange(mx, my)) continue; // 범위 밖이면 skip
                if (visited[mx][my]) continue; // 이미 방문했으면 skip

                // '.' 또는 목표 알파벳이면 진행
                if (board[mx][my] == whatPick || board[mx][my] == '.') {
                    visited[mx][my] = true;

                    // 해당 알파벳이면 제거
                    if (board[mx][my] == whatPick) {
                        board[mx][my] = '.';
                    }
                    // 비어 있는 곳이면 계속 탐색
                    else {
                        q.add(new int[]{mx, my});
                    }
                }
            }
        }
    }

    // 범위 체크 (board는 N+2 x M+2 사이즈)
    private boolean isRange(int mx, int my) {
        return 0 <= mx && mx < N+2 && 0 <= my && my < M+2;
    }
}

public class P388353 {
}
