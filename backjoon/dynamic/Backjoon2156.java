package backjoon.dynamic;

import java.io.*;

public class Backjoon2156 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n + 1];
        int dp[] = new int[n + 1];

        for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(br.readLine());

        if(n <= 2) {
            for (int i = 1; i <= n; i++) {
                dp[i] = dp[i - 1] + arr[i];
            }
        }else{
            dp[1] = arr[1];
            dp[2] = arr[2] + arr[1];
            dp[3] = max(arr[1] + arr[2], arr[1] + arr[3], arr[2] + arr[3]);

            for(int i = 4; i <= n; i++) {
                dp[i] = max(dp[i - 4] + arr[i - 2] + arr[i - 1],
                        dp[i - 2] + arr[i],
                        dp[i - 3] + arr[i - 1] + arr[i]);
            }
        }
        bw.write(dp[n] + "\n");
        bw.close();
        br.close();
    }
    private static int max(int a, int b, int c){
        return ((a > b ? a : b) > c) ? ((a > b) ? a : b ) : c;
    }
}
