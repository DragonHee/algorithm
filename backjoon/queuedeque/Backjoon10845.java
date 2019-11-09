package backjoon.queuedeque;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Backjoon10845 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        LinkedList<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            switch (command){
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    queue.push(num);
                    break;
                case "pop":
                    if(queue.isEmpty()) bw.write("-1\n");
                    else bw.write(queue.pollLast() + "\n");
                    break;
                case "size":
                    bw.write(queue.size()+ "\n");
                    break;
                case "empty":
                    if(queue.isEmpty()) bw.write("1\n");
                    else bw.write("0\n");
                    break;
                case "front":
                    if(queue.isEmpty()) bw.write("-1\n");
                    else bw.write(queue.peekLast() + "\n");
                    break;
                case "back":
                    if(queue.isEmpty()) bw.write("-1\n");
                    else bw.write(queue.peekFirst() + "\n");
                    break;
            }
        }

        bw.close();
        br.close();
    }
}
