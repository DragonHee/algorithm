package backjoon.samsung_sw_test;

import java.util.*;

public class Backjoon14500 {
    static int N, M;
    static int[][] graph;
    static boolean[][] check;
    static int maxValue = Integer.MIN_VALUE;
    static int[] rowArr = new int[]{0, 1, 0, -1};
    static int[] colArr = new int[]{1, 0, -1, 0};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N + 1][M + 1];
        check = new boolean[N + 1][M + 1];

        // init graph
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                graph[i][j] = sc.nextInt();
            }
        }
        
        solve();
        
        System.out.println(maxValue + "\n");

        sc.close();
    }

    static void solve(){
        // dfs를 통해 위치 탐색
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                check[i][j] = true;
                dfs(i, j, graph[i][j], 1);
                check[i][j] = false;
                // ㅗ, ㅏ, ㅜ, ㅓ 모양은 dfs를 통해 탐색이 안되므로 따로 계산
                extraCalc(i, j);
            }
        }

    }

    static void dfs(int row, int col, int tot, int length){
        // 길이가 4인 경우 합계의 최댓값을 update
        if(length == 4) {
            maxValue = Math.max(tot, maxValue);
            return;
        }

        for(int i = 0; i < rowArr.length; i++){
            int toRow = row + rowArr[i];
            int toCol = col + colArr[i];

            if(toRow < 1 || toRow > N || toCol < 1 || toCol > M) continue;
            if(check[toRow][toCol] == true) continue;

            check[toRow][toCol] = true;
            dfs(toRow, toCol, tot + graph[toRow][toCol], length + 1);
            check[toRow][toCol] = false;
        }
    }

    static void extraCalc(int row, int col){
        // ㅗ 모양
        if(row - 1 >= 1 && col + 2 <= M){
            int sum = graph[row][col];

            sum += graph[row - 1][col + 1];
            sum += graph[row][col + 1];
            sum += graph[row][col + 2];

            maxValue = Math.max(maxValue, sum);
        }
        // ㅏ 모양
        if(row + 2 <= N && col + 1 <= M){
            int sum = graph[row][col];

            sum += graph[row + 1][col];
            sum += graph[row + 1][col + 1];
            sum += graph[row + 2][col];

            maxValue = Math.max(maxValue, sum);
        }
        // ㅜ 모양
        if(row + 1 <= N && col - 2 >= 1){
        int sum = graph[row][col];

        sum += graph[row][col - 1];
        sum += graph[row + 1][col - 1];
        sum += graph[row][col - 2];

        maxValue = Math.max(maxValue, sum);
        }
        // ㅓ 모양
        if(row - 2 >= 1 && col - 1 >= 1){
        int sum = graph[row][col];

        sum += graph[row - 1][col];
        sum += graph[row - 1][col - 1];
        sum += graph[row - 2][col];

        maxValue = Math.max(maxValue, sum);
        }
    }
    
}
