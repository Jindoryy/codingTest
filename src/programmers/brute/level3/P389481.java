package programmers.brute.level3;

import java.util.*;

class Solution {

    public String solution(long n, String[] bans) {

        // 삭제할 금지된 문자열 개수
        int N = bans.length;

        // 금지 문자열을 숫자로 변환하여 저장
        long[] bansNum = new long[N];
        for (int i = 0; i < N; i++) {
            bansNum[i] = strToNum(bans[i]);
        }

        // 금지 문자열 숫자들을 정렬 (숫자 순서대로 빠르게 탐색하기 위해)
        Arrays.sort(bansNum);

        // 금지된 문자열의 숫자보다 같거나 작으면 해당 문자열은 스킵 → n++
        for (long num : bansNum) {
            if (num <= n) {
                n++; // 그 숫자가 금지되었으므로, 다음 문자열로 넘어감
            } else {
                break; // bansNum은 정렬되어 있으므로 더 이상 비교할 필요 없음
            }
        }

        // 최종적으로 남은 n번째 문자열을 계산하여 반환
        return numToStr(n);
    }

    /**
     * 알파벳 문자열을 숫자로 변환
     * 예: "a" → 1, "z" → 26, "aa" → 27, "ab" → 28, ...
     * 26진법과 유사하지만, 1-based로 동작 (즉, 'a' = 1)
     */
    private long strToNum(String str) {
        long num = 0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            num = num * 26 + (str.charAt(i) - 'a' + 1);
        }
        return num;
    }

    /**
     * 숫자를 알파벳 문자열로 변환 (strToNum의 역변환)
     * 예: 1 → "a", 26 → "z", 27 → "aa", 28 → "ab", ...
     * 핵심: 나머지가 0일 경우 'z'로 처리하고, 몫을 하나 줄이는 로직 필요
     */
    private String numToStr(long num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            num--; // 1-based index를 0-based로 맞추기 위해 감소
            int remain = (int)(num % 26); // 현재 자리 문자 결정
            sb.append((char)('a' + remain)); // 알파벳 문자 추가
            num /= 26; // 다음 자리 수 계산
        }
        return sb.reverse().toString(); // 계산은 뒤에서부터 했기 때문에 뒤집어서 반환
    }
}

public class P389481 {
}
