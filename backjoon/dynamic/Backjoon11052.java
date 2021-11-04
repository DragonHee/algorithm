package backjoon.dynamic;

import java.util.*;
import java.io.*;

public class Backjoon11052 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int totalCardCnt;
    static int[] cardCostArr;

    public static void main(String[] args) throws IOException {
        totalCardCnt = Integer.parseInt(br.readLine());
        cardCostArr = new int[totalCardCnt + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= totalCardCnt; i++){
            cardCostArr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = solve();

        bw.write(answer + "\n");

        bw.close();
        br.close();        
    }

    public static int solve(){
        int[][] dp = new int[totalCardCnt + 1][totalCardCnt + 1];
        int maxValue = Integer.MIN_VALUE;

        for(int i = 1; i <= totalCardCnt; i++){
            for(int j = 1; j <= totalCardCnt; j++){
                if(j - i < 0) {
                    dp[i][j] = dp[i - 1][j];

                }
                else{
                    dp[i][j] = Math.max(Math.max(dp[i - 1][j - i], dp[i][j - i]) + cardCostArr[i], dp[i - 1][j]);
                    maxValue = Math.max(dp[i][j], maxValue);
                }
            }
        }

        return maxValue;
    }
}
