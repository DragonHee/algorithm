package backjoon.bfsdfs;

import java.io.*;
import java.util.*;

public class Backjoon7562 {
    static class Index{
        int row;
        int col;
        int count;
        public Index(int row, int col, int count){
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int TEST_COUNT;
    static int N;
    static int startRow, startCol;
    static int endRow, endCol;
    static int result;
    static boolean[][] visit;
    static int[] rowArr = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] colArr = new int[]{1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException{
        StringTokenizer st;
        TEST_COUNT = Integer.parseInt(br.readLine());

        for(int i = 0; i < TEST_COUNT; i++){
            N = Integer.parseInt(br.readLine());
            visit = new boolean[N][N];

            st = new StringTokenizer(br.readLine());
            startRow = Integer.parseInt(st.nextToken());
            startCol = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endRow = Integer.parseInt(st.nextToken());
            endCol = Integer.parseInt(st.nextToken());

            solve();
            
            bw.write(result + "\n");
        }

        bw.close();
        br.close();
    }

    static void solve(){
        initVisit();
        bfs(startRow, startCol);
    }

    static void bfs(int startRow, int startCol){
        result = 0;
        Queue<Index> queue = new LinkedList<>();
        queue.add(new Index(startRow, startCol, 0));
        visit[startRow][startCol] = true;

        if(startRow == endRow && startCol == endCol) return;

        while(!queue.isEmpty()){
            Index idx = queue.poll();
            int fromRow = idx.row;
            int fromCol = idx.col;
            int fromCount = idx.count;

            if(fromRow == endRow && fromCol == endCol) {
                result = fromCount;
                break;
            }

            for(int i = 0 ; i < rowArr.length; i++){
                int toRow = fromRow + rowArr[i];
                int toCol = fromCol + colArr[i];
                int toCount = fromCount + 1;

                if(toRow < 0 || toRow >= N || toCol < 0 || toCol >= N) continue;
                if(visit[toRow][toCol] == true) continue;

                queue.add(new Index(toRow, toCol, toCount));
                visit[toRow][toCol] = true;
            }
        }
    }
    
    static void initVisit(){
        for(boolean[] arr : visit){
            Arrays.fill(arr, false);
        }
    }
}
