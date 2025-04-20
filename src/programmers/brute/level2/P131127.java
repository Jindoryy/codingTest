package programmers.brute.level2;

import java.util.*;

class Solution {

    static Map<String, Integer> itemMap = new HashMap<>();

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        int n = want.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            itemMap.put(want[i], number[i]);
            cnt += number[i];
        }

        int m = discount.length;
        for (int i = 0; i < m-cnt+1; i++) {

            Map<String, Integer> cItemMap = new HashMap<>(itemMap);
            for (int j = 0; j < cnt; j++) {

                String item = discount[i+j];
                if (cItemMap.containsKey(item)) {
                    cItemMap.put(item, cItemMap.get(item) - 1);
                }
            }

            boolean isLeft = false;
            for (int value : cItemMap.values()) {

                if (value > 0) {
                    isLeft = true;
                    break;
                }
            }

            if (!isLeft) {
                answer += 1;
            }
        }

        return answer;
    }
}

public class P131127 {
    public static void main(String[] args) {

    }
}
