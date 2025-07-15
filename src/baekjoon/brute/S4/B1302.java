package baekjoon.brute.S4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static Map<String, Integer> hashmap = new TreeMap<>();
    static String answer;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            hashmap.put(word, hashmap.getOrDefault(word, 0) + 1);
        }

        int sellCnt = 0;
        for (Map.Entry<String, Integer> entry : hashmap.entrySet()) {

            Integer value = entry.getValue();
            if (sellCnt < value) {
                sellCnt = value;
                answer = entry.getKey();
            }
        }

        System.out.println(answer);
    }
}