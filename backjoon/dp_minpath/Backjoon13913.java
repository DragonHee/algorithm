package backjoon.dp_minpath;

import java.io.*;
import java.util.*;

public class Backjoon13913 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int INF = 100_000;
    private static int visited[];
    private static int parent[];

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 방문 여부와 동시에 최단거리를 저장하는 배열
        visited = new int[INF + 1];
        // 부모 노드를 저장하는 배열
        parent = new int[INF + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = 1;

        Stack<Integer> path = new Stack<>();

        while(true){
            int cur = queue.poll();

            // 현재 위치 - 1이 아직 방문하지 않고
            // 유효한 범위인 경우
            if(checkLocation(cur - 1)){
                queue.add(cur - 1);
                visited[cur - 1] = visited[cur] + 1;
                // 부모노드 정보를 저장
                parent[cur - 1] = cur;
            }

            // 현재 위치 + 1이 아직 방문하지 않고
            // 유효한 범위인 경우
            if(checkLocation(cur + 1)){
                queue.add(cur + 1);
                visited[cur + 1] = visited[cur] + 1;
                // 부모노드 정보를 저장
                parent[cur + 1] = cur;
            }

            // 현재 위치 * 2이 아직 방문하지 않고
            // 유효한 범위인 경우
            if(checkLocation(cur * 2)){
                queue.add(cur * 2);
                visited[cur * 2] = visited[cur] + 1;
                // 부모노드 정보를 저장
                parent[cur * 2] = cur;
            }


            if(visited[K] != 0) {
                int cur_idx = K;

                // 부모노드를 따라가며 경로를
                // 스택 자료구조에 저장한다
                while(cur_idx != N){
                    path.push(cur_idx);
                    cur_idx = parent[cur_idx];
                }
                // 시작 노드 추가
                path.push(cur_idx);
                break;
            }
        }

        // 시작점을 1로 지정했으므로 - 1 한 값을 결과로
        // 출력한다(정확히는 출력 버퍼에 추가한다)
        bw.write(visited[K] - 1 + "\n");

        // 스택에서 빼며 경로를 출력한다
        while(!path.isEmpty()){
            bw.write(path.pop() + " ");
        }

        bw.close();
        br.close();
    }

    public static boolean checkLocation(int location){
        // 찾으려는 범위가 0 미만, 100_000 이상인 경우 false 반환
        if(location < 0 || location > INF) return false;
        // 이미 방문한 경우 false 반환
        if(visited[location] != 0) return false;

        return true;
    }
}
