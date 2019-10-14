package backjoon.dynamic;

import java.io.*;

public class Backjoon1463 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static long dp[];
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        long min;
        dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2 ; i <= n; i++){
            dp[i] = dp[i - 1] + 1;
            if(i % 3 == 0) dp[i] = min(dp[i], dp[i / 3] + 1);
            if(i % 2 == 0) dp[i] = min(dp[i], dp[i / 2] + 1);
        }
        bw.write(dp[n] + "\n");
        bw.close();
        br.close();
    }
    private static long min(long a, long b){
        return a > b ? b : a;
    }

}
