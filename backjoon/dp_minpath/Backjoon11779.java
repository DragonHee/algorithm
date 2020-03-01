package backjoon.dp_minpath;

import java.io.*;
import java.util.*;

class Bus implements Comparable<Bus>{
    int end;
    int cost;

    public Bus(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Bus o) {
        return cost - o.cost;
    }
}
public class Backjoon11779 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int INF = 1_000 * 100_000;
    static ArrayList<Bus> busList[];
    static int dist[];
    static int start, end;
    static int n, m;
    static int parent[];
    static int cityCnt;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        busList = new ArrayList[n + 1];

        for(int i = 1 ; i <= n; i++){
            busList[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            busList[start].add(new Bus(end, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];
        parent = new int[n + 1];
        Arrays.fill(dist, INF);

        dijkstra();
        Stack<Integer> stack = searchPath();

        while(!stack.isEmpty()){
            int city = stack.pop();
            sb.append(city + " ");
        }

        bw.write(dist[end] + "\n");
        bw.write(cityCnt + "\n");
        bw.write(sb.toString());

        bw.close();
        br.close();
    }

    public static void dijkstra(){
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        boolean check[] = new boolean[n + 1];

        pq.add(new Bus(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Bus curBus = pq.poll();
            int cur = curBus.end;

            if(check[cur] == true) continue;
            check[cur] = true;

            for(Bus bus : busList[cur]){
                if(dist[bus.end] > dist[cur] + bus.cost){
                    dist[bus.end] = dist[cur] + bus.cost;
                    pq.add(new Bus(bus.end, dist[bus.end]));

                    parent[bus.end] = cur;
                }
            }
        }
    }

    public static Stack<Integer> searchPath(){
        Stack<Integer> stack = new Stack<>();

        int cur = end;

        while(cur != start) {
            stack.push(cur);
            cityCnt++;

            cur = parent[cur];
        }
        stack.push(cur);
        cityCnt++;

        return stack;
    }
}
