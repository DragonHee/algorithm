package backjoon.stack;

import java.io.*;
import java.util.Stack;

public class Backjoon4949 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input;

        while(!(input = br.readLine()).equals(".")){
            if(isVPS(input))bw.write("yes\n");
            else bw.write("no\n");
        }
        bw.close();
        br.close();
    }
    public static boolean isVPS(String input){
        int i = 0 ;
        Stack<Character> stack = new Stack<>();
        while(true){
            char c = input.charAt(i++);

            if(c == '.') break;
            else if(c == '(' || c == '['){
                stack.push(c);
            }
            else if(c == ')'){
                if(stack.isEmpty()) return false;

                if(stack.peek() != '(') return false;
                else stack.pop();
            }
            else if(c == ']'){
                if(stack.isEmpty()) return false;

                if(stack.peek() != '[') return false;
                else stack.pop();
            }
        }
        if(stack.size() != 0) return false;
        return true;
    }
}
