package backjoon.samsung_sw_test;

import java.util.*;
import java.io.*;

public class Backjoon14501 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
    static int[] timeArr, priceArr;
    static int[] dp;
    static int N;
    static int answer;
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        timeArr = new int[N + 1];
        priceArr = new int[N + 1];
        dp = new int[N + 1];

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            timeArr[i] = Integer.parseInt(st.nextToken());
            priceArr[i] = Integer.parseInt(st.nextToken());
        }

        solve();

        bw.write(answer + "\n");
        bw.close();
        br.close();
    }

    static void solve(){

        if(timeArr[1] == 1){
            dp[1] = priceArr[1];
        }
        
        
        for(int cur = 1; cur <= N; cur++){
            int time = timeArr[cur];
            int price = priceArr[cur];

            if(cur + time - 1 <= N) dp[cur + time - 1] = Math.max(dp[cur + time - 1], dp[cur - 1] + price);
                
            dp[cur] = Math.max(dp[cur], dp[cur - 1]);
            answer = Math.max(answer, dp[cur]);
        }
    }
}
