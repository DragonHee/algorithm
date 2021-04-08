package backjoon.dynamic;

import java.io.*;

public class Backjoon1309 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int input;
    static int[] dp;
    static final int DIVIDE_NUM = 9901;

    public static void main(String[] args) throws IOException{
        input = Integer.parseInt(br.readLine());

        dp = new int[input + 1];
        
        dp[0] = 1;
        dp[1] = 3;

        for(int i = 2; i <= input; i++){
            dp[i] = (2 * dp[i - 1] + dp[i - 2]) % DIVIDE_NUM;
        }

        bw.write(dp[input] + "\n");

        bw.close();
        br.close();
    }
    
}
