package programmers.bfs.level2;

import java.util.*;

class Solution {

    public int solution(String[][] book_time) {

        // 객실의 개수
        int roomCnt = 0;
        // 예약 시간 리스트 (시작 순으로 정렬)
        Arrays.sort(book_time, (o1, o2) -> o1[0].compareTo(o2[0]));
        // 예약 우선순위 큐 (가장 빨리 끝나는 순으로 정렬)
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        for (int i = 0; i < book_time.length; i++) {

            String sHour = book_time[i][0].split(":")[0];
            String sMinute = book_time[i][0].split(":")[1];
            int sTotal = Integer.parseInt(sHour) * 60 + Integer.parseInt(sMinute);

            String eHour = book_time[i][1].split(":")[0];
            String eMinute = book_time[i][1].split(":")[1];
            int eTotal = Integer.parseInt(eHour) * 60 + Integer.parseInt(eMinute) + 10;

            if (pq.isEmpty()) {
                roomCnt += 1;
                pq.add(new int[] {sTotal, eTotal});
                continue;
            }

            // 예약 우선순위 큐 중에 가장 빨리 끝나는 예약 반환
            int[] prevTime = pq.poll();

            /**
             * 현재 예약의 시작시간이 가장 빨리 끝나는 예약 종료시간보다 빠른 경우
             * 큐에서 꺼낸 예약을 다시 넣고 객실의 개수 + 1
             */
            if (sTotal < prevTime[1]) {
                pq.add(prevTime);
                roomCnt += 1;
            }

            // 현재 예약은 무조건 큐에 넣음 (예약 리스트 비교를 위해서)
            pq.add(new int[] {sTotal, eTotal});
        }

        return roomCnt;
    }
}

public class P155651 {
    public static void main(String[] args) {

    }
}
