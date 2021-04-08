package backjoon.dynamic;

import java.io.*;

public class Backjoon11727 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int input;
    static int dp[];


    public static void main(String[] args) throws IOException{
        input = Integer.parseInt(br.readLine());

        dp = new int[input + 1];
        
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= input; i++){
            dp[i] = dp[i - 1] + 2 * dp[i - 2];
        }

        bw.write(dp[input] + "\n");

        bw.close();
        br.close();
    }   
}
