package programmers.brute.level1;

import java.util.*;

class Solution {

    static int floor;        // 총 층 수
    static int[][] board;    // 박스를 쌓을 공간 (층 x 너비)
    static int answer;

    public int solution(int n, int w, int num) {

        // 전체 박스를 w개의 열로 나눠서 쌓을 때 필요한 층 수 계산
        floor = (n + w - 1) / w;  // 올림처리: ceil(n / w)

        board = new int[floor][w];  // 박스를 쌓을 공간 초기화

        // 박스 번호는 1번부터 시작
        int box = 1;

        // 박스를 지그재그로 쌓기
        for (int i = 0; i < floor; i++) {
            for (int j = 0; j < w; j++) {

                // 모든 박스를 다 쌓았으면 중단
                if (box > n) break;

                // 짝수 층: 왼→오, 홀수 층: 오→왼
                if (i % 2 == 0) {
                    board[i][j] = box++;           // 순방향
                } else {
                    board[i][w - j - 1] = box++;   // 역방향
                }
            }
        }

        // 바닥층부터 위층까지 탐색하면서 num이 있는 위치 찾기
        for (int i = floor - 1; i >= 0; i--) {
            for (int j = 0; j < w; j++) {

                // 찾았다면 해당 열에서 위로 몇 개 꺼내야 하는지 세기
                if (board[i][j] == num) {

                    int pickCnt = 0;

                    // i층부터 가장 아래층까지 같은 열(j) 탐색
                    for (int k = floor - 1; k >= i; k--) {
                        if (board[k][j] != 0) {
                            pickCnt += 1;
                        }
                    }

                    return pickCnt;
                }
            }
        }

        // 해당 번호의 박스가 없으면 0 반환
        return 0;
    }
}

public class P389478 {
}
