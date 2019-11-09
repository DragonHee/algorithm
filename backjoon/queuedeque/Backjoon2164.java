package backjoon.queuedeque;

import java.io.*;
import java.util.LinkedList;

public class Backjoon2164 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static LinkedList<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++) queue.push(i);
        solve(n);
        bw.close();
        br.close();
    }
    private static void solve(int n) throws IOException {
        while(n != 1){
            queue.pollLast();
            queue.push(queue.pollLast());
            n--;
        }
        bw.write(queue.poll() + "\n");
    }

}
