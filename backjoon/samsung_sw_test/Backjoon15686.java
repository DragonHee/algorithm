package backjoon.samsung_sw_test;

import java.io.*;
import java.util.*;

public class Backjoon15686 {
   
    static int N, M;
    static int[][] graph;
    static boolean[][] check;
    static int result = Integer.MAX_VALUE;
    static int[] rowArr = new int[]{0,1,0,-1};
    static int[] colArr = new int[]{1,0,-1,0};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 0 -> 빈칸 1 -> 집 2 -> 치킨집
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        check = new boolean[N + 1][N + 1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();

        bw.write(result + "\n");
        bw.close();
        br.close();
    }

    static void solve(){
        
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                // 치킨 집에 대해서만 탐색
                if(graph[i][j] != 2) continue; 

                check[i][j] = true;
                searchStorePos(i, j, 1, M);
                check[i][j] = false;
            }
        }
    }

    static void searchStorePos(int row, int col, int count, int limit){
        if(count == M){
            // 도시 치킨 거리 계산
            int dis = calcChickenDis();
            result = Math.min(result, dis);
            return;
        }

        for(int i = row; i <= N; i++){
            for(int j = 1; j <= N; j++){
                int toRow = i;
                int toCol = j;

                // 이전 조합 이후의 위치만 탐색
                if(toRow == row && toCol <= col) continue;
                // 치킨 집에 대해서만 탐색
                if(graph[toRow][toCol] != 2) continue; 

                check[toRow][toCol] = true;
                searchStorePos(toRow, toCol, count + 1, limit);
                check[toRow][toCol] = false;
            }
        }
    }

    static int calcChickenDis(){
        int dis = 0;

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(graph[i][j] != 1 ) continue;

                dis += calcEachDis(i, j);
            }
        }

        return dis;
    }

    static int calcEachDis(int row, int col){
        Queue<Index> queue = new LinkedList<>();
        boolean [][] visit = new boolean[N + 1][N + 1];

        queue.add(new Index(row, col));
        visit[row][col] = true;

        while(!queue.isEmpty()){
            Index index = queue.poll();
            int curRow = index.row;
            int curCol = index.col;
            
            for(int i = 0 ; i < rowArr.length; i++){
                int toRow = curRow + rowArr[i];
                int toCol = curCol + colArr[i];

                if(toRow < 1 || toRow > N || toCol < 1 || toCol > N) continue;
                if(visit[toRow][toCol] == true) continue;

                // 치킨집 찾은 경우
                if(check[toRow][toCol] == true) {
                    int result = Math.abs(toRow - row) + Math.abs(toCol - col);
                    return result;
                }

                queue.add(new Index(toRow, toCol));
                visit[toRow][toCol] = true;
            }
        }
        
        // 치킨 집 못 찾은 경우
        // 이 문제에서는 발생하지 않음
        return -1;
    }

    static class Index{
        int row, col;

        public Index(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    
}
