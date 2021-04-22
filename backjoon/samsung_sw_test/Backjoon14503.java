package backjoon.samsung_sw_test;

import java.io.*;
import java.util.*;

public class Backjoon14503 {
    static class Index{
        int row, col, dir;
        public Index(int row, int col, int dir){
            this.row = row;
            this.col = col;
            this.dir = dir;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int N, M;
    static int[][] graph;
    static int startRow, startCol, startDir;

    // 0, 1, 2, 3 -> 북, 동, 남, 서
    static int[] rowArr = new int[]{-1, 0, 1, 0};
    static int[] colArr = new int[]{0, 1, 0, -1};

    static int answer;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = new int[N][M];

        st = new StringTokenizer(br.readLine());
        startRow = Integer.parseInt(st.nextToken());
        startCol = Integer.parseInt(st.nextToken());
        startDir = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();

        bw.write(answer + "\n");
        bw.close();
        br.close();
    }

    static void solve(){
        startClean(startRow, startCol, startDir);
    }

    static void startClean(int row, int col, int dir){
        int cleanArea = 0;
        boolean[][] check = new boolean[N][M];
        

        while(true){
            boolean flag = false;

            if(check[row][col] == false){
                // 1. 현재 칸 청소
                check[row][col] = true;
                cleanArea++;
            }

            for(int i = 0; i < rowArr.length; i++){
                // 2. 왼쪽방향
                int toDir = (dir + 3 - i) % 4; 
                int toRow = row + rowArr[toDir];
                int toCol = col + colArr[toDir];

                // 이미 청소된 경우
                if(check[toRow][toCol] == true) continue;
                // 벽인 경우
                if(graph[toRow][toCol] == 1) continue;

                row = toRow;
                col = toCol;
                dir = toDir;
                flag = true;
                break;
            }

            // 움직이지 못한 경우
            if(flag == false){
                // 반대 방향 (후진)
                int toDir = (dir + 2) % 4;
                int toRow = row + rowArr[toDir];
                int toCol = col + colArr[toDir];

                // 벽인 경우
                if(graph[toRow][toCol] == 1) break;

                // 뒤로 이동한 경우 (방향은 변경시키지 않는다)
                // 후진이기 때문에
                row = toRow;
                col = toCol;
            }
        }

        answer = cleanArea;
    }
}
