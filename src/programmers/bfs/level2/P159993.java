package programmers.bfs.level2;

import java.util.*;

class Solution {

    static int n, m;
    static int sx, sy, ex, ey;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1}, dy = {1, -1, 0, 0};
    static int answer;

    public int solution(String[] maps) {

        n = maps.length;
        m = maps[0].length();

        board = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {

            board[i] = maps[i].toCharArray();
        }

        // 시작 위치 좌표 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }
            }
        }

        // 레버 찾는 BFS
        int check = bfs(sx, sy, 'L');
        if (check == 0) return -1;
        answer += check;

        // 방문기록 초기화
        visited = new boolean[n][m];

        // 출구 찾는 BFS
        check = bfs(sx, sy, 'E');
        if (check == 0) return -1;
        answer += check;

        return answer;
    }

    private int bfs(int x, int y, char target) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y, 0});
        visited[x][y] = true;

        while (!queue.isEmpty()) {

            int[] qPoll = queue.poll();
            int px = qPoll[0];
            int py = qPoll[1];
            int cnt = qPoll[2];

            if (board[px][py] == target) {
                sx = px;
                sy = py;
                return cnt;
            }

            for (int k = 0; k < 4; k++) {

                int mx = px + dx[k];
                int my = py + dy[k];

                if (!isRange(mx, my)) continue;
                if (visited[mx][my]) continue;

                // 모든 통로, 출구, 레버, 시작점은 여러 번 지나갈 수 있음
                if (board[mx][my] != 'X') {
                    queue.add(new int[] {mx, my, cnt+1});
                    visited[mx][my] = true;
                }
            }
        }

        return 0;
    }

    private boolean isRange(int mx, int my) {

        return 0 <= mx && mx < n && 0 <= my && my < m;
    }
}

public class P159993 {
    public static void main(String[] args) {

    }
}
