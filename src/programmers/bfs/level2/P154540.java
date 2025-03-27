package programmers.bfs.level2;

import java.util.*;

class Solution {

    static int n, m;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
    static Queue<int[]> queue = new LinkedList<>();
    static List<Integer> list = new ArrayList<>();

    public int[] solution(String[] maps) {

        n = maps.length;
        m = maps[0].length();
        board = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = maps[i].toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] != 'X' && !visited[i][j]) {
                    int cnt = bfs(i, j);
                    list.add(cnt);
                }
            }
        }

        int k = list.size();
        if (k == 0) return new int[]{-1};
        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }

    private int bfs(int x, int y) {

        int cnt = board[x][y] - '0';
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            int px = q[0];
            int py = q[1];

            for (int k = 0; k < 4; k++) {
                int mx = px + dx[k];
                int my = py + dy[k];

                if (!isRange(mx, my)) continue;
                if (visited[mx][my]) continue;

                if (board[mx][my] != 'X') {
                    cnt += board[mx][my] - '0';
                    visited[mx][my] = true;
                    queue.add(new int[]{mx, my});
                }
            }
        }

        return cnt;
    }

    private boolean isRange(int mx, int my) {
        return 0 <= mx && mx < n && 0 <= my && my < m;
    }
}

public class P154540 {
    public static void main(String[] args) {

    }
}
