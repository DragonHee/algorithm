package backjoon.bfsdfs;

import java.util.*;
import java.io.*;

public class Backjoon14502 {

    static class Index{
        int row;
        int col;

        public Index(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[][] map;
    static int[][] visit;
    static ArrayList<Index> wallList = new ArrayList<>();
    static ArrayList<Index> virusList = new ArrayList<>();
    static int result;
    static int[] rowArr = new int[]{0,1,0,-1};
    static int[] colArr = new int[]{1,0,-1,0};

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        visit = new int[N + 1][M + 1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                // 벽을 세울 수 있는 List
                if(num == 0) wallList.add(new Index(i, j));
                if(num == 2) virusList.add(new Index(i, j));
            }
        }

        solve();
        
        bw.write(result + "\n");

        bw.close();
        br.close();
    }

    static void solve(){
        int size = wallList.size();

        Index[] wallArr = new Index[3];

        for(int i = 0 ; i < size; i++){
            wallArr[0] = wallList.get(i); 
            backTracking(wallArr, i + 1, 2);
        }
        
        // for(int i = 0; i < size; i++){
        //     for(int j = 0 ; j < size; j++){
        //         if(i == j) continue;
        //         for(int k = 0 ; k < size; k++){
        //             if(j == k || i == k) continue;
                    
        //             // map, 방문기록 초기화
        //             init();

        //             // 벽을 세운곳은 -1
        //             Index idx1 = wallList.get(i);
        //             Index idx2 = wallList.get(j);
        //             Index idx3 = wallList.get(k);

        //             map[idx1.row][idx1.col] = map[idx2.row][idx2.col] = map[idx3.row][idx3.col] = -1;

        //             bfs();

        //             int safeAreaSize = calcSafeAreaSize();
        //             result = Math.max(result, safeAreaSize);
        //         }
        //     }
        // }
    }
    static void backTracking(Index[] arr, int start, int remain){
        if(remain == 0){
            init();
        
            for(Index idx : arr){
                map[idx.row][idx.col] = -1;
            }

            bfs();

            int safeAreaSize = calcSafeAreaSize();
            result = Math.max(result, safeAreaSize);

            return;
        }

        for(int i = start ; i < wallList.size(); i++){
            arr[arr.length - remain] = wallList.get(i); 
            backTracking(arr, i + 1, remain - 1);
        }
    }

    static void bfs(){
        Queue<Index> queue = new LinkedList<>();

        for(int i = 0 ; i < virusList.size(); i++){
            Index idx = virusList.get(i);
            queue.add(idx);
            visit[idx.row][idx.col] = 1;
        }

        while(!queue.isEmpty()){
            Index idx = queue.poll();
            int fromRow = idx.row;
            int fromCol = idx.col;

            for(int i = 0 ; i < 4; i++){
                int toRow = fromRow + rowArr[i];
                int toCol = fromCol + colArr[i]; 

                // 범위 벗어나면 out
                if(toRow < 1 || toRow > N || toCol < 1 || toCol > M) continue;
            
                if(visit[toRow][toCol] == 0 && map[toRow][toCol] == 0) {
                    queue.add(new Index(toRow, toCol));
                    visit[toRow][toCol] = 1;
                }
            }

    
        }
    }

    static int calcSafeAreaSize(){
        int result = 0;

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(map[i][j] == 0 && visit[i][j] == 0) result++;
            }
        }

        return result;
    }

    static void init(){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(map[i][j] < 0) map[i][j] = 0;
                visit[i][j] = 0;
            }
        }
    }
}
