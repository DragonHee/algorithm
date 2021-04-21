package backjoon.samsung_sw_test;

import java.util.*;


import java.io.*;

public class Backjoon19238 {
    static class Index{
        int row;
        int col;
        public Index(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    static class Taxi{
        Index index;
        int depth, oil;
        public Taxi(Index index, int depth){
            this.index = index;
            this.depth = depth;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
   
    static int N, M;
    static int[][] graph;
    static ArrayList<Index> arriveList = new ArrayList<>();
    static int startRow, startCol, oilValue;

    static int[] rowArr = new int[]{1,0,-1,0};
    static int[] colArr = new int[]{0,-1,0,1};

    static int answer;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        oilValue = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken()) == 1 ? -1 : 0;
            }
        }
        st = new StringTokenizer(br.readLine());

        startRow = Integer.parseInt(st.nextToken());
        startCol = Integer.parseInt(st.nextToken());

        arriveList.add(new Index(0, 0));

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int toRow = Integer.parseInt(st.nextToken());
            int toCol = Integer.parseInt(st.nextToken());

            graph[row][col] = i;
            arriveList.add(new Index(toRow, toCol));
        }

        solve();

        bw.write(answer + "\n");
        bw.close();
        br.close();
    }
    
    static void solve(){
        while(true){
            // 승객을 못 찾은 경우
            if(searchPassenger(startRow, startCol) == false) break;
            if(M == 0) {
                answer = oilValue;
                return;
            }
        }

        answer = -1;
        return;        
    }

    // 승객을 찾으면 true
    // 못 찾으면 false
    static boolean searchPassenger(int row, int col){
        ArrayList<Index> answerList = new ArrayList<>();
        boolean[][] check = new boolean[N + 1][N + 1];
        LinkedList<Taxi> queue = new LinkedList<>();
        queue.add(new Taxi(new Index(row, col), 0));
        check[row][col] = true;
        int flagDepth = -1;

        while(!queue.isEmpty()){
            Taxi curTaxi = queue.poll();
            int fromRow = curTaxi.index.row;
            int fromCol = curTaxi.index.col;
            int fromDepth = curTaxi.depth;

            if(flagDepth > 0 && flagDepth < fromDepth) break;

            if(graph[fromRow][fromCol] > 0){
                answerList.add(new Index(fromRow, fromCol));
                flagDepth = fromDepth;
                continue;
            }

            for(int i = 0 ; i < rowArr.length; i++){
                int toRow = fromRow + rowArr[i];
                int toCol = fromCol + colArr[i];
                int toDepth = fromDepth + 1;

                if(toRow < 1 || toRow > N || toCol < 1 || toCol > N) continue;
                if(graph[toRow][toCol] == -1) continue;
                if(check[toRow][toCol] == true) continue;

                queue.add(new Taxi(new Index(toRow, toCol), toDepth));
                check[toRow][toCol] = true;
            }
        }

        int index = 0;

        if(flagDepth >= 0){
            if(oilValue < flagDepth) return false;

            for(int i = index + 1; i < answerList.size(); i++){
                if(answerList.get(index).row > answerList.get(i).row){
                    index = i;
                }
                else if(answerList.get(index).row == answerList.get(i).row){
                    if(answerList.get(index).col > answerList.get(i).col){
                        index = i;
                    }
                }
            }

            int fromRow = answerList.get(index).row;
            int fromCol = answerList.get(index).col;
            oilValue -= flagDepth;

            if(goToDest(graph[fromRow][fromCol], fromRow, fromCol) == false){
                return false;
            }
            else return true;
        }
    
        return false;
    }

    static boolean goToDest(int num, int row, int col){
        boolean[][] check = new boolean[N + 1][N + 1];
        LinkedList<Taxi> queue = new LinkedList<>();
        queue.add(new Taxi(new Index(row, col), 0));
        check[row][col] = true;

        while(!queue.isEmpty()){
            Taxi curTaxi = queue.poll();
            int fromRow = curTaxi.index.row;
            int fromCol = curTaxi.index.col;
            int fromDepth = curTaxi.depth;

            // 연료보다 먼 곳에 도착지인 경우
            if(fromDepth > oilValue) return false;
            // 도착지를 찾은 경우
            if(fromRow == arriveList.get(num).row && fromCol == arriveList.get(num).col){
                graph[row][col] = 0;
                M--;
                oilValue += fromDepth;
                startRow = fromRow;
                startCol = fromCol;

                return true;
            }

            for(int i = 0; i < rowArr.length; i++){
                int toRow = fromRow + rowArr[i];
                int toCol = fromCol + colArr[i];
                int toDepth = fromDepth + 1;

                if(toRow < 1 || toRow > N || toCol < 1 || toCol > N) continue;
                if(graph[toRow][toCol] == -1) continue;
                if(check[toRow][toCol] == true) continue;

                queue.add(new Taxi(new Index(toRow, toCol), toDepth));
                check[toRow][toCol] = true;
            }
        }

        return false;
    }
}
