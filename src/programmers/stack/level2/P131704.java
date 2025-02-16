package programmers.stack.level2;

import java.util.*;

class Solution {

    public int solution(int[] order) {

        int answer = 0;
        Stack<Integer> stack = new Stack<>(); // 보조 컨테이너
        int box = 1; // 박스

        for (int i = 0; i < order.length; i++) {

            for (int j = box; j < order[i]; j++) { // 주 컨테이너 첫번째 값이 나올 때 까지 보조 컨테이너에 담기
                stack.push(j);
                box += 1;
            }

            if (box == order[i]) { // 주 컨테이너 확인
                answer += 1;
                box += 1;
            }
            else if (!stack.isEmpty() && stack.peek() == order[i]) { // 보조 컨테이너 확인
                stack.pop();
                answer += 1;
            }
            else { // 둘 다 없으면 STOP
                break;
            }
        }

        return answer;
    }
}

public class P131704 {
    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.solution(new int[] { 4, 3, 1, 2, 5}));
    }
}