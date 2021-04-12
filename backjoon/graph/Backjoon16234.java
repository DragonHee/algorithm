package backjoon.graph;

import java.io.*;
import java.util.*;

public class Backjoon16234 {
    static class Index{
        int row, col;
        public Index (int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, L, R;
    static int graph[][];
    static boolean check[][];
    static int result;
    static int[] rowArr = new int[]{0, 1, 0, -1};
    static int[] colArr = new int[]{1, 0, -1, 0};
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 그래프 선언
        graph = new int[N + 1][N + 1];
        check = new boolean[N + 1][N + 1];

        // 그래프 초기화
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

    static void solve() throws IOException{
      

        while(true){
            boolean flag = false;

            for(boolean[] arr : check){
                Arrays.fill(arr, false);
            }
        
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(check[i][j] == false) {
                        if(bfs(i, j)) flag = true;
                    }
                }
            }
            if(flag == false) break;
            result++;
         }
        
    }

    static boolean bfs(int row, int col){
        int sum = 0;
        int count = 0;
        Queue<Index> queue = new LinkedList<>();
        List<Index> list = new ArrayList<>();

        queue.add(new Index(row, col));
        check[row][col] = true;
        list.add(new Index(row, col));

        while(!queue.isEmpty()){
            Index curIndex = queue.poll();
            int curRow = curIndex.row;
            int curCol = curIndex.col;
            sum += graph[curRow][curCol];
            count++;

            for(int i = 0 ; i < rowArr.length; i++){
                int toRow = curRow + rowArr[i];
                int toCol = curCol + colArr[i];
    
                // 범위 벗어나면 pass
                if(toRow > N || toCol > N || toRow < 1 || toCol < 1) continue;
                // 기 방문점이면 pass
                if(check[toRow][toCol] == true) continue;
                int absValue = Math.abs(graph[curRow][curCol] - graph[toRow][toCol]);
                // 차이가 주어진 조건에 벗어나면 pass
                if(absValue < L || absValue > R) continue;
    
                queue.add(new Index(toRow, toCol));
                list.add(new Index(toRow, toCol));
                check[toRow][toCol] = true;
            }
        }
        int value = sum / count;

        for (Index index : list) {
            graph[index.row][index.col] = value;
        }

        if(count > 1) return true;
        else return false;
    }

}
