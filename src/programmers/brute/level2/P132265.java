package programmers.brute.level2;

class Solution {
    public int solution(int[] topping) {

        int answer = 0;

        int[] cake1 = new int[10000+1];
        int[] cake2 = new int[10000+1];
        int cake1Cnt = 0;
        int cake2Cnt = 0;

        for (int i = 0; i < topping.length; i++) {

            int topp = topping[i];

            // 우선 cake2에 전부 토핑이 있다고 가정
            if (cake2[topp] == 0) cake2Cnt += 1;
            cake2[topp] += 1;
        }

        for (int i = 0; i < topping.length; i++) {

            int topp = topping[i];

            // 계속 자르면서 토핑의 개수 비교
            if (cake1[topp] == 0) cake1Cnt += 1;
            cake1[topp] += 1;

            if (cake2[topp] == 1) cake2Cnt -= 1;
            cake2[topp] -= 1;

            if (cake1Cnt == cake2Cnt) {
                answer += 1;
            }
        }

        return answer;
    }
}

public class P132265 {
    public static void main(String[] args) {

    }
}
