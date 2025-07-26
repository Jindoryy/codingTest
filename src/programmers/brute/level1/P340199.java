package programmers.brute.level1;

import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0; // 지폐를 몇 번 접었는지 카운트할 변수

        while (true) {
            // wallet과 bill을 정렬해서 작은 값은 index 0, 큰 값은 index 1에 위치시키기
            Arrays.sort(wallet); // 지갑 크기 정렬 (작은 값 먼저)
            Arrays.sort(bill);   // 지폐 크기 정렬 (작은 값 먼저)

            // 지폐의 작은 면이 지갑의 작은 면보다 크거나
            // 지폐의 큰 면이 지갑의 큰 면보다 크다면 지갑에 안 들어감 → 접어야 함
            if (bill[0] > wallet[0] || bill[1] > wallet[1]) {

                // 더 긴 변을 반으로 접는다 (지문 조건)
                if (bill[0] > bill[1]) {
                    bill[0] /= 2; // 긴 변이 bill[0]일 경우
                } else {
                    bill[1] /= 2; // 긴 변이 bill[1]일 경우
                }

                // 접은 횟수 증가
                answer += 1;
            } else {
                // 지갑 안에 지폐가 들어갈 수 있는 경우 → 반복 종료
                break;
            }
        }

        return answer; // 총 접은 횟수 반환
    }
}


public class P340199 {
}
