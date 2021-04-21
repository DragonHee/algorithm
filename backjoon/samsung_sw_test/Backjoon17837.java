package backjoon.samsung_sw_test;

import java.io.*;
import java.util.*;

public class Backjoon17837 {
    static class Index{
        int row, col, height;
        public Index(int row, int col, int height){
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    static class Horse{
        int num;
        int dir;
        public Horse(int num, int dir){
            this.num = num;
            this.dir = dir;
        }
    }
    static final int LIMIT = 4;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
    static int N, K;
    static int[][] graph;
    static ArrayList<Horse>[][] horseGraph;
    static ArrayList<Index> horseList = new ArrayList<>();
    
    static int[] rowArr = new int[]{0, 0, 0, -1, 1};
    static int[] colArr = new int[]{0, 1, -1, 0, 0};
    
    static int answer;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 0 : white, 1 : red, 2 : blue
        graph = new int[N + 2][N + 2];
        horseGraph = new ArrayList[N + 1][N + 1];

        for(int i = 0; i < N + 2; i++) Arrays.fill(graph[i], 2);

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                horseGraph[i][j] = new ArrayList<>();
            }
        }

        for(int i = 1; i <= K; i++){
            st = new StringTokenizer(br.readLine());
            
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            horseGraph[row][col].add(new Horse(i, dir));
            horseList.add(new Index(row, col, 0));
        }

        solve();

        bw.write(answer + "\n");
        bw.close();
        br.close();
    }

    static void solve(){

        while(answer < 1000){
            boolean res = move();
            if(res == true) return;
        }

        answer = -1;
    }

    static boolean move(){
        answer++;

        for(int i = 1 ; i <= horseList.size(); i++){
            int fromRow = horseList.get(i - 1).row;
            int fromCol = horseList.get(i - 1).col;
            int fromHeight = horseList.get(i - 1).height;
            Horse horse = horseGraph[fromRow][fromCol].get(fromHeight);
            int dir = horse.dir;

            int toRow = fromRow + rowArr[dir];
            int toCol = fromCol + colArr[dir];

            if(graph[toRow][toCol] == 0){
                moveWhite(fromRow, fromCol, toRow, toCol, fromHeight);
            }
            else if(graph[toRow][toCol] == 1){
                moveRed(fromRow, fromCol, toRow, toCol, fromHeight);
            }
            else if(graph[toRow][toCol] == 2){
                if(dir % 2 == 0) dir -= 1;
                else dir += 1;

                horseGraph[fromRow][fromCol].get(fromHeight).dir = dir;
                toRow = fromRow + rowArr[dir];
                toCol = fromCol + colArr[dir];

                if(moveBlue(fromRow, fromCol, toRow, toCol, fromHeight, dir) == false){
                    toRow = fromRow;
                    toCol = fromCol;
                }
            }

            if(horseGraph[toRow][toCol].size() >= LIMIT) return true;
        }

        return false;
    }

    static void moveWhite(int fromRow, int fromCol, int toRow, int toCol, int height){
        for(int i = height; i < horseGraph[fromRow][fromCol].size();){
            Horse h = horseGraph[fromRow][fromCol].get(i);

            // 이동할 지점에 추가
            horseGraph[toRow][toCol].add(new Horse(h.num, h.dir));
            // list 최신화
            horseList.get(h.num - 1).row = toRow;
            horseList.get(h.num - 1).col = toCol;
            horseList.get(h.num - 1).height = horseGraph[toRow][toCol].size() - 1;
            // 출발지점 삭제
            horseGraph[fromRow][fromCol].remove(h);        
        }
    }

    static void moveRed(int fromRow, int fromCol, int toRow, int toCol, int height){
        for(int i =  horseGraph[fromRow][fromCol].size() - 1; i >= height; i--){
            Horse h = horseGraph[fromRow][fromCol].get(i);

            // 이동할 지점에 추가
            horseGraph[toRow][toCol].add(new Horse(h.num, h.dir));
            // list 최신화
            horseList.get(h.num - 1).row = toRow;
            horseList.get(h.num - 1).col = toCol;
            horseList.get(h.num - 1).height = horseGraph[toRow][toCol].size() - 1;
            // 출발지점 삭제
            horseGraph[fromRow][fromCol].remove(h);        
        }
    }

    // 이동 못했을 때 return false
    // 이동 했을 때 retuen true
    static boolean moveBlue(int fromRow, int fromCol, int toRow, int toCol, int height, int dir){
        if(graph[toRow][toCol] == 0){
            moveWhite(fromRow, fromCol, toRow, toCol, height);
        }
        else if(graph[toRow][toCol] == 1){
            moveRed(fromRow, fromCol, toRow, toCol, height);
        }
        else return false;

        return true;
    }

   
}
