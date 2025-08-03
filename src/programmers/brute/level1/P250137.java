package programmers.brute.level1;

class Solution {

    public int solution(int[] bandage, int health, int[][] attacks) {

        int nowHealth = health; // 현재 체력
        int sequenceSuccess = 0; // 연속 성공 횟수

        int nowTime = 0; // 현재 시간
        for (int[] attack : attacks) {

            int attackTime = attack[0]; // 공격 시간
            int recoveryTime = attackTime - nowTime - 1; // 회복 시간

            for (int i = 0; i < recoveryTime; i++) { // 마지막 공격 제외하고 회복

                if (nowHealth + bandage[1] > health) {
                    nowHealth = health;
                } else {
                    nowHealth += bandage[1];
                }

                sequenceSuccess += 1;
                if (sequenceSuccess >= bandage[0]) { // 연속 성공 시 추가 회복
                    nowHealth = Math.min(health, nowHealth + bandage[2]);
                    sequenceSuccess = 0;
                }
            }

            nowHealth -= attack[1]; // 공격을 통한 체력 감소
            if (nowHealth <= 0) return -1;

            nowTime = attackTime; // 현재 시간 업데이트
            sequenceSuccess = 0; // 공격 받았으니 연속 성공 횟수 초기화
        }

        return nowHealth;
    }
}

public class P250137 {
}
