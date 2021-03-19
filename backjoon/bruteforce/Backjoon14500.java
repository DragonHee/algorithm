package backjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Backjoon14500 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[][] arr;
    static boolean[][] check;
    static int MAX = 0;
    static int[] rowArr = new int[]{0,1,0,-1};
    static int[] colArr = new int[]{1,0,-1,0};

    public static void main(String[] arsgs) throws IOException{
        int cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];
        check = new boolean[N + 1][M + 1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();

        bw.write(MAX + "\n");
        
        bw.close();
        br.close();
    }

    private static void solve(){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j  <= M; j++){
                check[i][j] = true;
                dfs(i, j, arr[i][j], 1);
                check[i][j] = false;
                // ㅗ, ㅏ , ㅜ, ㅓ 모양의 테트로미노 계산
                extraCalc(i, j);
            }
        }
    }

    private static void dfs(int row, int col, int sum, int length){
        if(length == 4){
            MAX = Math.max(sum, MAX);
            return;
        }
      
        for(int i = 0 ; i < 4; i++){
            int toRow = row + rowArr[i];
            int toCol = col + colArr[i];

            if(toRow < 1 || toRow > N || toCol < 1 || toCol > M) continue;
            if(check[toRow][toCol] == true) continue;
            
            check[toRow][toCol] = true;
            dfs(toRow, toCol, sum + arr[toRow][toCol], length + 1);
            check[toRow][toCol] = false;
        } 
    }

    private static void extraCalc(int row, int col){
        // ㅗ 모양 테트리노스
        if(row + 1 > N || col + 1 > M || col - 1 < 1) ;
        else {
            int tot = 0;
            tot = arr[row][col] + arr[row + 1][col - 1] + arr[row + 1][col] + arr[row + 1][col + 1];
            MAX = Math.max(tot, MAX);
        }
        // ㅏ 모양 테트리노스
        if(row + 1 > N || row - 1 < 1 || col - 1 < 1) ;
        else {
            int tot = 0;
            tot = arr[row][col] + arr[row + 1][col - 1] + arr[row][col - 1] + arr[row - 1][col - 1];
            MAX = Math.max(tot, MAX);
        }
        // ㅜ 모양 테트리노스
        if(row - 1 < 1 || col - 1 < 1 || col + 1 > M) ;
        else {
            int tot = 0;
            tot = arr[row][col] + arr[row - 1][col - 1] + arr[row - 1][col] + arr[row - 1][col + 1];
            MAX = Math.max(tot, MAX);
        }
        // ㅓ 모양 테트리노스
        if(row - 1 < 1 || row + 1 > N || col + 1 > M) ;
        else {
            int tot = 0;
            tot = arr[row][col] + arr[row + 1][col + 1] + arr[row][col + 1] + arr[row - 1][col + 1];
            MAX = Math.max(tot, MAX);
        }
    }

}
