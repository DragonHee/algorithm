package backjoon.bfsdfs;

import java.util.*;
import java.io.*;

public class Backjoon11724 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[][] map;
    static boolean[] check;
    static int CNT;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        check = new boolean[N + 1];
        CNT = 0;

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start][end] = map[end][start] = 1;
        }  

        solve();

        bw.write(CNT + "\n");
        
        bw.close();
        br.close();
    }

    static void solve(){
        for(int i = 1; i <= N; i++){
            if(check[i] == true) continue;
            bfs(i);
            CNT++;
        }
    }

    static void bfs(int node){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(node);
        check[node] = true;

        while(!queue.isEmpty()){
            int start = queue.poll();

            for(int i = 1; i <= N; i++){
                if(map[start][i] == 0) continue;
                if(check[i] == true) continue;

                queue.add(i);
                check[i] = true;
            }
        }

    }
    
}
