package backjoon.samsung_sw_test;

import java.io.*;
import java.util.*;


public class Backjoon16234 {
    static class Index{
        int row, col;
        public Index(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, L, R;
    static int[][] graph;

    static int answer;

    static int[] rowArr = new int[]{1,0,-1,0};
    static int[] colArr = new int[]{0,-1,0,1};

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();

        bw.write(answer + "\n");
        bw.close();
        br.close();
    }    

    static void solve(){
        
        while(true){
            boolean res = false;
            boolean[][] visit = new boolean[N + 1][N + 1];

            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(visit[i][j] == false) if(bfs(i, j, visit) == true) res = true;
                }
            }
            if(res == false) break;
            answer++;
        }
        
    }

    static boolean bfs(int row ,int col, boolean[][] visit){
        ArrayList<Index> nationList = new ArrayList<>();
        Queue<Index> queue = new LinkedList<>();
        int tot = 0;

        queue.add(new Index(row, col));
        visit[row][col] = true;
        
        while(!queue.isEmpty()){
            Index curIdx = queue.poll();
            int curRow = curIdx.row;
            int curCol = curIdx.col;

            tot += graph[curRow][curCol];
            nationList.add(new Index(curRow, curCol));

            for(int i = 0 ; i < rowArr.length; i++){
                int toRow = curRow + rowArr[i];
                int toCol = curCol + colArr[i];

                // 범위 벗어난 경우 생략
                if(toRow < 1 || toRow > N || toCol < 1 || toCol > N) continue;
                // 기 방문점 생략
                if(visit[toRow][toCol] == true) continue;
                // 문제 조건 벗어나면 생략
                int diff = Math.abs(graph[curRow][curCol] - graph[toRow][toCol]);
                if(diff < L || diff > R) continue;

                queue.add(new Index(toRow, toCol));
                visit[toRow][toCol] = true;
            }
        }

        int size = nationList.size();

        if(size > 1){
            int value = tot / size;

            // 각 국가의 인구수 변경
            for(Index idx : nationList){
                graph[idx.row][idx.col] = value;
            }

            return true;
        }
        else return false;
    }
}
