package backjoon.stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Backjoon10828 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String input = st.nextToken();
            if(input.equals("push")) stack.push(Integer.parseInt(st.nextToken()));
            else if(input.equals("pop")) bw.write((stack.isEmpty() ? -1 : stack.pop()) + "\n");
            else if(input.equals("size")) bw.write(stack.size() + "\n");
            else if(input.equals("empty")) bw.write((stack.isEmpty() ? 1 : 0) + "\n");
            else if(input.equals("top")) bw.write((stack.isEmpty() ? -1 : stack.peek()) + "\n");
        }
        bw.close();
        br.close();
    }
}
