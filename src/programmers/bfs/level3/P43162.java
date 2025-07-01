package programmers.bfs.level3;

import java.util.*;

class Solution {

    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();
    static int answer;

    public int solution(int n, int[][] computers) {

        visited = new boolean[n];
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                visited[i] = true;
                q.add(i);
                bfs(computers);
                answer += 1;
            }
        }

        return answer;
    }

    private void bfs(int[][] computers) {

        while (!q.isEmpty()) {

            int v = q.poll();

            for (int j = 0; j < computers.length; j++) {

                if (!visited[j] && computers[v][j] == 1) {
                    visited[j] = true;
                    q.add(j);
                }
            }
        }
    }
}

public class P43162 {

    public static void main(String[] args) {

        Solution solution = new Solution();

    }
}
