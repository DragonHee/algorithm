package backjoon.samsung_sw_test;

import java.io.*;
import java.util.*;

public class Backjoon2583 {
    static class XY{
        int x, y;
        public XY(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
    static int M, N, K;
    static ArrayList<Integer> answerList = new ArrayList<>();
    static ArrayList<XY> startList = new ArrayList<>();
    static ArrayList<XY> endList = new ArrayList<>();
    static boolean[][] graph;

    static int[] rowArr = new int[]{1,0,-1,0};
    static int[] colArr = new int[]{0,-1, 0, 1};

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); 

        graph = new boolean[M][N];
        
        for(int i = 1; i <= K; i++){
            st = new StringTokenizer(br.readLine());

            int sX = Integer.parseInt(st.nextToken());
            int sY = Integer.parseInt(st.nextToken());
            int eX = Integer.parseInt(st.nextToken());
            int eY = Integer.parseInt(st.nextToken());

            startList.add(new XY(sX, sY));
            endList.add(new XY(eX, eY));
        }

        solve();

        Collections.sort(answerList);
        
        bw.write(answerList.size() + "\n");
        for(int i = 0; i < answerList.size(); i++){
            bw.write(answerList.get(i) + " ");
        }

        bw.close();
        br.close();
    }

    static void solve(){
        paintGraph();
        for(int i = 0 ; i < M; i++){
            for(int j = 0 ; j < N; j++){
                if(graph[i][j] == false) calcArea(i, j);
            }
        }
   
    }

    static void calcArea(int row, int col){
        int count = 1;
        LinkedList<XY> queue = new LinkedList<>();
        queue.add(new XY(row, col));
        graph[row][col] = true;

        while(!queue.isEmpty()){
            XY xy = queue.poll();
            int curX = xy.x;
            int curY = xy.y;

            for(int i = 0 ; i < rowArr.length; i++){
                int toX = curX + rowArr[i];
                int toY = curY + colArr[i];

                if(toX < 0 || toX >= M || toY < 0 || toY >= N) continue;
                if(graph[toX][toY] == true) continue;

                queue.add(new XY(toX, toY));
                graph[toX][toY] = true;
                count++;
            }
        }

        answerList.add(count);
    }

    static void paintGraph(){
        for(int i = 0 ; i < startList.size(); i++){
            int sx = startList.get(i).x;
            int sy = startList.get(i).y;

            int ex = endList.get(i).x;
            int ey = endList.get(i).y;

            for(int r = sx; r <= ex - 1; r++){
                for(int c = sy; c <= ey - 1; c++){
                    graph[c][r] = true;
                }
            }
        }
    }
}
