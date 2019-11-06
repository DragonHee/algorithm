package backjoon.stack;

import java.io.*;
import java.util.Stack;

public class Backjoon1874 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        if(solve(n)) bw.write(sb.toString());
        else bw.write("NO");

        bw.close();
        br.close();
    }
    public static boolean solve(int n) throws IOException {
        Stack<Integer> stk = new Stack<>();
        int curVal = 1;

        while(n-- > 0){
            int num = Integer.parseInt(br.readLine());

            if(num >= curVal){
                for(int i = curVal; i <= num; i++){
                    stk.push(i);
                    sb.append("+\n");
                }
                curVal = num + 1;
            }
            else if(stk.peek() != num) return false;
            stk.pop();
            sb.append("-\n");
        }
        return true;
    }
}
