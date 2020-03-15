package backjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int end;
    int weight;

    public Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }
}

public class Backjoon1167 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Node> listArr[];
    static int dist[];
    static boolean visited[];
    static int V;
    static int answer;


    public static void main(String[] args) throws IOException {
        V = Integer.parseInt(br.readLine());
        listArr = new ArrayList[V + 1];

        for(int i = 0 ; i <= V; i++){
            listArr[i] = new ArrayList<>();
        }

        for(int i = 1; i <= V; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());

            while(true){
                int end = Integer.parseInt(st.nextToken());
                if(end == -1) break;
                int distance = Integer.parseInt(st.nextToken());

                listArr[start].add(new Node(end, distance));
                listArr[end].add(new Node(start, distance));
            }
        }

        int farestNode = 1;

        bfs(farestNode);

        for(int i = 1; i <= V; i++){
            if(answer < dist[i]) {
                answer = dist[i];
                farestNode = i;
            }
        }

        answer = 0;
        bfs(farestNode);

        for(int i = 1; i <= V; i++){
            if(answer < dist[i]) {
                answer = dist[i];
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int node){
        dist = new int[V + 1];
        visited = new boolean[V + 1];
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(node, 0));
        visited[node] = true;

        while(!queue.isEmpty()){
            Node curNode = queue.poll();

            for(Node endNode : listArr[curNode.end]){
                if(visited[endNode.end] == false){
                    dist[endNode.end] = curNode.weight + endNode.weight;
                    visited[endNode.end] = true;
                    queue.add(new Node(endNode.end, dist[endNode.end]));
                }
            }
        }
    }
}
