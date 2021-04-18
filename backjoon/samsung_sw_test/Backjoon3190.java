package backjoon.samsung_sw_test;

import java.io.*;
import java.util.*;


public class Backjoon3190 {
    static class Index{
        int row, col;
        public Index(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
    static int N, K, L;
    // 2 -> 사과
    static int[][] graph;
    static Queue<String> dirQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];
        K = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            graph[row][col] = 2;
        }

        L = Integer.parseInt(br.readLine());
        for(int i = 0; i < L; i++){
            dirQueue.add(br.readLine());
        }

        int ans = solve();

        bw.write(ans + "\n");
        bw.close();
        br.close();

    }

    static int solve(){
        // 시간
        int curTime = 0;
        // 시작 좌표
        int row = 1, col = 1;
        // 아래, 왼, 위, 오 방향
        int[] rowArr = new int[]{1,0,-1,0};
        int[] colArr = new int[]{0,-1,0,1};
        // 지렁이가 있는 부분을 배열로 저장
        boolean[][] check = new boolean[N + 1][N + 1];
        // 지렁이의 이동관련 queue 
        Queue<Index> queue = new LinkedList<>();
        
        queue.add(new Index(row, col));
        check[row][col] = true;

        // 오른쪽 부터 시작
        int dir = 3;

        while(true){
            // 좌표 및 시간 변경
            row += rowArr[dir];
            col += colArr[dir];
            curTime++;

            // map의 범위 벗어난 경우 break
            if(row < 1 || row > N || col < 1 || col > N) break;
            // 지렁이 몸에 부딪히는 경우 break
            if(check[row][col] == true) break;

            // 머리부분 이동
            check[row][col] = true;
            queue.add(new Index(row, col));

            // 사과를 만나지 않은 경우
            // 꼬리부분을 옮겨줌
            if(graph[row][col] != 2){
                Index idx = queue.poll();
                check[idx.row][idx.col] = false;
            }
            // 사과를 만난경우
            // 사과를 map에서 삭제
            // 꼬리부분을 옮기지 않음
            else{
                graph[row][col] = 0;
            }

            if(!dirQueue.isEmpty()){
                String str = dirQueue.peek();
                int num = Integer.parseInt(str.split(" ")[0]);
                String dirStr = str.split(" ")[1];

                if(num == curTime){
                    dirQueue.poll();
                    if(dirStr.equals("D")){
                        dir = (dir + 1) % 4;
                    }else{
                        dir = (dir + 3) % 4;
                    }
                }
            }
        }

        return curTime;
    }
    
}
