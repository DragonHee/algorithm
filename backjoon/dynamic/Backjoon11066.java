package backjoon.dynamic;

import java.io.*;
import java.util.*;

public class Backjoon11066 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] dp;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        int testCnt = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCnt; i++) {
            int n = Integer.parseInt(br.readLine());
            dp = new int[n + 1][n + 1];
            arr = new int[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= n; j++) arr[j] = Integer.parseInt(st.nextToken());
            for(int j = 1; j < n; j++) dp[j][j + 1] = arr[j] + arr[j + 1];
            solve(1, n);
            bw.write(dp[1][n] + "\n");
        }
        bw.close();
        br.close();
    }
    public static int min(int a, int b){return a > b ? b : a;}
    public static int sum(int a, int b){
        int sum = 0;
        for(int i = a; i <= b; i++) sum += arr[i];
        return sum;
    }
    public static void solve(int x, int y){
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < y - x; i++){
            if(x != x + i && dp[x][x + i] == 0) solve(x, x + i);
            if(x + i + 1 != y && dp[x + i + 1][y] == 0) solve(x + i + 1, y);
            min = min(min, dp[x][x + i] + dp[x + i + 1][y]);
        }
        dp[x][y] = min + sum(x, y);
    }
}
