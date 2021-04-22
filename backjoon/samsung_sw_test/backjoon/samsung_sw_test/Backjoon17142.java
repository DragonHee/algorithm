package backjoon.samsung_sw_test;

import java.io.*;
import java.util.*;

public class Backjoon17142 {
    static class Index{
        int row, col, depth, stack;
        public Index(int row, int col, int depth, int stack){
            this.row = row;
            this.col = col;
            this.depth = depth;
            this.stack = stack;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int N, M;
    static int graph[][];
    
    static ArrayList<Index> virusList = new ArrayList<>();

    static int[] rowArr = new int[]{1,0,-1,0};
    static int[] colArr = new int[]{0,-1,0,1};

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                int num = Integer.parseInt(st.nextToken());

                if(num == 2) virusList.add(new Index(i, j, 0, 0));
                graph[i][j] = num;
            }
        }

        solve();
        
        bw.write((answer == Integer.MAX_VALUE ? -1 : answer) + "\n");
        bw.close();
        br.close();
    }

    static void solve(){
        boolean[] check = new boolean[virusList.size()];

        combination(0, 0, check);
    }

    static void combination(int index, int count, boolean[] check){
        if(count == M){
            simulation(check);
            return;
        }

        for(int i = index ; i < check.length; i++){
            check[i] = true;
            combination(i + 1, count + 1, check);
            check[i] = false;
        }
    }

    static void simulation(boolean[] check){ 
        boolean[][] visit = new boolean[N + 1][N + 1];
        LinkedList<Index> queue = new LinkedList<>();

        for(int i = 0 ; i < check.length; i++){
            // 비활성 바이러스인 경우 생략
            if(check[i] == false) continue;
            int r = virusList.get(i).row;
            int c = virusList.get(i).col;

            // 활성 바이러스
            graph[r][c] = 3;

            queue.add(new Index(r,c,0,0));
            visit[r][c] = true;
        }

        int time = bfs(queue, visit);

        for(int i = 0 ; i < check.length; i++){
            // 비활성 바이러스인 경우 생략
            if(check[i] == false) continue;
            int r = virusList.get(i).row;
            int c = virusList.get(i).col;

            // 복구
            graph[r][c] = 2;
        }

        // 미 방문점이 없는 경우
        if(isThereRemain(visit) == true) {
            answer = Math.min(answer, time);
        } 
    }

    static int bfs(LinkedList<Index> queue, boolean[][] visit){
        int maxDepth = -1;

        while(!queue.isEmpty()){
            Index curIdx = queue.poll();
            int curRow = curIdx.row;
            int curCol = curIdx.col;
            int curDepth = curIdx.depth;
            int curStack = curIdx.stack;

            maxDepth = Math.max(maxDepth, curDepth);

            for(int i = 0; i < rowArr.length; i++){
                int toRow = curRow + rowArr[i];
                int toCol = curCol + colArr[i];
                int toDepth = curDepth + 1;
                int toStack = curStack;

              
                // 범위 벗어난 경우 생략
                if(toRow < 1 || toRow > N || toCol < 1 || toCol > N) continue;
                // 기 방문점인 경우 생략
                if(visit[toRow][toCol] == true) continue;
                // 벽인 경우 생략
                if(graph[toRow][toCol] == 1) continue;

                // 비활성 바이러스를 만난 경우 
                if(graph[toRow][toCol] == 2) {
                    // 깊이 유지
                    toDepth = curDepth;
                    toStack++;
                }
                // 빈칸을 만난 경우
                else if(graph[toRow][toCol] == 0) {
                    if(toStack > 0) toDepth += toStack;
                    toStack = 0;
                }

                queue.add(new Index(toRow, toCol, toDepth, toStack));
                visit[toRow][toCol] = true;
            }
        }

        return maxDepth;
    }

    static boolean isThereRemain(boolean[][] visit){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                // 벽인 경우 생략
                if(graph[i][j] == 1) continue;
                // 바이러스가 아니고 미 방문인 경우
                if(graph[i][j] != 2 && visit[i][j] == false) return false;
            }
        }

        return true;
    }
}
