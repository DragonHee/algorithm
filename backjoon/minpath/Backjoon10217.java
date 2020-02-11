package backjoon.minpath;

import java.io.*;
import java.util.*;

class AirPlane implements Comparable<AirPlane>{
    int end;
    int cost;
    int time;

    public AirPlane(int end, int cost, int time){
        this.end = end;
        this.cost = cost;
        this.time = time;
    }

    @Override
    public int compareTo(AirPlane airPlane) {
        if(this.time == airPlane.time) return cost - airPlane.cost;
        return this.time - airPlane.time;
    }
}

public class Backjoon10217{
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = 100 * 10_000;

    static int n, m, k;
    static List<AirPlane> list[];
    // dp[i][j] = k -> i번 노드까지 j비용 사용시  최소 비행 시간
    static int dp[][];

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(t-- > 0){
            init();
            int result = dijkstra(1);
            sb.append(result == INF ? "Poor KCM\n" : result + "\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static int dijkstra(int start) {
       int result = INF;

       PriorityQueue<AirPlane> queue = new PriorityQueue<>();
       queue.add(new AirPlane(start, 0, 0));
       // start번 노드까지 가는데 0 비용으로 갔을 때의 최소 시간
       dp[start][0] = 0;

       while(!queue.isEmpty()){
           AirPlane airPlane = queue.poll();
           int node = airPlane.end;
           int cost = airPlane.cost;

           // node번에서 출발하는 그래프에 대한 반복문
           for(AirPlane toAirplane : list[node]){
               int toNode = toAirplane.end;
               int toCost = cost + toAirplane.cost;
               int toTime = dp[node][cost] + toAirplane.time;

               // 주어진 비용보다 크면 확인할 필요가 없다.
               if(toCost > m) continue;
               // 현재 구한 최소값보다 큰 경우 필요가 없다.
               if(toTime > result) continue;
               // 마지막 노드를 추가하는 경우
               if(toNode == n){
                   // 최소값을 저장한다.
                   result = toTime;
                   continue;
               }
               if(dp[toNode][toCost] > toTime) {
                   if (dp[toNode][toCost] == INF)
                       queue.add(new AirPlane(toNode, toCost, toTime));
                   dp[toNode][toCost] = toTime;
               }
           }
       }

       return result;
    }

    private static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new int[n + 1][m + 1];
        list = new ArrayList[n + 1];

        for(int i = 0 ; i <= n; i++) {
            list[i] = new ArrayList<>();
            Arrays.fill(dp[i], INF);
        }

        while(k-- > 0){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            list[start].add(new AirPlane(end, cost, time));
        }
    }
}

