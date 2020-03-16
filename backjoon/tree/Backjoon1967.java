package backjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point{
    int end;
    int weight;

    public Point(int end, int weight){
        this.end = end;
        this.weight = weight;
    }
}
public class Backjoon1967 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int INF = 10_000 * 100;
    static List<Point> list[];
    static int dist[];
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];

        for(int i = 0; i <= n ; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 2; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[parent].add(new Point(child, weight));
            list[child].add(new Point(parent, weight));
        }

        bfs(1);
        int farestIdx = 1;
        for(int i = 2; i <= n; i++) farestIdx = dist[farestIdx] > dist[i] ? farestIdx : i;

        bfs(farestIdx);
        int farestLength = 0;
        for(int i = 1; i <= n; i++) farestLength = farestLength > dist[i] ? farestLength : dist[i];

        System.out.println(farestLength);
    }
    public static void bfs(int start){
        Queue<Point> queue = new LinkedList<>();
        dist = new int[n + 1];
        Arrays.fill(dist, INF);

        queue.add(new Point(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()){
            Point curPoint = queue.poll();

            for(Point p : list[curPoint.end]){
                if(dist[p.end] == INF){
                    dist[p.end] = curPoint.weight + p.weight;
                    queue.add(new Point(p.end, dist[p.end]));
                }
            }
        }
    }
}
