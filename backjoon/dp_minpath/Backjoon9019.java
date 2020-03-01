package backjoon.dp_minpath;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon9019 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int MAX = 10000;
    static boolean visited[];
    static int parent[];

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            visited = new boolean[MAX];
            parent = new int[MAX];

            StringBuilder sb = new StringBuilder();
            Queue<Integer> queue = new LinkedList<>();
            queue.add(A);
            visited[A] = true;

            while(true){
                int cur = queue.poll();

                int msb = cur / 1000;
                int lsb = cur % 10;

                int D = (cur * 2) % MAX;
                int S = cur == 0 ? MAX - 1: cur - 1;
                int L = (cur * 10 + msb) % MAX;
                int R = cur / 10 + lsb * 1000;

                // D function
                if(visited[D] == false){
                    visited[D] = true;
                    parent[D] = cur;
                    queue.add(D);
                }

                // S function
                if(visited[S] == false){
                    visited[S] = true;
                    parent[S] = cur;
                    queue.add(S);
                }

                // L function
                if(visited[L] == false){
                    visited[L] = true;
                    parent[L] = cur;
                    queue.add(L);
                }

                // R function
                if(visited[R] == false){
                    visited[R] = true;
                    parent[R] = cur;
                    queue.add(R);
                }

                if(visited[B] != false) {
                    int curValue = B;

                    while(true){
                        int parentValue = parent[curValue];

                        int pMsb = parentValue / 1000;
                        int pLsb = parentValue % 10;

                        int PD = (parentValue * 2) % MAX;
                        int PS = parentValue == 0 ? MAX - 1: parentValue - 1;
                        int PL = (parentValue * 10 + pMsb) % MAX;
                        int PR = parentValue / 10 + pLsb * 1000;

                        if(PD == curValue) sb.append('D');
                        else if(PS == curValue) sb.append('S');
                        else if(PL == curValue) sb.append('L');
                        else if(PR == curValue) sb.append('R');

                        curValue = parentValue;

                        if(curValue == A) break;
                    }

                    break;
                }
            }
            bw.write(sb.reverse().toString() + "\n");
        }
        bw.close();
        br.close();
    }
}
