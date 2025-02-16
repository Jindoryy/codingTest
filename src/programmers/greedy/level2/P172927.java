package programmers.greedy.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    // 각 객체는 다이아몬드 곡괭이, 철 곡괭이, 돌 곡괭이로 캤을 때의 피로도 값
    static class Mineral {
        private int diamond;
        private int iron;
        private int stone;

        public Mineral(int diamond, int iron, int stone) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }
    }

    /*
        1. 한 곡괭이를 사용하여 광물 5개를 연속으로 캐야하므로, 연속된 5개의 광물을 하나의 그룹으로 생각하고 다이아몬드/철/돌 곡괭이를 사용했을때의 피로도를 그룹별로 리스트에 저장
        2. 리스트를 돌 곡괭이를 사용했을 때의 피로도(최악의 경우)를 기준으로 내림차순 정렬
        3. 정렬된 순서대로 현재 가지고 있는 가장 최선의 곡괭이를 사용했을 때의 피로도를 정답에 더해주기
     */
    public int solution(int[] picks, String[] minerals) {

        int answer = 0;
        int[][] pirodo = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}}; // 피로도 소모 값
        int totalPicks = picks[0] + picks[1] + picks[2]; // 곡괭이 개수
        List<Mineral> group = new ArrayList<>();

        for (int i = 0; i < minerals.length; i+=5) { // 광물 5개 연속으로 캐야하므로 피로도 미리 계산
            if (totalPicks == 0) break;

            int diamond = 0, iron = 0, stone = 0;
            for (int j = i; j < i+5; j++) {
                if (j == minerals.length) break;

                String mineral = minerals[j];
                int val = mineral.equals("diamond") ? 0 : mineral.equals("iron") ? 1 : 2;

                diamond += pirodo[0][val];
                iron += pirodo[1][val];
                stone += pirodo[2][val];
            }

            group.add(new Mineral(diamond, iron, stone));
            totalPicks--;
        }

        // 돌 곡괭이가 피로도가 제일 많이 드니깐 돌 곡괭이를 사용했을 때 기준으로 내림차순 정렬
        Collections.sort(group, ((o1, o2) -> o2.stone - o1.stone));

        // 피로도가 많이 드는 그룹부터 다이아몬드->철->돌 순으로 미네랄 캐기
        for (Mineral mineral : group) {
            int diamond = mineral.diamond;
            int iron = mineral.iron;
            int stone = mineral.stone;

            if (picks[0] > 0) {
                answer += diamond;
                picks[0]--;
            }
            else if (picks[1] > 0) {
                answer += iron;
                picks[1]--;
            }
            else if (picks[2] > 0) {
                answer += stone;
                picks[2]--;
            }
        }

        return answer;
    }
}

public class P172927 {
    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.solution(new int[] { 1, 3, 2}, new String[] {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"}));
    }
}