package backjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
class Node{
    int end;
    int dis;

    public Node(int end, int dis){
        this.end = end;
        this.dis = dis;
    }
}
public class Backjoon1167 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int V = Integer.parseInt(br.readLine());
        List<Node> listArr[] = new ArrayList[V + 1];

        for(int i = 0 ; i <= V; i++){
            listArr[i] = new ArrayList<>();
        }

        while(V-- > 0){
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
    }
}
