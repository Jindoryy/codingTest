package programmers.bfs.level3;

import java.util.*;

class Solution {

    boolean[] visited;
    Queue<Integer> q = new LinkedList<>();

    public int solution(int n, int[][] computers) {

        int answer = 0;
        visited = new boolean[n];

        // 0부터 n-1까지 bfs 탐색
        // 네트워크로 묶여있으면 묶고, 아니면 1개의 네트워크
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

    public void bfs(int[][] computers) {

        while (!q.isEmpty()) {
            int x = q.poll();

            for(int j = 0; j < computers.length; j++) {
                if (!visited[j] && computers[x][j] == 1) {
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
