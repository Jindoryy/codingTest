//package baekjoon.dp.level2;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//
//    static int N;
//    static int[] nums;
//    static int[] dp;
//    static int answer;
//
//    public static void main(String[] args) throws IOException {
//
//        System.setIn(new FileInputStream("src/input.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        N = Integer.parseInt(br.readLine());
//        st = new StringTokenizer(br.readLine());
//
//        nums = new int[N];
//        dp = new int[N];
//        for (int i = 0; i < N; i++) {
//            nums[i] = Integer.parseInt(st.nextToken());
//            dp[i] = 1;
//        }
//
//        for (int i = 0; i < N; i++) {
//
//            int num = nums[i];
//            for (int j = i+1; j < N; j++) {
//
//                if (num < nums[j]) {
//                    dp[j] = Math.max(dp[j], dp[i] + 1);
//                }
//            }
//
//            answer = Math.max(answer, dp[i]);
//        }
//
//        System.out.println(answer);
//    }
//}