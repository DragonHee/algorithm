package backjoon.samsung_sw_test;

import java.io.*;
import java.util.*;


public class Backjoon16236 {
    static class Fish{
        int row, col, size, depth;
        public Fish(int row, int col, int size, int depth){
            this.row = row;
            this.col = col;
            this.size = size;
            this.depth = depth;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
    static int N;
    static int[][] graph;
    static int startRow, startCol;
    static int sharkSize = 2;
    static int sharkEatSize = 0;
    static int answer;
    static int[] rowArr = new int[]{-1, 0, 0, 1};
    static int[] colArr = new int[]{0, -1, 1, 0};

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                int num = Integer.parseInt(st.nextToken());
                
                if(num == 9) {
                    startRow = i;
                    startCol = j;
                }else{
                    graph[i][j] = num;
                }
            }
        }

        solve();

        bw.write(answer + "\n");
        bw.close();
        br.close();
    }

    static void solve(){

        while(true){
            // true -> 물고기 찾음
            // false -> 물고기 못 찾음
            if(move() == false) break;
        }
    }
    
    static boolean move(){
        boolean[][] check = new boolean[N + 1][N + 1];
        Queue<Fish> queue = new LinkedList<>();
        queue.add(new Fish(startRow, startCol, sharkSize, answer));
        check[startRow][startCol] = true;
        List<Fish> availList = new ArrayList<Fish>();
        int flagDepth = 0;

        while(!queue.isEmpty()){
            Fish f = queue.poll();
            int row = f.row;
            int col = f.col;
            int size = f.size;
            int depth = f.depth;

            for(int i = 0 ; i < rowArr.length; i++){
                int toRow = row + rowArr[i];
                int toCol = col + colArr[i];
                int toDepth = depth + 1;

                if(flagDepth != 0 && toDepth > flagDepth) continue;
                // 범위 벗어나면 생략
                if(toRow < 1 || toRow > N || toCol < 1 || toCol > N) continue;
                // 기 방문점인 경우 생략
                if(check[toRow][toCol] == true) continue;
                int value = graph[toRow][toCol];
                // 물고기 크기가 더 크면 생략
                if(value > size) continue;

                // 그냥 이동
                if(value == size || value == 0){
                    queue.add(new Fish(toRow, toCol, size, toDepth));
                    check[toRow][toCol] = true;
                    continue;
                }

                flagDepth = toDepth;
                availList.add(new Fish(toRow, toCol, 0, 0));
            }
        }

        if(availList.size() == 0) return false;

        
        int index = 0;

        for(int i = 1 ; i < availList.size(); i++){
            if(availList.get(i).row < availList.get(index).row) {
                index = i;
            }else if(availList.get(i).row == availList.get(index).row){
                if(availList.get(i).col < availList.get(index).col){
                    index = i;
                }
            }
        }
         // 잡아 먹는 경우
         startRow = availList.get(index).row;
         startCol = availList.get(index).col;
         answer = flagDepth;
         graph[startRow][startCol] = 0;
         // 자신의 크기만큼 물고기를 먹은 경우
         if(++sharkEatSize == sharkSize) {
             sharkSize++;
             sharkEatSize = 0;
         }

         return true;
    }
}
