package backjoon.queuedeque;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Backjoon11866 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] arr;
    private static LinkedList<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        for(int i = 1; i <= n; i++) queue.push(i);

        solve(k);
    }
    private static void solve(int k){

    }
}
