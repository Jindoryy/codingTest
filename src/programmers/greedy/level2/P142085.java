package programmers.greedy.level2;

import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        // 적군 수 우선순위 큐(내림차순)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // 게임 진행
        for (int i = 0; i < enemy.length; i++) {
            if (n < enemy[i] && k == 0) break; // 병사도 부족하고, 무적권도 없는 경우

            pq.add(enemy[i]); // 적군 수 우선순위 큐에 추가
            if (n < enemy[i]) { // 병사가 부족해서 무적권을 사용할 경우
                n += pq.poll(); // 지금까지 가장 많았던 적군 수 만큼 채우기 (지금 라운드 포함)
                k -= 1; // 무적권 사용
            }
            n -= enemy[i]; // 병사 사용
            answer += 1; // 라운드 추가
        }

        return answer;
    }
}

public class P142085 {
    public static void main(String[] args) {

    }
}
