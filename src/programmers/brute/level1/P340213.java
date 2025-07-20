package programmers.brute.level1;

/*
1. 10초 전: 현재 위치가 10초 미만이면 0초로 이동, 아니면 10초 감소
2. 10초 후: 남은 시간이 10초 미만이면 영상 끝으로 이동, 아니면 10초 증가
3. 오프닝 건너뛰기: 현재 위치가 오프닝 구간이면 오프닝 끝 지점으로 점프
*/

class Solution {

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        // 문자열 시간 → 초(int)로 변환
        int videoSec = allSecond(video_len);     // 전체 영상 길이 (초)
        int posSec = allSecond(pos);             // 현재 위치 (초)
        int opStartSec = allSecond(op_start);    // 오프닝 시작 시각 (초)
        int opEndSec = allSecond(op_end);        // 오프닝 끝 시각 (초)

        // 시작 위치가 오프닝 구간 안이라면, 오프닝 끝으로 점프
        if (opStartSec <= posSec && posSec <= opEndSec) {
            posSec = opEndSec;
        }

        // 각 명령어 순차 처리
        for (String command : commands) {

            if (command.equals("prev")) {
                // "10초 전": 0보다 작아질 수 없으므로 Math.max로 처리
                posSec = Math.max(0, posSec - 10);
            }
            else if (command.equals("next")) {
                // "10초 후": 남은 시간이 10초보다 작으면 끝으로 이동
                posSec = Math.min(videoSec, posSec + 10);
            }

            // 명령 수행 후, 오프닝 구간이면 자동 스킵
            if (opStartSec <= posSec && posSec <= opEndSec) {
                posSec = opEndSec;
            }
        }

        // 결과를 "mm:ss" 형식으로 변환하여 반환
        return toTimeFormat(posSec);
    }

    // "mm:ss" 형식 문자열을 초 단위 정수로 변환
    private int allSecond(String time) {
        String[] split = time.split(":");
        int mm = Integer.parseInt(split[0]);
        int ss = Integer.parseInt(split[1]);
        return mm * 60 + ss;
    }

    // 초 단위 정수를 "mm:ss" 형식 문자열로 변환 (항상 2자리수로 포맷팅)
    private String toTimeFormat(int totalSec) {
        int mm = totalSec / 60;
        int ss = totalSec % 60;
        return String.format("%02d:%02d", mm, ss);
    }
}

public class P340213 {
}
