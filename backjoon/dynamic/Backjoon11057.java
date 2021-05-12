package backjoon.dynamic;

import java.io.*;
import java.util.*;

public class Backjoon11057 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int answer;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        solve();

        bw.write(answer + "\n");
        bw.close();
        br.close();
    }
    
    static void solve(){
        int[][] dp = new int[N + 1][11];
        dp[0][10] = 1;

        for(int i = 1; i <= N; i++){
            int sum = 0;

            for(int j = 0 ; j <= 9; j++){
                if(j == 0) dp[i][j] = dp[i - 1][10] % 10007;
                else dp[i][j] = dp[i][j - 1] - dp[i - 1][j - 1] < 0 ? dp[i][j - 1] - dp[i - 1][j - 1] + 10007 : dp[i][j - 1] - dp[i - 1][j - 1];
                sum += dp[i][j];
            }
            dp[i][10] = sum % 10007;
        }

        answer = dp[N][10];
    }
}
