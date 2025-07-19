package programmers.brute.level1;

class Solution {

    static int answer;

    public int solution(int[] schedules, int[][] timelogs, int startday) {

        for (int i = 0; i < timelogs.length; i++) {

            // 1. 출근 인정 시각 계산 (희망 시각 + 10분)
            int hour = schedules[i] / 100;     // 희망 시각의 시(hour) 추출
            int minute = schedules[i] % 100;   // 희망 시각의 분(minute) 추출

            minute += 10;                      // 10분 추가
            if (minute >= 60) {                // 60분 초과 시
                hour += 1;                     // 시(hour) +1
                minute -= 60;                  // 분(minute) -60
            }

            int schedule = hour * 100 + minute;  // 다시 시각 형태로 변환 (HHMM)

            int cnt = 0;  // 출근 인정 일수 카운트

            // 2. 한 주간의 출근 기록 확인
            for (int j = 0; j < timelogs[i].length; j++) {

                // 요일 계산 (1: 월 ~ 7: 일)
                int checkDay = (j + startday) % 7;

                // 주말(토:6, 일:0)은 체크하지 않음
                if (checkDay == 6 || checkDay == 0) continue;

                int timelog = timelogs[i][j];  // 해당 요일의 실제 출근 시각

                // 출근 인정 시각보다 같거나 빠르게 출근한 경우
                if (timelog <= schedule) {
                    cnt += 1;
                }
            }

            // 3. 평일 5일 모두 출근 인정 시
            if (cnt == 5) {
                answer += 1;
            }
        }

        return answer;  // 최종 출근 인정된 인원 수 반환
    }
}


public class P388351 {
}
