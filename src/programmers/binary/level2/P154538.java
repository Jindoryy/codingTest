package programmers.binary.level2;

import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        boolean[] visited = new boolean[1000001];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, 0});
        visited[x] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int num = current[0];
            int cnt = current[1];

            if (num == y) return cnt;

            if (num + n <= 1000000 && !visited[num + n]) {
                visited[num + n] = true;
                queue.add(new int[] {num + n, cnt + 1});
            }
            if (num * 2 <= 1000000 && !visited[num * 2]) {
                visited[num * 2] = true;
                queue.add(new int[] {num * 2, cnt + 1});
            }
            if (num * 3 <= 1000000 && !visited[num * 3]) {
                visited[num * 3] = true;
                queue.add(new int[] {num * 3, cnt + 1});
            }
        }

        return -1; // 도달할 수 없는 경우
    }
}


public class P154538 {
    public static void main(String[] args) {

    }
}
