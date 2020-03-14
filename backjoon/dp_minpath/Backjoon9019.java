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
    static char register[];

    // 결과 값 출력을 위한 객체 선언
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 입력 값 처리
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // 미방문인 경우 false
            // 방문인 경우 true
            visited = new boolean[MAX];
            // 경로를 찾기 위해 부모노드의 값을 저장한다.
            parent = new int[MAX];
            // 어떤 연산을 사용했는지를 저장한다.
            register = new char[MAX];

            // BFS를 위한 큐 선언
            Queue<Integer> queue = new LinkedList<>();
            // 시작 노드를 큐에 추가
            queue.add(A);
            // 시작 노드를 방문 처리한다.
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
                // D 명령을 한 값이 미방문인 경우
                if(visited[D] == false){
                    visited[D] = true;
                    parent[D] = cur;
                    register[D] = 'D';
                    queue.add(D);
                }

                // S function
                // S 명령을 한 값이 미방문인 경우
                if(visited[S] == false){
                    visited[S] = true;
                    parent[S] = cur;
                    register[S] = 'S';
                    queue.add(S);
                }

                // L function
                // L 명령을 한 값이 미방문인 경우
                if(visited[L] == false){
                    visited[L] = true;
                    parent[L] = cur;
                    register[L] = 'L';
                    queue.add(L);
                }

                // R function
                // R 명령을 한 값이 미방문인 경우
                if(visited[R] == false){
                    visited[R] = true;
                    parent[R] = cur;
                    register[R] = 'R';
                    queue.add(R);
                }

                // 도달하고자 하는 노드가 방문인 경우
                // 경로를 찾는다.
                if(visited[B] == true) {
                    int curValue = B;

                    while(curValue != A){
                        int parentValue = parent[curValue];

                        sb.append(register[curValue]);
                        curValue = parentValue;
                    }
                    // 역순으로 연산을 sb에 append했기 때문에
                    // reverse하여 출력한다.
                    bw.write(sb.reverse().append("\n").toString());
                    break;
                }
            }

        }
        bw.close();
        br.close();
    }
}
