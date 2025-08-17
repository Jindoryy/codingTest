package programmers.brute.level1;

import java.util.*;

class Solution {

    static int extIndex;    // 조건 필터링에 사용할 열(column) 인덱스
    static int sortByIndex; // 정렬 기준이 되는 열(column) 인덱스

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        List<int[]> list = new ArrayList<>();
        // data 배열의 각 열 이름 (code, date, maximum, remain)
        String[] col = {"code", "date", "maximum", "remain"};

        // ext, sort_by 문자열에 해당하는 인덱스 찾기
        for (int i = 0; i < 4; i++) {
            if (col[i].equals(ext)) extIndex = i;         // 조건 비교용 컬럼 인덱스
            if (col[i].equals(sort_by)) sortByIndex = i;  // 정렬 기준 컬럼 인덱스
        }

        // 조건: data[i][extIndex] < val_ext 인 데이터만 추출
        for (int i = 0; i < data.length; i++) {
            if (data[i][extIndex] < val_ext)
                list.add(data[i]);
        }

        // List → 2차원 배열로 변환
        int[][] answer = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        // 정렬 (sortByIndex 기준 오름차순)
        Arrays.sort(answer, (a, b) -> {
            return a[sortByIndex] - b[sortByIndex];
        });

        return answer;
    }
}

public class P250121 {
}
