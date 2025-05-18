package programmers.stack.level2;

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int [] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n-1; i >= 0; i--) {
            // 현재 숫자보다 작거나 같은 값은 스택에서 제거
            while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }

            answer[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.add(numbers[i]);
        }

        return answer;
    }
}

public class P154939 {
    public static void main(String[] args) {

    }
}
