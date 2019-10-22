package backjoon.dynamic;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon1520 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] arr;
    private static int[][] dp;
    private static final byte[] X_ARR = {-1, 0, 1, 0};
    private static final byte[] Y_ARR = {0, 1, 0, -1};
    private static int m;
    private static int n;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[m + 1][n + 1];
        dp = new int[m + 1][n + 1];

        // 입력 값을 배열에 초기화한다.
        for(int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        bw.write(dfs(1,1) + "\n");
        bw.close();
        br.close();
    }
    public static int dfs(int x, int y){
        if(x == m && y == n) return 1;

        if(dp[x][y] == -1){
            dp[x][y] = 0;
            for(int i = 0; i < 4; i++){
                if(isAvail(x + X_ARR[i], y + Y_ARR[i]) && (arr[x][y] > arr[x + X_ARR[i]][y + Y_ARR[i]]))
                    dp[x][y] += dfs(x + X_ARR[i], y + Y_ARR[i]);
            }
        }
        return dp[x][y];

    }
    public static boolean isAvail(int x, int y){
        if(x < 1 || y < 1 || x > m || y > n) return false;
        return true;
    }
}
