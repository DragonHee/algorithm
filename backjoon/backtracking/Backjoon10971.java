package backjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;


public class Backjoon10971 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[][] graph;


    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException{
        N = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];

        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int j = 0 ; j < N; j++){
                graph[i + 1][j + 1] = Integer.parseInt(st.nextToken());
            }
        }

        solve();

        bw.write(answer + "\n");
        bw.close();
        br.close();
    }

    static void solve(){
        boolean check[] = new boolean[N + 1];

        for(int i = 1; i <= N; i++){
            check[i] = true;
            combination(i, i, 0, check, 0);
            check[i] = false;
        }
    }

    static void combination(int startNode, int curNode, int count, boolean[] check, int depth){
        if(count == N) {
            answer = Math.min(answer, depth);
            return;
        }

        if(count == N - 1){
            if(graph[curNode][startNode] != 0){
                combination(startNode, startNode, count + 1, check, depth + graph[curNode][startNode]);
            }
        }
        else{
            for(int i = 1; i <= N; i++){
                if(check[i] == true) continue;
                if(graph[curNode][i] == 0) continue;
                
                check[i] = true;
                combination(startNode, i, count + 1, check, depth + graph[curNode][i]);
                check[i] = false;
            }
        }
    }
}
