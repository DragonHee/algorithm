package backjoon.samsung_sw_test;

import java.util.*;
import java.io.*;

public class Backjoon19237 {
    static class Shark{
        int dir;
        int row;
        int col;

        public Shark(int row, int col, int dir){
            this.row = row;
            this.col = col;
            this.dir = dir;
        }
        public void setDir(int dir){
            this.dir = dir;
        }
    }
    static class Index{
        int remainCount;
        int sharkNum;
        public Index(int remainCount, int sharkNum){
            this.remainCount = remainCount;
            this.sharkNum = sharkNum;
        }
        public void timePlus(){
            if(remainCount == 0) return;
            remainCount--;
            if(remainCount == 0){
                sharkNum = 0;
            }
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
    static Index[][] graph;
    static int N, M, K;
    static Shark[] sharkArr;
    // i번째 상어, 현 방향, 우선순위
    static int[][][] dirTable;
    static int result;
    static int[] rowArr = new int[]{0, -1, 1, 0, 0};
    static int[] colArr = new int[]{0, 0, 0, -1, 1};
    static int sharkCount;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = sharkCount = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new Index[N + 1][N + 1];
        sharkArr = new Shark[M + 1];
        dirTable = new int[M + 1][5][5];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                int num = Integer.parseInt(st.nextToken());
                graph[i][j] = new Index(0, 0);
                if(num > 0){
                    sharkArr[num] = new Shark(i, j, 0);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= M; i++){
            sharkArr[i].setDir(Integer.parseInt(st.nextToken()));
        }

        for(int i = 1; i <= M; i++){
            for(int j = 1; j <= 4; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 1; k <= 4; k++){
                    int num = Integer.parseInt(st.nextToken());
                    dirTable[i][j][k] = num;
                }
            }
            
        }
        
        solve();

        bw.write(result + "\n");
        bw.close();
        br.close();
    }
    
    static void solve(){
        updateSmell();
        
        while(true){
            // 상어 이동
            move();
            // 현재 상어 위치에 냄새 update
            updateSmell();
            // 1초 시간 흐름
            minusGraph();

            if(result > 1000) break;

            if(sharkCount == 1) return;
        }

        result = -1;        
    }

    static void move(){
        for(int i = 1; i <= M; i++){
            if(sharkArr[i] == null) continue;

            Shark shark = sharkArr[i];
            int row = shark.row;
            int col = shark.col;
            int dir = shark.dir;
            boolean sharkMove = false;

            for(int j = 1; j <= 4; j++){
                int nextDir = dirTable[i][dir][j];
                int toRow = row + rowArr[nextDir];
                int toCol = col + colArr[nextDir];

                if(toRow < 1 || toRow > N || toCol < 1 || toCol > N) continue;
                if(graph[toRow][toCol].remainCount > 0) continue;

                graph[row][col].remainCount = K;
                graph[row][col].sharkNum = i;
                sharkArr[i] = new Shark(toRow, toCol, nextDir);
                sharkMove = true;
                break;
            }

            // 냄새가 없는 곳으로 이동 못한 경우
            if(sharkMove == false){
                // 자신의 냄새가 있는 곳으로 이동할 경우
                for(int j = 1; j <= 4; j++){
                    int nextDir = dirTable[i][dir][j];
                    int toRow = row + rowArr[nextDir];
                    int toCol = col + colArr[nextDir];

                    if(toRow < 1 || toRow > N || toCol < 1 || toCol > N) continue;
                    if(graph[toRow][toCol].sharkNum != i) continue;

                    graph[row][col].remainCount = K;
                    graph[row][col].sharkNum = i;
                    sharkArr[i] = new Shark(toRow, toCol, nextDir);
                    sharkMove = true;
                    break;
                }
            }

            for(int j = 1; j <= M; j++){
                if(sharkArr[j] == null) continue;
                if(i == j) continue;
                // 잡아 먹기
                if(sharkArr[i].row == sharkArr[j].row && sharkArr[i].col == sharkArr[j].col){
                    if(i > j) sharkArr[i] = null;
                    else sharkArr[j] = null;
                    sharkCount--;
                    break;
                }
            }
        }

        result++;
    }

    static void minusGraph(){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                graph[i][j].timePlus();
            }
        }
    }

    static void updateSmell(){
        for(int i = 1; i <= M; i++){
            if(sharkArr[i] == null) continue;

            Shark shk = sharkArr[i];
            graph[shk.row][shk.col].remainCount = K;
            graph[shk.row][shk.col].sharkNum = i;
        }
    }
    
}
