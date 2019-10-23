package backjoon.dynamic;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon12865 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int [] wArr = new int[n + 1];
        int [] vArr = new int[n + 1];
        dp = new int[n + 1][k + 1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            wArr[i] = Integer.parseInt(st.nextToken());
            vArr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= k; j++){
                if(j < wArr[i]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - wArr[i]] + vArr[i]);
            }
        }

        bw.write(dp[n][k] + "\n");
        bw.close();
        br.close();

    }
    private static int max(int a, int b){return a > b ? a : b;}
}
