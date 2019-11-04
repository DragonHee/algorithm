package backjoon.stack;

import java.io.*;
import java.util.Stack;

public class Backjoon10773 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int k = Integer.parseInt(br.readLine());
        int num = 0, tot = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < k; i++){
            num = Integer.parseInt(br.readLine());
            if(num == 0) stack.pop();
            else stack.push(num);
        }
        while(!stack.isEmpty()) tot += stack.pop();
        bw.write(tot + "\n");
        bw.close();
        br.close();
    }
}
