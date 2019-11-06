package backjoon.stack;

import java.io.*;
import java.util.Stack;

public class Backjoon9012 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String input = br.readLine();
            if(isVPS(input)) bw.write("YES\n");
            else bw.write("NO\n");
        }
        bw.close();
        br.close();
    }
    public static boolean isVPS(String input) throws IOException {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < input.length(); i++){
            if(input.charAt(i) == '(') stack.push(i);
            else {
                if(!stack.isEmpty()) stack.pop();
                else return false;
            }
        }
        if(stack.size() != 0) return false;
        return true;
    }
}
