package programmers.brute.level2;

import java.util.*;

class Solution {

    public int solution(int[][] points, int[][] routes) {
        int answer = 0; // 서로 다른 로봇이 동일한 위치에서 동시에 만난 횟수

        // <포인트 번호, 해당 포인트의 좌표>
        Map<Integer, int[]> pointMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            pointMap.put(i + 1, points[i]);
        }

        // <시간, <"r,c" 위치 문자열, 해당 시간에 그 위치에 있는 로봇 수>>
        Map<Integer, Map<String, Integer>> timeMap = new HashMap<>();

        int maxTime = 0; // 모든 로봇 경로 중 최대 시간 (계산 범위 확보용)

        // 각 로봇의 이동 경로 처리
        for (int[] route : routes) {
            int time = 0;

            // 시작 지점의 좌표
            int[] start = pointMap.get(route[0]);
            addToTimeMap(timeMap, time, start[0], start[1]); // 시작 위치에 로봇 존재 기록

            // 경로를 따라 포인트 간 이동 처리
            for (int i = 0; i < route.length - 1; i++) {
                int[] from = pointMap.get(route[i]);
                int[] to = pointMap.get(route[i + 1]);

                int r = from[0];
                int c = from[1];

                // 1. 세로 이동 (r 좌표 변경)
                while (r != to[0]) {
                    r += (to[0] > r) ? 1 : -1;
                    time += 1;
                    addToTimeMap(timeMap, time, r, c);
                }

                // 2. 가로 이동 (c 좌표 변경)
                while (c != to[1]) {
                    c += (to[1] > c) ? 1 : -1;
                    time += 1;
                    addToTimeMap(timeMap, time, r, c);
                }
            }

            maxTime = Math.max(maxTime, time); // 최대 이동 시간 갱신
        }

        // 시간별로 같은 위치에 2개 이상의 로봇이 있었던 경우를 카운트
        for (int t = 0; t <= maxTime; t++) {
            Map<String, Integer> map = timeMap.getOrDefault(t, new HashMap<>());
            for (int count : map.values()) {
                if (count >= 2) {
                    answer += 1;
                }
            }
        }

        return answer;
    }

    /**
     * 시간별 위치에 로봇이 도달한 횟수를 기록하는 유틸 함수
     *
     * @param timeMap 전체 시간-위치 기록 맵
     * @param time 현재 시간
     * @param r 행 좌표
     * @param c 열 좌표
     */
    private void addToTimeMap(Map<Integer, Map<String, Integer>> timeMap, int time, int r, int c) {
        timeMap.putIfAbsent(time, new HashMap<>());

        Map<String, Integer> map = timeMap.get(time);
        String key = r + "," + c;

        map.put(key, map.getOrDefault(key, 0) + 1); // 해당 좌표에 로봇 추가
    }
}


public class P340211 {
}
