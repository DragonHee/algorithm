package backjoon.minpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int end, weight;
    public Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }
}
public class Backjoon1753 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int INF = 100_000_000;
    static int v,e,k;
    static List<Node>[] list;
    static boolean[] check;
    static int[] dist;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        list = new ArrayList[v + 1];
        dist = new int[v + 1];
        check = new boolean[v + 1];

        Arrays.fill(dist, INF);

        for(int i = 1; i <= v; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, weight));
        }

        StringBuilder sb = new StringBuilder();
        dijkstra(k);

        for(int i = 1; i <= v; i++){
            if(dist[i] == INF) sb.append("INF\n");
            else sb.append(dist[i] + "\n");
        }
        System.out.println(sb);
    }

    private static void dijkstra(int startNode){
       dist[startNode] = 0;

       while(true){
           int minIndex = getMinNodeIndex();
           if(minIndex == -1) break;
           check[minIndex] = true;

           for(int i = 0; i < list[minIndex].size(); i++){
               int nextNode = list[minIndex].get(i).end;
               int weight = list[minIndex].get(i).weight;

               if(dist[nextNode] > dist[minIndex] + weight){
                   dist[nextNode] = dist[minIndex] + weight;
               }
           }
       }

    }
    private static int getMinNodeIndex(){
        int min = INF, minIndex = -1;

        for(int i = 1; i <= v; i++){
            if(check[i] == false && dist[i] < min) {
                min = dist[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

}
