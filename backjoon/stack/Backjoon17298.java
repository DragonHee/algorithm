package backjoon.stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Backjoon17298 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] ans = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() <= arr[i]) stack.pop();
            if(stack.isEmpty()) ans[i] = -1;
            else ans[i] = stack.peek();
            stack.push(arr[i]);
        }

        for(int i = 0; i < n; i++) bw.write(ans[i] + " ");
        bw.close();
        br.close();
    }
}
