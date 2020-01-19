package backjoon.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Histogram{
    int index;
    int height;

    public Histogram(int index, int height) {
        this.index = index;
        this.height = height;
    }
}
public class Backjoon1725 {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int max = 0;

        for(int i = 0 ; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Stack<Histogram> stack = new Stack<>();

        for(int i = 0 ; i < n; i++){
            int index = i;
            while(!stack.isEmpty() && stack.peek().height >= arr[i]){
                max = Math.max(max, stack.peek().height * (i - stack.peek().index));
                index = stack.peek().index;
                stack.pop();
            }
            stack.push(new Histogram(index, arr[i]));
        }

        while(!stack.isEmpty()){
            max = Math.max(max, stack.peek().height * (n - stack.peek().index));
            stack.pop();
        }

        System.out.println(max);
    }
}
