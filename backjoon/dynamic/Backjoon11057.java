package backjoon.dynamic;

import java.io.*;

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
        int[][] dp = new int[N + 2][10];
        dp[1][0] = 1;

        for(int i = 1; i <= N; i++){
            int sum = dp[i][0];

            for(int j = 1 ; j <= 9; j++){
                dp[i][j] = dp[i][j - 1] - dp[i - 1][j - 1];
                if(dp[i][j] < 0) dp[i][j] += 10007;
               
                sum += dp[i][j];
            }
            dp[i + 1][0] = sum % 10007;
        }

        answer = dp[N + 1][0];
    }
}
