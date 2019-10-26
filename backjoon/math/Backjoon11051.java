package backjoon.math;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon11051 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int DIV_NUM = 10007;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bw.write(function(n, k) + "\n");
        bw.close();
        br.close();
    }
    public static int function(int n, int k){
        int[][] dp = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= i; j++){
                if(i == j || j == 0) dp[i][j] = 1;
                else{
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % DIV_NUM;
                }
                if(i == n && j == k) break;
            }
        }
        return dp[n][k];
    }
}
