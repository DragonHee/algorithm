package backjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon14889 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] teamPower;
    private static boolean[] check;
    private static int ans = Integer.MAX_VALUE;
    private static int n;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];
        check = new boolean[n + 1];
        teamPower = new int[n + 1][n + 1];

        for(int i = 1 ; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= n; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1 ; i <= n; i++){
            for(int j = i + 1; j <= n; j++) teamPower[i][j] = arr[i][j] + arr[j][i];
        }
        check[1] = true;
        solve(2, 1);

        bw.write(ans + "\n");
        bw.close();
        br.close();
    }
    private static void solve(int cnt, int num){
       if(cnt == n / 2 + 1){
           int team1 = 0, team2 = 0;

           for(int i = 1; i <= n; i++){
               for(int j = i + 1; j <= n ; j++){
                   if(check[i] && check[j])team1 += teamPower[i][j];
                   else if(!check[i] && !check[j]) team2 += teamPower[i][j];
               }
           }
           ans = Math.min(ans, Math.abs(team1 - team2));
           return;
       }
       else{
           for(int i = num + 1; i <= n / 2 + cnt; i++){
               if(!check[i]){
                   check[i] = true;
                   solve(cnt + 1, i);
                   check[i] = false;
               }
           }
       }
    }
}
