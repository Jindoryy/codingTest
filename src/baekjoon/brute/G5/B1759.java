package baekjoon.brute.G5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1759 {

    static int L, C;
    static char[] alphabet;
    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabet = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alphabet[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alphabet);

        combination(0, 0, new char[L]);
    }

    private static void combination(int depth, int idx, char[] tmp) {

        if (depth == L) {
            if (check(tmp)) {
                print(tmp);
            }
            return;
        }

        // 조합
        for (int i = idx; i < alphabet.length; i++) {

            tmp[depth] = alphabet[i];
            combination(depth + 1, i+1, tmp);
        }
    }

    private static boolean check(char[] tmp) {

        int vowelCnt = 0; // 모음의 개수

        for (int i = 0; i < tmp.length; i++) {

            for (int j = 0; j < vowels.length; j++) {

                if (tmp[i] == vowels[j]) {
                    vowelCnt += 1;
                }
            }
        }

        return 0 < vowelCnt && vowelCnt <= L-2? true : false;
    }

    private static void print(char[] tmp) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tmp.length; i++) {
            sb.append(tmp[i]);
        }
        System.out.println(sb.toString());
    }
}