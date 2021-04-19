package backjoon.samsung_sw_test;

import java.util.*;
import java.io.*;

public class Backjoon15683 {
    static class Index{
        int row, col, num;
        public Index(int row, int col, int num){
            this.row = row;
            this.col = col;
            this.num = num;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
    static int N, M;
    static int[][] graph;
    static List<Index> cctvList = new ArrayList<>();
    static int result = Integer.MAX_VALUE;
    // 1번-> 4방향, 2번 -> 2방향, 3번 -> 4방향, 4번 -> 4방향, 5번 -> 1방향
    static int[] dirArr = new int[]{0, 4, 2, 4, 4, 1};

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][M + 1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                int num = Integer.parseInt(st.nextToken());
                graph[i][j] = num;
                if(num > 0 && num < 6) cctvList.add(new Index(i, j, num));
            }
        }

        solve();

        bw.write(result + "\n");
        bw.close();
        br.close();
    }

    static void solve(){
        int[] check = new int[cctvList.size()];

        // cctv가 없는 경우
        if(cctvList.size() == 0) getResult();
        // cctv가 있는 경우
        else combination(0, check, cctvList.size());
        
    }
    
    static void combination(int curIndex, int[] check, int limit){
        if(curIndex == limit){
            calcView(check);
            return;
        }

        Index idx = cctvList.get(curIndex);
        int num = idx.num;

        for(int i = 0; i < dirArr[num]; i++){
            check[curIndex] = i;
            combination(curIndex + 1, check, limit);
            check[curIndex] = -1;
        }

    }
    
    static void calcView(int[] check){
        boolean[][] checkView = new boolean[N + 1][M + 1];

        for(int i = 0; i < check.length; i++){
            Index idx = cctvList.get(i);
            int num = idx.num;
            int row = idx.row;
            int col = idx.col;

            // 1번 cctv -> 한 방향
            if(num == 1){
                int dir = check[i];
                updateCheckView(checkView, dir, row, col);
            }
            // 2번 cctv -> 두 방향
            else if(num == 2){
                int dir = check[i];
                updateCheckView(checkView, dir, row, col);
                updateCheckView(checkView, (dir + 2) % 4, row, col);
            }
            else if(num == 3){
                int dir = check[i];
                updateCheckView(checkView, dir, row, col);
                updateCheckView(checkView, (dir + 1) % 4, row, col);
            }
            else if(num == 4){
                int dir = check[i];
                updateCheckView(checkView, dir, row, col);
                updateCheckView(checkView, (dir + 1) % 4, row, col);
                updateCheckView(checkView, (dir + 2) % 4, row, col);
            }
            else if(num == 5){
                int dir = check[i];
                updateCheckView(checkView, dir, row, col);
                updateCheckView(checkView, (dir + 1) % 4, row, col);
                updateCheckView(checkView, (dir + 2) % 4, row, col);
                updateCheckView(checkView, (dir + 3) % 4, row, col);
            }
        }

        getResult(checkView);
    }

    static void updateCheckView(boolean[][] checkView, int dir, int row, int col){
        if(dir == 0){
            for(int i = row; i <= N; i++){
                checkView[i][col] = true;
                // 벽을 만나면 종료
                // 벽을 만나도 true로 바꿔 사각지대 계산에 포함되지 않도록 한다.
                if(graph[i][col] == 6) break;
            }
        }
        else if(dir == 1){
            for(int i = col; i >= 1; i--){
                checkView[row][i] = true;
                // 벽을 만나면 종료
                // 벽을 만나도 true로 바꿔 사각지대 계산에 포함되지 않도록 한다.
                if(graph[row][i] == 6) break;
            }
        }
        else if(dir == 2){
            for(int i = row; i >= 1; i--){
                checkView[i][col] = true;
                // 벽을 만나면 종료
                // 벽을 만나도 true로 바꿔 사각지대 계산에 포함되지 않도록 한다.
                if(graph[i][col] == 6) break;
            }
        }
        else if(dir == 3){
            for(int i = col; i <= M; i++){
                checkView[row][i] = true;
                // 벽을 만나면 종료
                // 벽을 만나도 true로 바꿔 사각지대 계산에 포함되지 않도록 한다.
                if(graph[row][i] == 6) break;
            }
        }
    }

    static void getResult(boolean[][] checkView){
        int count = 0;

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(checkView[i][j] == false && graph[i][j] == 0) count++;
            }
        }

        result = Math.min(result, count);
    }

    static void getResult(){
        int count = 0;

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if( graph[i][j] != 6) count++;
            }
        }

        result = Math.min(result, count);
    }
    
}
