package backjoon.minpath;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon11404 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = 100 * 100_000;
    static int n, m;
    static int arr[][];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];

        // 입력받은 값으로 변수 초기화
        init();
        // 플로이드 와샬 알고리즘
        floydWarshall();

        // 출력을 위한 객체
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                // 무한대가 저장되어 있으면 경로가 없다는 의미이므로
                // 0을 출력한다.
                sb.append((arr[i][j] != INF ? arr[i][j] : 0) + " ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        bw.close();
        br.close();
    }

    private static void init() throws IOException {
        for(int i = 0 ; i <= n; i++)
            Arrays.fill(arr[i], INF);

        // 자기 자신으로 가는 경로 0으로 초기화
        for(int i = 1; i <= n; i++)
            arr[i][i] = 0;

        for(int i = 0 ; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 기존의 값보다 작은 값이 들어오면 갱신해준다.
            arr[start][end] = Math.min(cost, arr[start][end]);
        }
    }

    private static void floydWarshall() {
        // 경유 노드
        for(int i = 1; i <= n; i++){
            // 시작 노드
            for(int j = 1; j <= n; j++){
                // 시작 노드 != 경유 노드
                if(i != j) {
                    // 도착 노드
                    for (int k = 1; k <= n; k++) {
                        // 시작노드 != 도착노드 && 도착노드 != 경유노드
                        if(j != k && i != k){
                            // 기존의 값 보다 경유한 값이 작은 경우
                            if(arr[j][k] > arr[j][i] + arr[i][k]){
                                arr[j][k] = arr[j][i] + arr[i][k];
                            }
                        }
                    }
                }
            }
        }
    }
}
