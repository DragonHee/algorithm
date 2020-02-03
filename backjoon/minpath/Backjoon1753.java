package backjoon.minpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon1753 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int v,e,k;
    static int[][] arr;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        arr = new int[v + 1][v + 1];
        visited = new boolean[v + 1];

        for(int i = 0 ; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            arr[start][end] = weight;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= v; i++){
            init();
            answer = Integer.MAX_VALUE;
            visited[k] = true;
            dfs(k, i, 0);
            if(answer == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(answer + "\n");
        }
        System.out.println(sb);
    }
    private static void init(){
        for(int i = 1; i <= v; i++) visited[i] = false;
    }

    private static void dfs(int curNode, int destNode, int weight) {
        if(curNode == destNode) {
            answer = Math.min(answer, weight);
            return;
        }

        for(int i = 1; i <= v; i++){
            if(arr[curNode][i] > 0 && !visited[i]) {
                visited[i] = true;
                dfs(i, destNode, weight + arr[curNode][i]);
                visited[i] = false;
            }
        }
    }
}
