package backjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon2606 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[][] isEdge = new boolean[n + 1][n + 1];
        boolean[] check = new boolean[n + 1];

        // 간선정보 초기화
        for(int i = 1; i <= m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());

            // (1,2)가 간선이라면 (2,1)도 간선이다.
            isEdge[nodeA][nodeB] = isEdge[nodeB][nodeA] = true;
        }

        solve(isEdge, check, n);
    }

    // bfs로 풀이한다.
    public static void solve(boolean[][] isEdge, boolean[] check, int n){
        Queue<Integer> queue = new LinkedList<>();
        // 시작점 큐에 추가
        queue.add(1);
        check[1] = true;
        int ans = 0;

        while(!queue.isEmpty()){
            // 노드를 하나 꺼낸다.
            int num = queue.poll();
            // 갈수 있는 노드의 개수를 증가시킨다.
            ans++;

            for(int i = 1; i <= n; i++){
                // 현재 노드와 다른 노드 && 간선 존재 && 미방문한 노드
                if(i != num && isEdge[num][i] == true && check[i] == false){
                    queue.add(i);
                    // 방문 노드로 만듬
                    check[i] = true;
                }
            }
        }

        System.out.println(ans - 1);
    }
}
