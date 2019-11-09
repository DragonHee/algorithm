package backjoon.queuedeque;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Backjoon11866 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] arr;
    private static LinkedList<Integer> queue = new LinkedList<>();
    private static int k;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        for(int i = 1; i <= n; i++) queue.push(i);

        solve(k);

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i = 1; i <= n; i++) {
            if(i != n) sb.append(arr[i] + ", ");
            else sb.append(arr[i] + ">");
        }
        bw.write(sb + "\n");
        bw.close();
        br.close();
    }
    private static void solve(int k){
        int idx = 1;
        while(!queue.isEmpty()){
            for(int i = 0 ; i < k; i++){
                int num = queue.pollLast();
                if(i == k - 1) arr[idx++] = num;
                else queue.push(num);
            }
        }
    }
}
