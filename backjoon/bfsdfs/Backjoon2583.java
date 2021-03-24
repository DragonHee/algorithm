package backjoon.bfsdfs;

import java.io.*;
import java.util.*;

public class Backjoon2583 {
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
    static int M, N, K;
    static int[][] xyArr;
    static boolean[][] check;
    static ArrayList<Integer> answerList = new ArrayList<>();
    static int[] rowArr = new int[]{0,1,0,-1};
    static int[] colArr = new int[]{1,0,-1,0};

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        check = new boolean[M + 1][N + 1];
        xyArr = new int[K + 1][4];

        for(int i = 1; i <= K; i++){
            st = new StringTokenizer(br.readLine());
            
            for(int j = 0 ; j < xyArr[0].length; j++){
                xyArr[i][j] = Integer.parseInt(st.nextToken());
            }

            for(int j = xyArr[i][1] + 1; j <= xyArr[i][3]; j++){
                for(int k = xyArr[i][0] + 1; k <= xyArr[i][2]; k++){
                    check[j][k] = true;
                }
            }
        }

        for(int i = 1; i <= M; i++){
            for(int j = 1; j <= N; j++){
                if(check[i][j] == false) bfs(i, j);
            }
        }

        Collections.sort(answerList);

        bw.write(answerList.size() + "\n");

        for(int num : answerList){
            bw.write(num + " ");
        }

        bw.close();
        br.close();
    }

    static void bfs(int row, int col){
        int count = 0;
        Queue<Index> queue = new LinkedList<>();
        queue.add(new Index(row, col));
        check[row][col] = true;

        while(!queue.isEmpty()){
            Index idx = queue.poll();
            count++;
            int fromRow = idx.row;
            int fromCol = idx.col;

            for(int i = 0 ; i < 4; i++){
                int toRow = fromRow + rowArr[i];
                int toCol = fromCol + colArr[i];

                if(toRow < 1 || toRow > M || toCol < 1 || toCol > N)continue;
                if(check[toRow][toCol]) continue;

                queue.add(new Index(toRow, toCol));
                check[toRow][toCol] = true;
            }

        }

        answerList.add(count);
    }
}
