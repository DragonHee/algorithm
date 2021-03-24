package backjoon.bfsdfs;

import java.io.*;
import java.util.*;

public class Backjoon2468 {
    static class Index{
        int row;
        int col;

        public Index(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int maxHeight = 0;
    static int N;
    static int[][] map;
    static boolean[][] check;
    static int[] deltaRow = new int[]{0,1,0,-1};
    static int[] deltaCol = new int[]{1,0,-1,0};
    static int answer = 1;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        
        map = new int[N + 1][N + 1];
        check = new boolean[N + 1][N + 1];

        StringTokenizer st;

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        solve();

        bw.write(answer + "\n");

        bw.close();
        br.close();
    }
    
    static void solve(){
        for(int i = 1; i < maxHeight; i++){
            init();
            subSolve(i);
        }
    }
    static void subSolve(int waterHeight){
        int count = 0;

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(map[i][j] <= waterHeight) check[i][j] = true;
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(check[i][j] == false){
                    bfs(i, j);
                    count++;
                }
            }
        }
        
        answer = Math.max(count,answer);
    }

    static void bfs(int row, int col){
        Queue<Index> queue = new LinkedList<>();
        queue.add(new Index(row, col));
        check[row][col] = true;

        while(!queue.isEmpty()){
            Index idx = queue.poll();
            int fromRow = idx.row;
            int fromCol = idx.col;

            for(int i = 0; i < 4; i++){
                int toRow = fromRow + deltaRow[i];
                int toCol = fromCol + deltaCol[i];

                if(toRow < 1 || toRow > N || toCol < 1 || toCol > N) continue;
                if(check[toRow][toCol] == false){
                    queue.add(new Index(toRow, toCol));
                    check[toRow][toCol] = true;
                }
            }

        }
    }
    

    static void init(){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++) check[i][j] = false;
        }
    }
    
}
