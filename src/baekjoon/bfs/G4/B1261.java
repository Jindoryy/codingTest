package baekjoon.bfs.G4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {

            board[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs());
    }

    private static int bfs() {

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0, 0, 0});
        visited[0][0] = true;

        while (!deque.isEmpty()) {
            int[] dequePoll = deque.poll();
            int px = dequePoll[0];
            int py = dequePoll[1];
            int cnt = dequePoll[2];

            if (px == N - 1 && py == M - 1) {
                return cnt;
            }

            for (int k = 0; k < 4; k++) {
                int mx = px + dx[k];
                int my = py + dy[k];

                if (!isRange(mx, my)) continue;
                if (visited[mx][my]) continue;

                if (board[mx][my] == '0') {

                    visited[mx][my] = true;
                    deque.addFirst(new int[]{mx, my, cnt});
                } else if (board[mx][my] == '1') {

                    visited[mx][my] = true;
                    deque.addLast(new int[]{mx, my, cnt+1});
                }
            }
        }

        return 0;
    }

    private static boolean isRange(int mx, int my) {

        return 0 <= mx && mx < N && 0 <= my && my < M;
    }
}