package backjoon.minpath;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Backjoon11657 {
    static class Node implements Comparable<Node>{
        int end, weight;
        public Node(int end, int weight){this.end = end; this.weight = weight;}

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = 500 * 10_000;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[][] = new int[n + 1][n + 1];
        int dist[] = new int[n + 1];
        boolean check[] = new boolean[n + 1];

        for(int i = 0 ; i <= n; i++){
            Arrays.fill(arr[i], INF);
            dist[i] = INF;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            arr[start][end] = time;
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0));
        dist[1] = 0;

        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            int cur = curNode.end;
            int weight = curNode.weight;

            for(int i = 1; i <= n; i++){
                if(dist[i] > weight + arr[cur][i]){
                    dist[i] = weight + arr[cur][i];
                    queue.add(new Node(i, dist[i]));
                }
            }
        }

        for(int i = 2; i <= n; i++) {
            if (dist[i] < 0 || dist[i] == INF) bw.write("-1\n");
            else bw.write(dist[i] + "\n");
        }

        bw.close();
        br.close();

    }
}
