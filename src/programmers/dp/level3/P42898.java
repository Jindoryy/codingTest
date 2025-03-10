package programmers.dp.level3;

class Solution {

    static final int DISABLE = -1;
    static final int MOD = 1000000007;
    static int[][] dp;

    public int solution(int m, int n, int[][] puddles) {

        dp = new int[n][m];
        for (int[] puddle : puddles) {
            dp[puddle[1]-1][puddle[0]-1] = DISABLE; // 웅덩이
        }

        // INIT
        dp[0][0] = 1; // (0, 0)
        for(int i = 1; i < n; i++) { // 세로
            if (dp[i][0] == DISABLE) break;
            dp[i][0] = 1;
        }
        for(int i = 1; i < m; i++) { // 가로
            if (dp[0][i] == DISABLE) break;
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (dp[i][j] == DISABLE) continue; // 웅덩이는 PASS

                if (dp[i-1][j] == DISABLE) dp[i][j] = dp[i][j-1]; // 위가 안되면 왼쪽만 더하기
                else if (dp[i][j-1] == DISABLE) dp[i][j] = dp[i-1][j]; // 왼쪽이 안되면 위만 더하기
                else { // 위와 왼쪽 더하기
                    dp[i][j] = (dp[i-1][j] % MOD + dp[i][j-1] % MOD) % MOD;
                }
            }
        }

        return dp[n-1][m-1] % MOD;
    }
}

public class P42898 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}
