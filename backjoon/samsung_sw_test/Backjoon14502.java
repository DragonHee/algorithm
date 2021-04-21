package backjoon.samsung_sw_test;

import java.util.*;
import java.io.*;

public class Backjoon14502 {
    static class Index{
        int row, col;
        public Index(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    static final int LIMIT = 3;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
    static int N, M;
    static int graph[][];
    static int answer;

    static int[] rowArr = new int[]{1, 0, -1, 0};
    static int[] colArr = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][M + 1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();

        bw.write(answer + "\n");
        bw.close();
        br.close();
    }

    static void solve(){
        combination(1, 1, 0);
    }

    static void combination(int row, int col, int count){
        if(count == 3){
            calcAnswer();
            return;
        }
        for(int i = row; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(i == row && j < col) continue;

                if(graph[i][j] == 0){
                    graph[i][j] = 1;
                    combination(i, j + 1, count + 1);
                    graph[i][j] = 0;
                }
            }
        }
    }

    static void calcAnswer(){
        boolean[][] check = new boolean[N + 1][M + 1];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(graph[i][j] == 2 && check[i][j] == false) bfs(check, i, j);
            }
        }
        
        int count = 0;

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(graph[i][j] == 0 && check[i][j] == false) count++;
            }
        }

        answer = Math.max(answer, count);
    }

    static void bfs(boolean[][] check, int row, int col){
        LinkedList<Index> queue = new LinkedList<>();
        queue.add(new Index(row, col));
        check[row][col] = true;

        while(!queue.isEmpty()){
            Index curIdx = queue.poll();
            int curRow = curIdx.row;
            int curCol = curIdx.col;

            for(int i = 0; i < rowArr.length; i++){
                int toRow = curRow + rowArr[i];
                int toCol = curCol + colArr[i];

                // 범위 벗어난 경우 생략
                if(toRow < 1 || toRow > N || toCol < 1 || toCol > M) continue;
                // 기 방문점인 경우 생략
                if(check[toRow][toCol] == true) continue;
                // 벽인 경우 생략
                if(graph[toRow][toCol] == 1) continue;

                queue.add(new Index(toRow, toCol));
                check[toRow][toCol] = true;
            }
        }

    }
    
}
