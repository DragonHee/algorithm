package backjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon1697 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, k;
    static int isVisit[];
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        isVisit = new int[100_001];

        int answer = solve();
        System.out.println(answer);
    }
    public static int solve(){
        int result = -1;
        // 형의 시작 노드 큐에 추가
        queue.add(n);
        // 방문 처리
        isVisit[n] = 1;

        while (!queue.isEmpty()){
            int location = queue.poll();
            // 큐에서 꺼낸 값이 동생의 위치인 경우
            if(location == k) {
                result = isVisit[location];
                break;
            }

            if(checkLocation(location - 1)){
                queue.add(location - 1);
                isVisit[location - 1] = isVisit[location] + 1;
            }
            if(checkLocation(location + 1)){
                queue.add(location + 1);
                isVisit[location + 1] = isVisit[location] + 1;
            }
            if(checkLocation(location * 2)){
                queue.add(location * 2);
                isVisit[location * 2] = isVisit[location] + 1;
            }
        }
        // 시작점을 1 초 걸린다고 잡았으므로 -1 한 값을 반환
        return result - 1;
    }

    private static boolean checkLocation(int i) {
        if(i < 0 || i > 100_000) return false;

        if(isVisit[i] > 0) return false;
        else return true;
    }
}
