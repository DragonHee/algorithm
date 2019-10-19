package backjoon.dynamic;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon1912 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int max, n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n + 1];
        int[] checkArr =  new int[n + 1];
        int[] dp = new int[n + 1];

        for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++){
            int check = checkArr[i - 1] + arr[i];
            checkArr[i] = check > 0 ? check : 0;
            dp[i] = max(dp[i - 1], checkArr[i]);
        }

        if(dp[n] == 0){
            max = arr[1];
            for(int i = 2; i <= n; i++){
                max = max(max, arr[i]);
            }
        }else max = dp[n];
        bw.write(max + "\n");
        bw.close();
        br.close();
    }
    public static int max(int a, int b){return a > b ? a : b;}
}
