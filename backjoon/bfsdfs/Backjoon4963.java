package backjoon.bfsdfs;

import java.io.*;
import java.util.*;

public class Backjoon4963 {
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
    static int W,H;
    static int[][] map;
    static boolean[][] check;
    static int CNT;
    static int rowArr[] = new int[]{0,1,1,1,0,-1,-1,-1};
    static int colArr[] = new int[]{1,1,0,-1,-1,-1,0,1};

    public static void main(String[] args) throws IOException{
          while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
        
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if(W == 0 && H == 0) break;

            map = new int[H + 1][W + 1];
            check = new boolean[H + 1][W + 1];
            CNT = 0;

            for(int i = 1; i <= H; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j <= W; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            solve();

            bw.write(CNT + "\n");
        }

        bw.close();
        br.close();
    }

    static void solve(){
        for(int i = 1; i <= H; i++){
            for(int j = 1; j <= W; j++){
                if(check[i][j] == true) continue;
                if(map[i][j] == 0) continue;

                bfs(i, j);
                CNT++;
            }
        }
    }

    static void bfs(int row, int col){
        Queue<Index> queue = new LinkedList<>();

        queue.add(new Index(row, col));
        check[row][col] = true;

        while(!queue.isEmpty()){
            Index idx = queue.poll();
            
            for(int i = 0 ; i < rowArr.length; i++){
                int toRow = idx.row + rowArr[i];
                int toCol = idx.col + colArr[i];

                if(toRow < 1 || toRow > H || toCol < 1 || toCol > W) continue;
                if(map[toRow][toCol] == 0) continue;
                if(check[toRow][toCol] == true) continue;

                queue.add(new Index(toRow, toCol));
                check[toRow][toCol] = true;
            }
        }

    }
}
