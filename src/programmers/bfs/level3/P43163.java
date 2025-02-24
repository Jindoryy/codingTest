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
    static int answer;

    public int solution(String begin, String target, String[] words) {

        answer = Integer.MAX_VALUE;
        n = words.length;
        visited = new boolean[n];

        q.add(new Transfer(begin, 0));
        while (!q.isEmpty()) {
            Transfer t = q.poll();
            String word = t.word;
            int cnt = t.cnt;

            if (word.equals(target)) {
                answer = Math.min(answer, cnt);
            }

            for (int i = 0; i < n; i++) {
                int diffCnt = 0;
                if (!visited[i]) {
                    if (diff(word, words[i]) == 1) {
                        visited[i] = true;
                        q.add(new Transfer(words[i], cnt+1));
                    }
                }
            }
        }

        if (answer == Integer.MAX_VALUE) {
            return 0;
        }
        return answer;
    }

    public int diff(String a, String b) {
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
