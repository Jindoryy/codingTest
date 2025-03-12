package programmers.dp.level3;

import java.util.*;

class Solution {

    static int[] circularElements;
    static Set<Integer> answer = new HashSet<>();

    public int solution(int[] elements) {

        int n = elements.length;
        circularElements = new int[n * 2];
        for (int i = 0; i < n; i++) {
            circularElements[i] = elements[i];
        }
        for (int i = n; i < n*2; i++) {
            circularElements[i] = elements[i - n];
        }

        int[] prefixSum = new int[n * 2 + 1];
        for (int i = 1; i <= n*2; i++) {
            prefixSum[i] = prefixSum[i-1] + circularElements[i-1];
        }
        for (int i = 0; i <= n*2; i++) {
            for (int j = i+1; j <= n*2; j++) {
                if (j - i > n) break;
                answer.add(prefixSum[j] - prefixSum[i]);
            }
        }

        return answer.size();
    }
}

public class P131701 {
    public static void main(String[] args) {

    }
}
