package backjoon.minpath;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon1956 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // 무한대를 뜻한다. 경로가 없다는 뜻
    // |V - 1| * 최대 거리 가 최대 거리가 된다.
    private static final int INF = 400 * 10_000;
    static int v, e, result = INF;
    static int arr[][];

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        // 그래프 정보를 저장한다.
        arr = new int[v + 1][v + 1];
        // 초기에는 경로가 없는 것처럼 무한대로 설정한다.
        for(int i = 0; i <= v; i++)
            Arrays.fill(arr[i], INF);

        // 입력 값에 따른 그래프 갱신
        for(int i = 0 ; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            arr[start][end] = Math.min(arr[start][end], dist);
        }

        // 플로이드 와샬
        for(int i = 1; i <= v; i++){
            for(int j = 1; j <= v; j++){
                for(int k = 1; k <= v; k++){
                    if(arr[j][k] > arr[j][i] + arr[i][k]){
                        arr[j][k] = arr[j][i] + arr[i][k];
                    }
                }
            }
        }

        // 최소 사이클 중 최솟값을 구한다.
        for(int i = 1 ; i <= v; i++)
            result = Math.min(arr[i][i], result);

        // 최솟값이 INF 라면 경로가 없다는 뜻이다.
        if(result == INF) bw.write("-1\n");
        // 최솟값이 INF가 아니라면 경로가 있다는 뜻이므로 최솟값을 출력한다.
        else bw.write(result + "\n");

        bw.close();
        br.close();
    }
}
