package backjoon.graph;

import java.io.*;
import java.util.*;

public class Backjoon2644 {
    static class Index{
        int value;
        int depth;
        public Index(int value, int depth){
            this.value = value;
            this.depth = depth;
        }
    }
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int x, y;
    static boolean graph[][];

    static int answer;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        graph = new boolean[n + 1][n + 1];

        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int _x = Integer.parseInt(st.nextToken());
            int _y = Integer.parseInt(st.nextToken());

            graph[_x][_y] = graph[_y][_x] = true;
        }

        solve();

        bw.write(answer + "\n");
        bw.close();
        br.close();
    }
    
    static void solve(){
        boolean[] check = new boolean[n + 1];
        Queue<Index> q = new LinkedList<>();
        q.add(new Index(x, 0));
        check[x] = true;

        while(!q.isEmpty()){
            Index curIdx = q.poll();
            int curNum = curIdx.value;
            int curDepth = curIdx.depth;

            if(curNum == y) {
                answer = curDepth;
                return;
            }

            for(int i = 1; i <= n; i++){
                if(graph[curNum][i] == false) continue;
                if(check[i] == true) continue;

                q.add(new Index(i, curDepth + 1));
                check[i] = true;
            }
        }

        answer = -1;
    }
    
}
