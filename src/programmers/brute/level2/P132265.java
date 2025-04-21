package programmers.brute.level2;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        int[] cake1 = new int[10001];
        int[] cake2 = new int[10001];
        int n = topping.length;
        int cake1_cnt = 0; // 토핑 종류
        int cake2_cnt = 0; // 토핑 종류

        for (int i = 0; i < n; i++) {
            cake2[topping[i]] += 1;
            if (cake2[topping[i]] == 1) cake2_cnt += 1;
        }

        for (int i = 0; i < n; i++) {
            cake1[topping[i]] += 1;
            if (cake1[topping[i]] == 1) cake1_cnt += 1;

            cake2[topping[i]] -= 1;
            if (cake2[topping[i]] == 0) cake2_cnt -= 1;

            if (cake1_cnt == cake2_cnt) answer += 1;
        }

        return answer;
    }
}

public class P132265 {
    public static void main(String[] args) {

    }
}
