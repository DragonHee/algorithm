package backjoon.dynamic;

import java.io.*;

public class Backjoon10844 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static long dp[][];
    private static final int NUM = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        dp = new long[n + 1][10];
        long answer = 0;
        for(int i = 1; i <= 9; i++){
            dp[1][i] = 1;
        }

        for(int i = 2; i <= n; i++){
           for(int j = 0; j <= 9; j++){
               if(j == 0) dp[i][j] = dp[i - 1][j + 1] % NUM;
               else if(j >= 1 && j <= 8) dp[i][j] = dp[i - 1][j - 1] % NUM + dp[i - 1][j + 1]  % NUM;
               else dp[i][j] = dp[i - 1][j - 1] % NUM;
           }
        }

        for(int i = 0 ; i <= 9; i++){
            answer =  (answer + dp[n][i]) % NUM;
        }
        bw.write(answer % 1_000_000_000 + "\n");
        bw.close();
        br.close();
    }
}
