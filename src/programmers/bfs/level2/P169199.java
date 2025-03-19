package programmers.bfs.level2;

import java.util.*;

class Solution {

    static int n, m;
    static int sx, sy;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
    static Queue<int[]> q = new LinkedList<>();

    public int solution(String[] board) {

        n = board.length;
        m = board[0].length();
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = board[i].toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'R') {
                    sx = i;
                    sy = j;
                }
            }
        }

        visited = new boolean[n][m];

        return bfs(sx, sy);
    }

    public int bfs(int sx, int sy) {

        q.add(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int px = p[0];
            int py = p[1];
            int cnt = p[2];

            if (map[px][py] == 'G') {
                return cnt;
            }

            for (int k = 0; k < 4; k++) {
                int nx = px;
                int ny = py;

                // 한 방향으로 계속 이동
                while (true) {

                    int mx = nx + dx[k];
                    int my = ny + dy[k];

                    if (!isRange(mx, my) || map[mx][my] == 'D') break;

                    nx = mx;
                    ny = my;
                }

                // 멈춘 위치가 아직 방문하지 않은 곳이라면 큐에 추가
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, cnt + 1});
                }
            }
        }

        return -1;
    }

    public boolean isRange(int mx, int my) {

        return 0 <= mx && mx < n && 0 <= my && my < m;
    }
}

public class P169199 {
    public static void main(String[] args) {

    }
}
