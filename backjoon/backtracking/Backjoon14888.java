package backjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon14888 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int n;
    private static int val;
    private static int[] arr;
    private static char[] op;
    private static boolean[] visited;
    private static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        op = new char[n];
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int idx = 1;
        for(int i = 1 ; i <= 4; i++){
            int cnt = Integer.parseInt(st.nextToken());
            if(i == 1) for(int j = 1; j <= cnt; j++) op[idx++] = '+';
            else if(i == 2) for(int j = 1; j <= cnt; j++) op[idx++] = '-';
            else if(i == 3) for(int j = 1; j <= cnt; j++) op[idx++] = '*';
            else if(i == 4) for(int j = 1; j <= cnt; j++) op[idx++] = '/';
        }

        val = arr[1];
        solve(1);

        bw.write(max + "\n" + min + "\n");
        br.close();
        bw.close();
    }
    private static void solve(int index){
        if(index == n) {
            min = Math.min(val, min);
            max = Math.max(val, max);
            return;
        }
        for(int i = 1; i <= n - 1; i++){
            if(!visited[i]){
                int curVal = val;
                char c = op[i];
                if(c == '+') val += arr[index + 1];
                else if(c == '-') val -= arr[index + 1];
                else if(c == '*') val *= arr[index + 1];
                else if(c == '/') val /= arr[index + 1];
                visited[i] = true;
                solve(index + 1);
                val = curVal;
                visited[i] = false;
            }
        }
    }
}
