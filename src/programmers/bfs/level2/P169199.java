package programmers.bfs.level2;

import java.util.*;

class Solution {

    static int n, m;
    static int sx, sy;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};

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
                    break;
                }
            }
        }

        visited = new boolean[n][m];

        return bfs();
    }

    private int bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {sx, sy, 0});
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {

            int[] qPoll = queue.poll();
            int px = qPoll[0];
            int py = qPoll[1];
            int cnt = qPoll[2];

            if (map[px][py] == 'G') {
                return cnt;
            }

            for (int k = 0; k < 4; k++) {

                int nx = px;
                int ny = py;

                while(true) {

                    int mx = nx + dx[k];
                    int my = ny + dy[k];

                    if (!isRange(mx, my)) break;
                    if (map[mx][my] == 'D') break;

                    nx = mx;
                    ny = my;
                }

                // 방문하지 않았다는 것은 최소의 이동으로 방문하지 않았던 곳을 도착했다는 의미
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny, cnt+1});
                }
            }
        }

        return -1;
    }

    private boolean isRange(int mx, int my) {

        return 0 <= mx && mx < n && 0 <= my && my < m;
    }
}

public class P169199 {
    public static void main(String[] args) {

    }
}
