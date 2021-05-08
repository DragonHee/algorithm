package backjoon.dynamic;

import java.io.*;
import java.util.*;

public class Backjoon2225 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, K;
    static int answer;

    static final int DIV_NUM = 1000000000;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        solve();

        bw.write(answer + "\n");
        bw.close();
        br.close();
    }

    public static void solve(){
        int[][] dp = new int[N + 1][K + 1];

        for(int i = 1; i <= K; i++){
            dp[1][i] = i;
        }

        for(int i = 2; i <= N; i++){
            for(int j = 1; j <= K; j++){
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % DIV_NUM;
            }
        }

        answer = dp[N][K];
    }

}
