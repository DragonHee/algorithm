package backjoon.queuedeque;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Backjoon10866 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        LinkedList<Integer> deque = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String op = st.nextToken();
            int num = 0;
            switch (op){
                case "push_front":
                    num = Integer.parseInt(st.nextToken());
                    deque.addFirst(num);
                    break;
                case "push_back":
                    num = Integer.parseInt(st.nextToken());
                    deque.addLast(num);
                    break;
                case "pop_front":
                    if(deque.isEmpty()) bw.write("-1\n");
                    else bw.write(deque.pollFirst() + "\n");
                    break;
                case "pop_back":
                    if(deque.isEmpty()) bw.write("-1\n");
                    else bw.write(deque.pollLast() + "\n");
                    break;
                case "size":
                    bw.write(deque.size() + "\n");
                    break;
                case "empty":
                    if(deque.isEmpty()) bw.write("1\n");
                    else bw.write("0\n");
                    break;
                case "front":
                    if(deque.isEmpty()) bw.write("-1\n");
                    else bw.write(deque.peekFirst() + "\n");
                    break;
                case "back":
                    if(deque.isEmpty()) bw.write("-1\n");
                    else bw.write(deque.peekLast() + "\n");
                    break;
            }
        }
        bw.close();
        br.close();
    }
}
