package backjoon.dynamic;

import java.io.*;
import java.util.*;

public class Backjoon9252 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static String input1, input2;
    static int[][] dp;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException{
        input1 = br.readLine();
        input2 = br.readLine();
        dp = new int[input1.length() + 1][input2.length() + 1];
        
        solve();

        bw.write(dp[input1.length()][input2.length()] + "\n");
        bw.write(answer.reverse() + "\n");
        bw.close();
        br.close();        
    }

    static void solve(){
        calcDP();
        getLCS(input1.length(), input2.length(), dp[input1.length()][input2.length()]);
    }

    static void calcDP(){
        for(int i = 1 ; i <= input1.length(); i++){
            for(int j = 1 ; j <= input2.length(); j++){
                if(input1.charAt(i - 1) == input2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }

    static void getLCS(int i, int j, int count){
        if(i == 0 || j == 0) return;

        for(int r = i; r >= 1; r--){
            for(int c = j; c >= 1; c--){
                if(dp[r][c] == count && dp[r][c] == dp[r - 1][c - 1] + 1 && Math.max(dp[r - 1][c], dp[r][c - 1]) != dp[r][c]){
                    answer.append(input1.charAt(r - 1) + "");
                    getLCS(r - 1, c - 1, count - 1);
                    return;
                }
            }
        }
    }
}
