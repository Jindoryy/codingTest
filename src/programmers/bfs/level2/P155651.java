package programmers.bfs.level2;

import java.util.*;

class Solution {
    public int solution(String[][] book_time) {

        Arrays.sort(book_time, new Comparator<String[]>() {
            public int compare(String[] o1, String[] o2) {
                return o1[0].compareTo(o2[0]);
            }
        });

        // 최대 객실 수
        int max = 0;
        // 예약 큐
        Queue<int[]> queue = new LinkedList<>();

        // 객실 수 구하기
        for (int i = 0; i < book_time.length; i++) {
            // 현재 예약 시작 시간 (단위 : 분)
            String sHour = book_time[i][0].split(":")[0];
            String sMinute = book_time[i][0].split(":")[1];
            int sTotal = Integer.parseInt(sHour) * 60 + Integer.parseInt(sMinute);
            // 현재 예약 종료 시간 (단위 : 분)
            String eHour = book_time[i][1].split(":")[0];
            String eMinute = book_time[i][1].split(":")[1];
            int eTotal = Integer.parseInt(eHour) * 60 + Integer.parseInt(eMinute) + 10;

            // 예약 큐가 있다면
            if (!queue.isEmpty()) {
                int cnt = 0;
                while (cnt < queue.size()) {
                    int[] room = queue.poll();
                    int start = room[0];
                    int end = room[1];
                    // 예약 큐의 끝나는 시간이 현재 예약 시작시간 보다 크면 (새로운 객실 할당해야 하면) 큐에 꺼낸 예약 집어넣기
                    if (end > sTotal) {
                        queue.add(new int[]{start, end});
                    } else {
                        break;
                    }

                    cnt += 1;
                }
            }

            // 현재 예약 등록
            queue.add(new int[]{sTotal, eTotal});

            max = Math.max(max, queue.size());
        }

        return max;
    }
}

public class P155651 {
    public static void main(String[] args) {

    }
}
