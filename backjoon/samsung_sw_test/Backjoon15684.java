package backjoon.samsung_sw_test;

import java.util.*;
import java.io.*;

public class Backjoon15684 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, H;
    static int[][] graph;
    static int result;
    
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        graph = new int[H + 1][N + 1];

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
        }

        solve();

        bw.write(result + "\n");
        bw.close();
        br.close();
    }

    static void solve(){
        // 가로선 추가 없이 정답인 경우
        if(checkIsAnswer() == true) return;

        int limit = 1;

        while(limit <= 3){
            for(int i = 1; i <= H; i++){
                for(int j = 1; j < N; j++){
                    // 현재 위치의 가로선이 없음 && 왼쪽 가로선이 없음
                    if(graph[i][j] == 0 && graph[i][j - 1] == 0){
                        // 가로선 추가
                        graph[i][j] = 1;
                        // 가로선 조합 찾으러 backtracking
                        backTracking(i, j, 1, limit);
                        // 최솟값이 update 됬다면 정답을 찾았다고 판단하여 return
                        if(result > 0) return;
                        // 원상태로 복귀
                        graph[i][j] = 0;
                    }
                }
            }
            limit++;
        }
        // 3이하의 가로선 추가에서 못찾은 경우
        result = -1;
    }

    static void backTracking(int curRow, int curCol, int count, int limit){
        if(count == limit){
            if(checkIsAnswer()) {
                result = count;
            }
            return;
        }

        for(int i = curRow; i <= H; i++){
            for(int j = 1; j < N; j++){
                if(i == curRow && j <= curCol) continue;
                if(graph[i][j] == 0 && graph[i][j - 1] == 0){
                    graph[i][j] = 1;
                    backTracking(i, j, count + 1, limit);
                    graph[i][j] = 0;
                }
            }
        }
    }
    
    static boolean checkIsAnswer(){
        boolean res = true;

        // 세로선 1 ~ N까지 도착점이 같은지 확인
        for(int i = 1; i <= N; i++){
            int start = i;
            
            for(int j = 1; j <= H; j++){
                // 오른쪽 가로선이 있는 경우
                if(start + 1 <= N && graph[j][start] > 0){
                    start += 1;
                }
                // 왼쪽 가로선이 있는 경우
                else if(start - 1 >= 1 && graph[j][start - 1] > 0){
                    // 왼쪽 이동
                    start -= 1;
                }
            }

            // 시작점과 도착점의 세로선이 다른 경우
            if(start != i) {
                res = false;
                break;
            }
        }

        return res;
    }
}
