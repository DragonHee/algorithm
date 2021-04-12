package backjoon.greedy;

import java.util.*;
import java.io.*;

public class Backjoon13305 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static long[] cost;
    static long[] distance;
    static long[] dp;

    public static void main(String[] args) throws NumberFormatException, IOException{
        N = Integer.parseInt(br.readLine());

        cost = new long[N];
        distance = new long[N];
        dp = new long[N + 1];

        // 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N; i++) 
            distance[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N; i++)
            cost[i] = Integer.parseInt(st.nextToken());
        
        // 최솟값의 주유비
        long keyCost = cost[1];
        dp[2] = cost[1] * distance[1];

        for(int i = 3; i <= N; i++){
            if(keyCost * distance[i - 1] > cost[i - 1] * distance[i - 1]){
                dp[i] = dp[i - 1] + cost[i - 1] * distance[i - 1];
                // 최솟값이 변경되면 주유비 key도 변경시켜줌
                keyCost = cost[i - 1];
            }else{
                dp[i] = dp[i - 1] + keyCost * distance[i - 1];
            }
        }

        bw.write(dp[N] + "\n");
        bw.close();
        br.close();    
    }
}
