package programmers.bfs.level2;

import java.util.*;

// 레버 찾는 BFS, 출구 찾는 BFS 총 2번 돌리면 되지 않나?
/*
    1. 레버 찾는 BFS 돌린 후 큐 초기화 하는거 생각 못함.
    2. 레버 찾는 BFS (O), 출구 찾는 BFS(X)인 경우 생각 못함.
*/
class Solution {

    static int n, m;
    static int sx, sy;
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
    static boolean[][] visited;
    static char[][] board;
    static Queue<int[]> queue = new LinkedList<>();

    public int solution(String[] maps) {

        n = maps.length;
        m = maps[0].length();
        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = maps[i].toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'S') {
                    sx = i;
                    sy = j;
                    break;
                }
            }
        }

        // 총 이동횟수
        int cnt = 0;

        // 레버 찾는 BFS
        visited = new boolean[n][m];
        int check = bfs(sx, sy, 'L');
        if (check == 0) return -1;
        cnt += check;

        // 도착지 찾는 BFS
        queue.clear();
        visited = new boolean[n][m];
        check = bfs(sx, sy, 'E');
        if (check == 0) return -1;
        cnt += check;

        return cnt;
    }

    public int bfs(int x, int y, char target) {

        queue.add(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int px = p[0];
            int py = p[1];
            int cnt = p[2];

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

                if (board[mx][my] != 'X') {
                    visited[mx][my] = true;
                    queue.add(new int[]{mx, my, cnt+1});
                }
            }
        }

        return 0;
    }

    public boolean isRange(int mx, int my) {
        return 0 <= mx && mx < n && 0 <= my && my < m;
    }
}

public class P159993 {
    public static void main(String[] args) {

    }
}
