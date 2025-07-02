package programmers.bfs.level3;

import java.util.*;

class Solution {

    static class Transfer {

        String word;
        int cnt;

        Transfer(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }

    static int n;
    static boolean[] visited;
    static Queue<Transfer> q = new LinkedList<>();

    public int solution(String begin, String target, String[] words) {

        n = words.length;
        q.add(new Transfer(begin, 0));

        visited = new boolean[n];
        while (!q.isEmpty()) {

            Transfer t = q.poll();
            String word = t.word;
            int cnt = t.cnt;

            if (word.equals(target)) {
                return cnt;
            }

            for (int i = 0; i < n; i++) {

                if (!visited[i] && diff(word, words[i]) == 1) {
                    visited[i] = true;
                    q.add(new Transfer(words[i], cnt+1));
                }
            }
        }

        return 0;
    }

    private int diff(String a, String b) {

        int diffCnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {

                diffCnt += 1;
            }
        }

        return diffCnt;
    }
}

public class P43163 {
    public static void main(String[] args) {

        Solution solution = new Solution();

    }
}
