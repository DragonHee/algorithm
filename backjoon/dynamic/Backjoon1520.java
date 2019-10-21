package backjoon.dynamic;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon1520 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m + 1][n + 1];
        int[][] dp = new int[m + 1][n + 1];
        // 입력 값을 배열에 초기화한다.
        for(int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][1] = 1;
        for(int i = 2; i <= m ; i++) {
            dp[i][1] = arr[i - 1][1] > arr[i][1] ? 1 : 0;
        }
        for(int i = 2; i <= n ; i++) {
            dp[1][i] = arr[1][i - 1] > arr[1][i] ? 1 : 0;
        }

        for(int i = 2; i <= m; i++){
            for(int j = 2; j <= n; j++){
                dp[i][j] = (arr[i - 1][j] > arr[i][j] ? dp[i - 1][j] : 0)
                        + (arr[i][j - 1] > arr[i][j] ? dp[i][j - 1] : 0);
                if(arr[i - 1][j] < arr[i][j]) dp[i - 1][j] += dp[i][j];
                if(arr[i][j - 1] < arr[i][j]) dp[i][j - 1] += dp[i][j];
            }
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                bw.write(dp[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.write(dp[m][n] + "\n");
        bw.close();
        br.close();
    }
}
