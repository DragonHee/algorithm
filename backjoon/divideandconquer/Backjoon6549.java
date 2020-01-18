package backjoon.divideandconquer;


import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

class Info{
    int idx;
    long height;

    public Info(int idx, long height) {
        this.idx = idx;
        this.height = height;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }
}
public class Backjoon6549 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            arr = new long[n];
            if(n == 0) break;

            for(int i = 0 ; i < n ; i++)
                arr[i] = Long.parseLong(st.nextToken());

            Stack<Info> stack = new Stack<>();
            long area = 0;
            for(int i = 0 ; i < n; i++){
                int idx = i;

                while(!stack.isEmpty() && arr[i] <= arr[stack.peek().getIdx()]){
                    long tempArea = stack.peek().height * (i - stack.peek().getIdx());
                    area = Math.max(tempArea, area);
                    idx = stack.peek().getIdx();
                    stack.pop();
                    System.out.println(area);
                }
                stack.push(new Info(i, arr[i]));
            }

            while(!stack.isEmpty()){
                long tempArea = stack.peek().height * (n - stack.peek().getIdx());
                area = Math.max(tempArea, area);
                stack.pop();
            }

            System.out.println(area);

        }
        br.close();
    }
}
