package backjoon.dynamic;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon11053 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int max = 0, i, j, n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        StringTokenizer input = new StringTokenizer(br.readLine(), " ");

        for(i = 1; i <= n; i++) arr[i] = Integer.parseInt(input.nextToken());

        for(i = 1; i <= n; i++){
            for(j = 0; j <= i - 1; j++){
                if(arr[j] < arr[i]){
                    dp[i] = max(dp[j] + 1, dp[i]);
                }
            }
        }
        for(i = 1; i <= n; i++) max = max(dp[i],max);
        bw.write(max + "\n");
        bw.close();
        br.close();
    }
    public static int max(int a, int b){
        return (a > b) ? a : b;
    }
}
