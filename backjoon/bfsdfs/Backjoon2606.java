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

        for(int i = 1; i <= m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());

            isEdge[nodeA][nodeB] = isEdge[nodeB][nodeA] = true;
        }

        solve(isEdge, check, n);
    }
    public static void solve(boolean[][] isEdge, boolean[] check, int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        check[1] = true;
        int ans = 0;

        while(!queue.isEmpty()){
            int num = queue.poll();
            ans++;

            for(int i = 1; i <= n; i++){
                if(i != num && isEdge[num][i] == true && check[i] == false){
                    queue.add(i);
                    check[i] = true;
                }
            }
        }

        System.out.println(ans - 1);
    }
}
