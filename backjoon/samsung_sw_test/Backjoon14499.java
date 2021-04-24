package backjoon.samsung_sw_test;

import java.util.*;
import java.io.*;

public class Backjoon14499{
    static class Dice{
        int bottomIndex;
        int bottom;
        int top;
        int arr[];
        public Dice(){
            bottom = 0;
            top = 0;
            arr = new int[4];
            for(int i = 0 ; i < 4; i++)arr[i] = 0;
        }

        public void roll(int dir){
            // 동 
            if(dir == 0){
                int tempBottom = bottom;
                int tempTop = top;

                bottom = arr[3];
                top = arr[1];
                arr[3] = tempTop;
                arr[1] = tempBottom;
            }
            else if(dir == 1){
                int tempBottom = bottom;
                int tempTop = top;

                bottom = arr[1];
                top = arr[3];
                arr[3] = tempBottom;
                arr[1] = tempTop;
            }
            else if(dir == 2){
                int tempBottom = bottom;
                int tempTop = top;

                bottom = arr[2];
                top = arr[0];
                arr[2] = tempTop;
                arr[0] = tempBottom;
            }
            else if(dir == 3){
                int tempBottom = bottom;
                int tempTop = top;

                bottom = arr[0];
                top = arr[2];
                arr[0] = tempTop;
                arr[2] = tempBottom;
            }
        }
        public int getBottom(){
            return bottom;
        }
        public int getTop(){
            return top;
        }
        public void setBottom(int bottom){
            this.bottom = bottom;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int N, M, K;
    static int row, col;
    static int graph[][];
    static ArrayList<Integer> moveList = new ArrayList<>();

    static int[] rowArr = new int[]{0, 0, -1, 1};
    static int[] colArr = new int[]{1, -1, 0, 0};

    static ArrayList<Integer> answerList = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreElements()) moveList.add(Integer.parseInt(st.nextToken()) - 1);

        solve();

        for(int i = 0 ; i < answerList.size(); i++) bw.write(answerList.get(i) + "\n");
        bw.close();
        br.close();
    }

    static void solve(){
        Dice dice = new Dice();

        for(int i = 0; i < moveList.size(); i++){
            int dir = moveList.get(i);
            int curRow = row;
            int curCol = col;

            int toRow = curRow + rowArr[dir];
            int toCol = curCol + colArr[dir];

            if(toRow < 0 || toRow >= N || toCol < 0 || toCol >= M) continue;

            // 굴리기
            dice.roll(dir);

            // 칸으로 주사위 바닥 값 복사
            if(graph[toRow][toCol] == 0){
                graph[toRow][toCol] = dice.getBottom();
            }
            // 주사위 바닥으로 칸 값 복사
            else{
                dice.setBottom(graph[toRow][toCol]);
                graph[toRow][toCol] = 0;
            }
            
            answerList.add(dice.getTop());
            row = toRow;
            col = toCol;
        }
    }
}